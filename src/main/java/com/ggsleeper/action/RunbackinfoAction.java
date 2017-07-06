package com.ggsleeper.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ggsleeper.bean.CarApply;
import com.ggsleeper.bean.CarInfo;
import com.ggsleeper.bean.DriverInfo;
import com.ggsleeper.bean.Runbackinfo;
import com.ggsleeper.bean.User;
import com.ggsleeper.service.CarApplyService;
import com.ggsleeper.service.CarInfoService;
import com.ggsleeper.service.DriverInfoService;
import com.ggsleeper.service.RunbackinfoService;
import com.ggsleeper.util.Constants;
import com.ggsleeper.util.Page;
import com.ggsleeper.util.PageCounterUtil;
import com.opensymphony.xwork2.ActionContext;

public class RunbackinfoAction extends PageCounterUtil {

	// 车辆信息
	CarInfoService carInfoService;
	private CarInfo carInfo;
	private List<CarInfo> carInfoList;
	// 驾驶员信息
	DriverInfoService driverInfoService;
	private DriverInfo driverInfo;
	private List<DriverInfo> driverInfoList;
	// 申请信息
	CarApplyService CarApplyService;
	private CarApply carApply;
	

	private List<CarApply> CarApplyList;
	// 出车记录
	RunbackinfoService runbackinfoService;
	private Runbackinfo runbackinfo;
	private List<Runbackinfo> runbackinfoList;

	ActionContext cxt = ActionContext.getContext();
	HttpServletRequest request = (HttpServletRequest) cxt
			.get(ServletActionContext.HTTP_REQUEST);
	User currentUser = (User) getSession().get(Constants.USER_SESSION);

	// 可用状态和有计划状态的的车辆和司机
	public String RunbackInfoCarDriverList() {
		carInfoList=null;
		List<CarInfo> carInfoList2=carInfoService.findByProperty("infoCarstate", "有计划");
		carInfoList=carInfoService.findByProperty("infoCarstate", "可用");
		carInfoList.addAll(carInfoList2);
		
		driverInfoList=null;
		List<DriverInfo> driverInfoList2=driverInfoService.findByProperty("driverState", "有计划");
		driverInfoList=driverInfoService.findByProperty("driverState", "可用");
		driverInfoList.addAll(driverInfoList2);
		
		return "success";
	}
	
	// 忙碌状态的车辆和司机
		public String RunbackInfoCarDriverList2() {
			setCarInfoList(null);
			setCarInfoList(carInfoService.findByProperty("infoCarstate", "忙碌"));
			setDriverInfoList(null);
			setDriverInfoList(driverInfoService.findByProperty("driverState", "忙碌"));
			return "success";
		}
	

	// 保存出车
	public String saveRuninfo() {
		boolean flag = false;
		String driverName = request.getParameter("carDriver.drivereName");
		String carLpn=request.getParameter("carInfo.carLpn");
		runbackinfo.setCarlpn(carLpn);
		runbackinfo.setDrivername(driverName);
		runbackinfo.setInfostate("出车");
		
		flag = runbackinfoService.save(runbackinfo);
		if (flag) {
			// 修改车辆状态
			carInfo = carInfoService.findByProperty("infoLpn",carLpn).get(0);
			carInfo.setInfoCarstate("忙碌");
			carInfoService.save(carInfo);
			// 修改驾驶员状态
			driverInfo = null;
			driverInfo = driverInfoService.findByProperty("driverName",
					driverName).get(0);
			driverInfo.setDriverState("忙碌");
			driverInfo.setDriverNotice("");
			driverInfoService.save(driverInfo);
			return "success";
		}
		return "input";
	}
	
	// 保存进车
		public String saveRuninfo2() {
			boolean flag = false;
			String driverName = request.getParameter("carDriver.drivereName");
			String carLpn=request.getParameter("carInfo.carLpn");
			runbackinfo.setCarlpn(carLpn);
			runbackinfo.setDrivername(driverName);
			runbackinfo.setInfostate("进车");
			
			flag = runbackinfoService.save(runbackinfo);
			if (flag) {
				// 修改车辆状态
				carInfo = carInfoService.findByProperty("infoLpn",carLpn).get(0);
				carInfo.setInfoCarstate("可用");
				carInfoService.save(carInfo);
				// 修改驾驶员状态
				driverInfo = null;
				driverInfo = driverInfoService.findByProperty("driverName",
						driverName).get(0);
				driverInfo.setDriverState("可用");
				driverInfoService.save(driverInfo);
				return "success";
			}
			return "input";
		}


	// 进出车记录列表页面
	public String carRunBackInfoList() {
		runbackinfoList = null;
		
		int currentPage;
		if (request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}else{
			currentPage=1;
		}
		request.setAttribute("currentPage", currentPage);
		int startInfo=(currentPage-1)*8;
		int selectNum=8;
		String sql=" select * from tbl_runbackinfo limit "+ startInfo+","+selectNum+";" ;
		runbackinfoList=runbackinfoService.findBySql(sql);
		//分页代码
		List<Runbackinfo> runbackinfo2=runbackinfoService.findAll();
		Page page=new Page(0,8,1,0);//8条数据分一页
		page.setCount(runbackinfo2.size());//总数据数
		//判断分多少页
		if (page.getCount()%page.getPageSize()==0) {
			page.setTotalPage(page.getCount()/page.getPageSize());
		}else{
			page.setTotalPage(page.getCount()/page.getPageSize()+1);
		}
		getSession().put("CAR_IN", "进车");
		getSession().put("CAR_OUT", "出车");
		request.setAttribute("totalPage", page.getTotalPage());
		return "success";
	}

	// 审核页面
	public String carApply4List() {
		CarApplyList = null;
		CarApplyList = CarApplyService.findAll();
		return "success";
	}

	// 新增车辆信息
	public String add() {
		boolean flag = false;
		flag = CarApplyService.save(carApply);
		if (flag) {
			carApply = new CarApply();
			return "success";
		}
		return "input";
	}

	// 删除车辆信息
	public String delete() {
		boolean flag = false;
		int infoid = Integer.parseInt(request.getParameter("infoid"));
		flag = CarApplyService.delete(infoid);
		if (flag) {
			System.out.println("成功");
			return "success";
		}
		carApply = new CarApply();
		return "input";
	}

	// 更新车辆信息
	public String update() {
		System.out.println(carApply.toString());
		boolean flag = false;
		flag = CarApplyService.update(carApply);
		if (flag) {
			carApply = new CarApply();
			return "success";
		}

		return "input";
	}

	// 查询车辆信息
	public String select() {
		return null;
	}

	public CarApplyService getCarApplyService() {
		return CarApplyService;
	}

	public void setCarApplyService(CarApplyService CarApplyService) {
		this.CarApplyService = CarApplyService;
	}

	public CarApply getCarApply() {
		return carApply;
	}

	public void setCarApply(CarApply carApply) {
		this.carApply = carApply;
	}

	public List<CarApply> getCarApplyList() {
		return CarApplyList;
	}

	public void setCarApplyList(List<CarApply> CarApplyList) {
		this.CarApplyList = CarApplyList;
	}

	public CarInfoService getCarInfoService() {
		return carInfoService;
	}

	public void setCarInfoService(CarInfoService carInfoService) {
		this.carInfoService = carInfoService;
	}

	public DriverInfoService getDriverInfoService() {
		return driverInfoService;
	}

	public void setDriverInfoService(DriverInfoService driverInfoService) {
		this.driverInfoService = driverInfoService;
	}

	public CarInfo getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(CarInfo carInfo) {
		this.carInfo = carInfo;
	}

	public DriverInfo getDriverInfo() {
		return driverInfo;
	}

	public void setDriverInfo(DriverInfo driverInfo) {
		this.driverInfo = driverInfo;
	}

	public List<CarInfo> getCarInfoList() {
		return carInfoList;
	}

	public void setCarInfoList(List<CarInfo> carInfoList) {
		this.carInfoList = carInfoList;
	}

	public List<DriverInfo> getDriverInfoList() {
		return driverInfoList;
	}

	public void setDriverInfoList(List<DriverInfo> driverInfoList) {
		this.driverInfoList = driverInfoList;
	}
	public RunbackinfoService getRunbackinfoService() {
		return runbackinfoService;
	}

	public void setRunbackinfoService(RunbackinfoService runbackinfoService) {
		this.runbackinfoService = runbackinfoService;
	}

	public Runbackinfo getRunbackinfo() {
		return runbackinfo;
	}

	public void setRunbackinfo(Runbackinfo runbackinfo) {
		this.runbackinfo = runbackinfo;
	}

	public List<Runbackinfo> getRunbackinfoList() {
		return runbackinfoList;
	}

	public void setRunbackinfoList(List<Runbackinfo> runbackinfoList) {
		this.runbackinfoList = runbackinfoList;
	}

}
