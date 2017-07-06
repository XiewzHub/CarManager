package com.ggsleeper.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ggsleeper.bean.CarApply;
import com.ggsleeper.bean.CarInfo;
import com.ggsleeper.bean.DriverInfo;
import com.ggsleeper.bean.User;
import com.ggsleeper.service.CarApplyService;
import com.ggsleeper.service.CarInfoService;
import com.ggsleeper.service.DriverInfoService;
import com.ggsleeper.service.UserService;
import com.ggsleeper.util.Constants;
import com.ggsleeper.util.Page;
import com.ggsleeper.util.PageCounterUtil;
import com.opensymphony.xwork2.ActionContext;

public class CarApplyAction extends PageCounterUtil {
	UserService userService;
	private User user;
	private List<User> userList;

	CarInfoService carInfoService;
	private CarInfo carInfo;
	private List<CarInfo> carInfoList;

	DriverInfoService driverInfoService;
	private DriverInfo driverInfo;
	private List<DriverInfo> driverInfoList;

	CarApplyService CarApplyService;
	private CarApply carApply;
	private List<CarApply> CarApplyList;
	
	
	ActionContext cxt = ActionContext.getContext();
	HttpServletRequest request = (HttpServletRequest) cxt
			.get(ServletActionContext.HTTP_REQUEST);
	User currentUser = (User) getSession().get(Constants.USER_SESSION);

	// 可用状态和的车辆
	public String carApplyList() {
		int currentPage;
		if (request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}else{
			currentPage=1;
		}
		request.setAttribute("currentPage", currentPage);
		int startInfo=(currentPage-1)*8;
		int selectNum=8;
		String sql=" select * from tbl_car_info where tbl_car_info.info_carstate='可用' limit "+ startInfo+","+selectNum+";" ;
		carInfoList=carInfoService.findBySql(sql);
		//分页代码
		List<CarInfo> carInfoList2=carInfoService.findAll();
		Page page=new Page(0,8,1,0);//8条数据分一页
		page.setCount(carInfoList2.size());//总数据数
		//判断分多少页
		if (page.getCount()%page.getPageSize()==0) {
			page.setTotalPage(page.getCount()/page.getPageSize());
		}else{
			page.setTotalPage(page.getCount()/page.getPageSize()+1);
		}
		request.setAttribute("totalPage", page.getTotalPage());
		return "success";
	}

	// 保存申请
	public String carApply2List() {
		boolean flag = false;
		String driverName = request.getParameter("carDriver.drivereName");
		carApply.setCarDriver(driverName);
		carApply.setState("待审核");
		carApply.setCreatby(currentUser.getName());
		flag = CarApplyService.save(carApply);
		if (flag) {
			// 修改车辆状态
			carInfo = carInfoService.findByProperty("infoLpn",
					carApply.getCarLpn()).get(0);
			carInfo.setInfoCarstate("有计划");
			carInfoService.save(carInfo);
			// 修改驾驶员状态
			driverInfo = null;
			driverInfo = driverInfoService.findByProperty("driverName",
					driverName).get(0);
			driverInfo.setDriverState("有计划");
			driverInfoService.save(driverInfo);
			return "success";
		}
		return "input";
	}

	// 查看我的申请
	public String carApply3List() {
		CarApplyList=null;
		int currentPage;
		if (request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}else{
			currentPage=1;
		}
		request.setAttribute("currentPage", currentPage);
		int startInfo=(currentPage-1)*8;
		int selectNum=8;
		String sql=" select * from tbl_car_apply where tbl_car_apply.creatby='"+currentUser.getName()+" '  limit "+ startInfo+","+selectNum+";" ;
		CarApplyList=CarApplyService.findBySql(sql);
		//分页代码
		List<CarApply> carApply2=CarApplyService.findAll();
		Page page=new Page(0,8,1,0);//8条数据分一页
		page.setCount(carApply2.size());//总数据数
		//判断分多少页
		if (page.getCount()%page.getPageSize()==0) {
			page.setTotalPage(page.getCount()/page.getPageSize());
		}else{
			page.setTotalPage(page.getCount()/page.getPageSize()+1);
		}
		getSession().put("CAR_APPLYSTATE1", "审核通过");
		getSession().put("CAR_APPLYSTATE2", "审核中");
		request.setAttribute("totalPage", page.getTotalPage());
		return "success";
	}

	// 审核页面
	public String carApply4List() {
		CarApplyList = null;
		if(currentUser.getJob().equals("部门领导")){
			CarApplyList = CarApplyService.findByProperty("state", "待审核");
		}
		else{
			List<CarApply> carApplyList2=CarApplyService.findByProperty("state", "审核中");
			CarApplyList = CarApplyService.findByProperty("state", "待审核");
			CarApplyList.addAll(carApplyList2);
		}
		
		return "success";
	}

	// 审核通过
	public String carApplyReviewPass() {
		boolean flag = false;
		carApply = null;
		String carLpn = request.getParameter("carLpn");
		List<CarApply> carApplyf = CarApplyService.findByProperty("carLpn",
				carLpn);
		carApply=carApplyf.get(carApplyf.size()-1);
	/*	String carModel = request.getParameter("carModel");
		String godate = request.getParameter("godate");
		String backdate = request.getParameter("backdate");
		String reason = request.getParameter("reason");
		String state = request.getParameter("state");
		String carDriver = request.getParameter("carDriver");*/
		if(currentUser.getJob().equals("系统管理员")||currentUser.getJob().equals("公司领导")){
			carApply.setState("审核通过");
			DriverInfo driverInfo2=driverInfoService.findByProperty("driverName", carApply.getCarDriver()).get(0);
			User user=userService.findByProperty("name", carApply.getCreatby()).get(0);
			driverInfo2.setDriverNotice("您有出车计划："+carApply.getGodate()+"到"+carApply.getBackdate()+" 计划者为："+carApply.getCreatby()+" 车牌号码为："+carApply.getCarLpn()+" 联系号码为："+user.getUserTel());
			boolean flag2 = false;
			flag2=driverInfoService.save(driverInfo2);
			carApply.setCurrentreview(currentUser.getName());
			flag = CarApplyService.save(carApply);
			if (flag) {
				carApply = new CarApply();
				return "success";
			}
		}
		else{
			carApply.setState("审核中");
			carApply.setCurrentreview(currentUser.getName());
			flag = CarApplyService.save(carApply);
			if (flag) {
				carApply = new CarApply();
				return "success";
		}
			}
		
		return "input";
	}

	// 审核未通过
	public String carApplyReviewOut() {
		boolean flag = false;
		carApply = null;
		String carLpn = request.getParameter("carLpn");
		String carDriver = request.getParameter("carDriver");
		List<CarApply> carApplyf = CarApplyService.findByProperty("carLpn",
				carLpn);
		carApply=carApplyf.get(carApplyf.size()-1);
		carApply.setState("不通过");
		
		
		carInfo = carInfoService.findByProperty("infoLpn",
				carApply.getCarLpn()).get(0);
		carInfo.setInfoCarstate("可用");
		carInfoService.save(carInfo);
		// 修改驾驶员状态
		driverInfo = null;
		driverInfo = driverInfoService.findByProperty("driverName",
				carDriver).get(0);
		driverInfo.setDriverState("可用");
		driverInfoService.save(driverInfo);
		flag = CarApplyService.update(carApply);
		if (flag) {
			return "success";
		}
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
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
