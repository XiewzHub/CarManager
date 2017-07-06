package com.ggsleeper.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ggsleeper.bean.DriverInfo;
import com.ggsleeper.service.DriverInfoService;
import com.ggsleeper.util.Page;
import com.ggsleeper.util.PageCounterUtil;
import com.opensymphony.xwork2.ActionContext;

public class DriverInfoAction extends PageCounterUtil {
	DriverInfoService driverInfoService;
	private DriverInfo driverInfo;
	private List<DriverInfo> driverInfoList;
	ActionContext cxt = ActionContext.getContext();
	HttpServletRequest request = (HttpServletRequest) cxt
			.get(ServletActionContext.HTTP_REQUEST);

	public String driverInfoList() {
		int currentPage;
		if (request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}else{
			currentPage=1;
		}
		request.setAttribute("currentPage", currentPage);
		int startInfo=(currentPage-1)*8;
		int selectNum=8;
		String sql=" select * from tbl_driver_info limit "+ startInfo+","+selectNum+";" ;
		driverInfoList=driverInfoService.findBySql(sql);
		//分页代码
		List<DriverInfo> driverInfo2=driverInfoService.findAll();
		Page page=new Page(0,8,1,0);//8条数据分一页
		page.setCount(driverInfo2.size());//总数据数
		//判断分多少页
		if (page.getCount()%page.getPageSize()==0) {
			page.setTotalPage(page.getCount()/page.getPageSize());
		}else{
			page.setTotalPage(page.getCount()/page.getPageSize()+1);
		}
		getSession().put("DRIVER_STATEPLAN", "有计划");
		getSession().put("DRIVER_STATEBUSY", "忙碌");
		request.setAttribute("totalPage", page.getTotalPage());
		return "success";
	}
	//显示可用状态状态的司机
	public String driverAppplyList() {
		driverInfoList=null;
		String lpn=request.getParameter("lpn");
		String model=request.getParameter("model");
		request.setAttribute("lpn", lpn);
		request.setAttribute("model", model);
		/*List<DriverInfo> driverInfoList2 = driverInfoService.findByProperty("driverState", "有计划");*/
		driverInfoList = driverInfoService.findByProperty("driverState", "可用");
	/*	driverInfoList.addAll(driverInfoList2);*/
		return "success";
	}

	// 新增驾驶员信息
	public String add() {
		boolean flag = false;
		flag = driverInfoService.save(driverInfo);
		if (flag) {
			driverInfo = new DriverInfo();
			return "success";
		}
		return "input";
	}

	// 删除驾驶员信息
	public String delete() {
		boolean flag = false;
		int infoid = Integer.parseInt(request.getParameter("infoid"));
		flag = driverInfoService.delete(infoid);
		if (flag) {
			driverInfo = new DriverInfo();
			return "success";
		}

		return "input";
	}

	// 更新驾驶员信息
	public String update() {
		boolean flag = false;
		flag = driverInfoService.update(driverInfo);
		if (flag) {
			driverInfo = new DriverInfo();
			return "success";
		}

		return "input";
	}

	public DriverInfoService getDriverInfoService() {
		return driverInfoService;
	}

	public void setDriverInfoService(DriverInfoService driverInfoService) {
		this.driverInfoService = driverInfoService;
	}

	public DriverInfo getDriverInfo() {
		return driverInfo;
	}

	public void setDriverInfo(DriverInfo driverInfo) {
		this.driverInfo = driverInfo;
	}

	public List<DriverInfo> getDriverInfoList() {
		return driverInfoList;
	}

	public void setDriverInfoList(List<DriverInfo> driverInfoList) {
		this.driverInfoList = driverInfoList;
	}
	
	
}
