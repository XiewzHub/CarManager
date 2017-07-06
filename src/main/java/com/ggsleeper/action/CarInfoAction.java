package com.ggsleeper.action;

import java.util.ArrayList;
import java.util.List;








import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ggsleeper.bean.CarInfo;
import com.ggsleeper.dao.impl.CarInfoDaoImpl;
import com.ggsleeper.service.CarInfoService;
import com.ggsleeper.util.Page;
import com.ggsleeper.util.PageCounterUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CarInfoAction extends PageCounterUtil {
	CarInfoService carInfoService;
	private CarInfo carInfo;
	private List<CarInfo> carInfoList;
	ActionContext cxt=ActionContext.getContext();
	HttpServletRequest request=(HttpServletRequest) cxt.get(ServletActionContext.HTTP_REQUEST);

	public String carInfoList() {
		int currentPage;
		if (request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}else{
			currentPage=1;
		}
		request.setAttribute("currentPage", currentPage);
		int startInfo=(currentPage-1)*8;
		int selectNum=8;
		String sql=" select * from tbl_car_info limit "+ startInfo+","+selectNum+";" ;
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
		getSession().put("CAR_STATEPLAN", "有计划");
		getSession().put("CAR_STATEBUSY", "忙碌");
		request.setAttribute("totalPage", page.getTotalPage());
		return "success";
	}
	

	// 新增车辆信息
	public String add() {
		boolean flag=false;
		flag=carInfoService.save(carInfo);
		if(flag){
			carInfo=new CarInfo();
			return "success";
		}
		return "input";
	}

	// 删除车辆信息
	public String delete() {
		boolean flag=false;
		int infoid=Integer.parseInt(request.getParameter("infoid"));
		flag=carInfoService.delete(infoid);
		if(flag){
			return "success";
		}
		carInfo=new CarInfo();
		return "input";
	}

	// 更新车辆信息
	public String update() {
		System.out.println(carInfo.toString());
		boolean flag=false;
		flag=carInfoService.update(carInfo);
		if(flag){
			carInfo=new CarInfo();
			return "success";
		}

		return "input";
	}

	// 查询车辆信息
	public String select() {
		return null;
	}

	public CarInfoService getCarInfoService() {
		return carInfoService;
	}

	public void setCarInfoService(CarInfoService carInfoService) {
		this.carInfoService = carInfoService;
	}

	public CarInfo getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(CarInfo carInfo) {
		this.carInfo = carInfo;
	}
	public List<CarInfo> getCarInfoList() {
		return carInfoList;
	}

	public void setCarInfoList(List<CarInfo> carInfoList) {
		this.carInfoList = carInfoList;
	}
}
