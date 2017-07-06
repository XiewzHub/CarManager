package com.ggsleeper.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import sun.rmi.transport.proxy.HttpReceiveSocket;

import com.opensymphony.xwork2.ActionContext;


public abstract class PageCounterUtil {
	private Integer pageSize = 10;	// 每页显示多少条数据
	private Integer pageCount = 1;	// 当前显示是第几页
	private Integer totalSize = 0;	// 总页数
	private Integer totalCount = 0; // 总共多少条数据
	
	private Integer pageProjectSize = 10;	// 每页显示多少条数据
	private Integer pageProjectCount = 1;	// 当前显示是第几页
	private Integer totalProjectSize = 0;	// 总页数
	private Integer totalProjectCount = 0; // 总共多少条数据
	
	private Integer pagecostSize = 10;	// 每页显示多少条数据
	private Integer pagecostCount = 1;	// 当前显示是第几页
	private Integer totalcostSize = 0;	// 总页数
	private Integer totalcostCount = 0; // 总共多少条数据
	
	private Integer pageclaimSize = 10;	// 每页显示多少条数据
	private Integer pageclaimCount = 1;	// 当前显示是第几页
	private Integer totalclaimSize = 0;	// 总页数
	private Integer totalclaimCount = 0; // 总共多少条数据
	
	private Integer pagenotcommitclaimSize = 10;	// 每页显示多少条数据
	private Integer pagenotcommitclaimCount = 1;	// 当前显示是第几页
	private Integer totalnotcommitclaimSize = 0;	// 总页数
	private Integer totalnotcommitclaimCount = 0; // 总共多少条数据
	
	private Integer pagebusinessprocessSize = 10;	// 每页显示多少条数据
	private Integer pagebusinessprocessCount = 1;	// 当前显示是第几页
	private Integer totalbusinessprocessSize = 0;	// 总页数
	private Integer totalbusinessprocessCount = 0; // 总共多少条数据
	/**公章**/
	private Integer pageSealSize = 10;	// 每页显示多少条数据
	private Integer pageSealCount = 1;	// 当前显示是第几页
	private Integer totalSealSize = 0;	// 总页数
	private Integer totalSealCount = 0; // 总共多少条数据
	/**签报**/
	private Integer pageSignSize = 10;	// 每页显示多少条数据
	private Integer pageSignCount = 1;	// 当前显示是第几页
	private Integer totalSignSize = 0;	// 总页数
	private Integer totalSignCount = 0; // 总共多少条数据
	
	/**通用签报**/
	private Integer pageSignGeneralSize = 10;	// 每页显示多少条数据
	private Integer pageSignGeneralCount = 1;	// 当前显示是第几页
	private Integer totalSignGeneralSize = 0;	// 总页数
	private Integer totalSignGeneralCount = 0; // 总共多少条数据
	
	//绩效目标
	private Integer pagePerformTargetSize = 10;	// 每页显示多少条数据
	private Integer pagePerformTargetCount = 1;	// 当前显示是第几页
	private Integer totalPerformTargetSize = 0;	// 总页数
	private Integer totalPerformTargetCount = 0; // 总共多少条数据
	//绩效评估
	private Integer pagePerformEstimateSize = 10;	// 每页显示多少条数据
	private Integer pagePerformEstimateCount = 1;	// 当前显示是第几页
	private Integer totalPerformEstimateSize = 0;	// 总页数
	private Integer totalPerformEstimateCount = 0; // 总共多少条数据

	//公司设立
	private Integer pageCompanyFoundSize = 20;	// 每页显示多少条数据
	protected Integer pageCompanyFoundCount = 1;	// 当前显示是第几页
	private Integer totalCompanyFoundSize = 0;	// 总页数
	private Integer totalCompanyFoundCount = 0; // 总共多少条数据

	
	//出资申请
	private Integer pageProjectInvestmentSize = 20;	// 每页显示多少条数据
	protected Integer pageProjectInvestmentCount = 1;	// 当前显示是第几页
	private Integer totalProjectInvestmentSize = 0;	// 总页数
	private Integer totalProjectInvestmentCount = 0; // 总共多少条数据
	
	//公司付款
	private Integer pageCompanyPaySize = 20;	// 每页显示多少条数据
	protected Integer pageCompanyPayCount = 1;	// 当前显示是第几页
	private Integer totalCompanyPaySize = 0;	// 总页数
	private Integer totalCompanyPayCount = 0; // 总共多少条数据
	
	//月度绩效
	private Integer pageMonthlyScoreSize = 10;//	每页显示多少条数据
	private Integer pageMonthlyScoreCount = 1;//	当前显示是第几页
	private Integer totalMonthlyScoreSize = 0;//	总页数
	private Integer totalMonthlyScoreCount = 0;//	总共多少条数据
	
	//请假申请
	private Integer pageTakeLeaveSize = 10;//  每页显示多少条数据
	private Integer pageTakeLeaveCount = 1;//  当前显示是第几页
	private Integer totalTakeLeaveSize = 0;//   总页数
	private Integer totalTakeLeaveCount = 0;//	总共多少条数据
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getpageSize(List pageList,String currentMenu){
		setPageSizeToSession(pageSize);
		List list = new ArrayList();
		
		if(pageList!=null&&pageList.size()>0){
			totalCount = pageList.size();
			if(currentMenu!=null && pageCount<1){
				pageCount = 1;
			}
			int base = ((pageCount-1)*pageSize);
			if(base<0)
				base=0;			
			if(totalCount<=pageSize){
				pageCount =  1;
				totalSize =1;
				return pageList;
			}else{
				if(pageSize != 0)
				totalSize = totalCount/pageSize+(totalCount%pageSize==0?0:1);
			}
			if(pageCount<1 && currentMenu!=null)
				pageCount=1;
			
			for(int i = 0; i < pageSize; i++) {
				if((base+i)<=(totalCount-1))
					list.add(pageList.get(base+i));
			}
		}else{
			pageCount =  0;
			totalSize =  0;
			totalCount = 0;
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getprojectpageSize(List pageList,String currentMenu){
		setProjectPageSizeToSession(pageProjectSize);
		List list = new ArrayList();
		
		if(pageList!=null&&pageList.size()>0){
			totalProjectCount = pageList.size();
			if(currentMenu!=null){
				pageProjectCount = 1;
			}
			int base = ((pageProjectCount-1)*pageProjectSize);
			if(base<0)
				base=0;			
			if(totalProjectCount<=pageProjectSize){
				pageProjectCount =  1;
				totalProjectSize =1;
				return pageList;
			}else{
				if(pageProjectSize != 0)
					totalProjectSize = totalProjectCount/pageProjectSize+(totalProjectCount%pageProjectSize==0?0:1);
			}
			if(pageProjectCount==0||currentMenu!=null)
				pageProjectCount=1;
			
			for(int i = 0; i < pageProjectSize; i++) {
				if((base+i)<=(totalProjectCount-1))
					list.add(pageList.get(base+i));
			}
		}else{
			pageProjectCount =  0;
			totalProjectSize =  0;
			totalProjectCount = 0;
		}
		return list;
	}
	
	
	public List getMonthlyScoreSize(List pageList,String currentMenu){
		setClaimPageSizeToSession(pageMonthlyScoreSize);
		List list = new ArrayList();
		
		if(pageList!=null&&pageList.size()>0){
			totalMonthlyScoreCount = pageList.size();
			if(currentMenu!=null && pageMonthlyScoreCount<1){
				pageMonthlyScoreCount = 1;
			}
			int base = ((pageMonthlyScoreCount-1)*pageMonthlyScoreSize);
			if(base<0)
				base=0;
			if(totalMonthlyScoreCount<=pageMonthlyScoreSize){
				pageMonthlyScoreCount =  1;
				totalMonthlyScoreSize = 1;
				return pageList;
			}else{
				if(pageMonthlyScoreSize != 0)
					totalMonthlyScoreSize = totalMonthlyScoreCount/pageMonthlyScoreSize+(totalMonthlyScoreCount%pageMonthlyScoreSize==0?0:1);
			}
			if(pageMonthlyScoreCount<1&&currentMenu!=null)
				pageMonthlyScoreCount=1;
			
			for(int i = 0; i < pageMonthlyScoreSize; i++) {
				if((base+i)<=(totalMonthlyScoreCount-1))
					list.add(pageList.get(base+i));
			}
		}else{
			pageMonthlyScoreCount =  0;
			totalMonthlyScoreSize =  0;
			totalMonthlyScoreCount = 0;
		}
		return list;
	}
	
	
	//请假申请分页
	public List getTakeLeaveSize(List pageList,String currentMenu){
		setTakeLeavePageSizeToSession(pageTakeLeaveSize);
		List list = new ArrayList();
		
		if(pageList!=null&&pageList.size()>0){
			totalTakeLeaveCount = pageList.size();
			if(currentMenu!=null){
				pageTakeLeaveCount = 1;
			}
			int base = ((pageTakeLeaveCount-1)*pageTakeLeaveSize);
			if(base<0)
				base=0;
			if(totalTakeLeaveCount<=pageTakeLeaveSize){
				pageTakeLeaveCount =  1;
				totalTakeLeaveSize = 1;
				return pageList;
			}else{
				if(pageTakeLeaveSize != 0)
					totalTakeLeaveSize = totalTakeLeaveCount/pageTakeLeaveSize+(totalTakeLeaveCount%pageTakeLeaveSize==0?0:1);
			}
			if(pageTakeLeaveCount==0||currentMenu!=null)
				pageTakeLeaveCount=1;
			
			for(int i = 0; i < pageTakeLeaveSize; i++) {
				if((base+i)<=(totalTakeLeaveCount-1))
					list.add(pageList.get(base+i));
			}
		}else{
			pageTakeLeaveCount =  0;
			totalTakeLeaveSize =  0;
			totalTakeLeaveCount = 0;
		}
		return list;
	}
	

	public List getcostpageSize(List pageList,String currentMenu){
		setCostPageSizeToSession(pagecostSize);
		List list = new ArrayList();
		
		if(pageList!=null&&pageList.size()>0){
			totalcostCount = pageList.size();
			if(currentMenu!=null){
				pagecostCount = 1;
			}
			int base = ((pagecostCount-1)*pagecostSize);
			if(base<0)
				base=0;
			if(totalcostCount<=pagecostSize){
				pagecostCount =  1;
				totalcostSize =1;
				return pageList;
			}else{
				if(pagecostSize != 0)
					totalcostSize = totalcostCount/pagecostSize+(totalcostCount%pagecostSize==0?0:1);
			}
			if(pagecostCount==0||currentMenu!=null)
				pagecostCount=1;
			
			for(int i = 0; i < pagecostSize; i++) {
				if((base+i)<=(totalcostCount-1))
					list.add(pageList.get(base+i));
			}
		}else{
			pagecostCount =  0;
			totalcostSize =  0;
			totalcostCount = 0;
		}
		return list;
	}
	
	
	public List getclaimpageSize(List pageList,String currentMenu){
		setClaimPageSizeToSession(pageclaimSize);
		List list = new ArrayList();
		
		if(pageList!=null&&pageList.size()>0){
			totalclaimCount = pageList.size();
			if(currentMenu!=null){
				pageclaimCount = 1;
			}
			int base = ((pageclaimCount-1)*pageclaimSize);
			if(base<0)
				base=0;
			if(totalclaimCount<=pageclaimSize){
				pageclaimCount =  1;
				totalclaimSize =1;
				return pageList;
			}else{
				if(pageclaimSize != 0)
					totalclaimSize = totalclaimCount/pageclaimSize+(totalclaimCount%pageclaimSize==0?0:1);
			}
			if(pageclaimCount==0||currentMenu!=null)
				pageclaimCount=1;
			
			for(int i = 0; i < pageclaimSize; i++) {
				if((base+i)<=(totalclaimCount-1))
					list.add(pageList.get(base+i));
			}
		}else{
			pageclaimCount =  0;
			totalclaimSize =  0;
			totalclaimCount = 0;
		}
		return list;
	}
	
	
	
	public List getnotcommitclaimpageSize(List pageList,String currentMenu){
		setNotCommitClaimPageSizeToSession(pagenotcommitclaimSize);
		List list = new ArrayList();
		
		if(pageList!=null&&pageList.size()>0){
			totalnotcommitclaimCount = pageList.size();
			if(currentMenu!=null){
				pagenotcommitclaimCount = 1;
			}
			int base = ((pagenotcommitclaimCount-1)*pagenotcommitclaimSize);
			if(base<0)
				base=0;
			if(totalnotcommitclaimCount<=pagenotcommitclaimSize){
				pagenotcommitclaimCount =  1;
				totalnotcommitclaimSize =1;
				return pageList;
			}else{
				if(pagenotcommitclaimSize != 0)
					totalnotcommitclaimSize = totalnotcommitclaimCount/pagenotcommitclaimSize+(totalnotcommitclaimCount%pagenotcommitclaimSize==0?0:1);
			}
			if(pagenotcommitclaimCount==0||currentMenu!=null)
				pagenotcommitclaimCount=1;
			
			for(int i = 0; i < pagenotcommitclaimSize; i++) {
				if((base+i)<=(totalnotcommitclaimCount-1))
					list.add(pageList.get(base+i));
			}
		}else{
			pagenotcommitclaimCount =  0;
			totalnotcommitclaimSize =  0;
			totalnotcommitclaimCount = 0;
		}
		return list;
	}
	
	
	public List getSealApplySize(List pageList,String currentMenu){
		setSealApplyPageSizeToSession(pageSealSize);
		List list = new ArrayList();

		if(pageList!=null&&pageList.size()>0){
			totalSealCount = pageList.size();
			if(currentMenu!=null){
				pageSealCount = 1;
			}
			int base = ((pageSealCount-1)*pageSealSize);
			if(base<0)
				base=0;
			if(totalSealCount<=pageSealSize){
				pageSealCount =  1;
				totalSealSize =1;
				return pageList;
			}else{
				if(pageSealSize != 0)
					totalSealSize = totalSealCount/pageSealSize+(totalSealCount%pageSealSize==0?0:1);
			}
			if(pageSealCount==0||currentMenu!=null)
				pageSealCount=1;
			
			for(int i = 0; i < pageSealSize; i++) {
				if((base+i)<=(totalSealCount-1))
					list.add(pageList.get(base+i));
			}
		}else{
			pageSealCount =  0;
			totalSealSize =  0;
			totalSealCount = 0;
		}
		return list;
	}
	
	
	public List getSignApplySize(List pageList,String currentMenu){
		setSignApplyPageSizeToSession(pageSignSize);
		List list = new ArrayList();
		
		if(pageList!=null&&pageList.size()>0){
			totalSignCount = pageList.size();
			if(currentMenu!=null){
				pageSignCount = 1;
			}
			int base = ((pageSignCount-1)*pageSignSize);
			if(base<0)
				base=0;
			if(totalSignCount<=pageSignSize){
				pageSignCount =  1;
				totalSignSize =1;
				return pageList;
			}else{
				if(pageSignSize != 0)
					totalSignSize = totalSignCount/pageSignSize+(totalSignCount%pageSignSize==0?0:1);
			}
			if(pageSignCount==0||currentMenu!=null)
				pageSignCount=1;
			
			for(int i = 0; i < pageSignSize; i++) {
				if((base+i)<=(totalSignCount-1))
					list.add(pageList.get(base+i));
			}
		}else{
			pageSignCount =  0;
			totalSignSize =  0;
			totalSignCount = 0;
		}
		return list;
	}
	
	public List getSignApplyGeneralSize(List pageList,String currentMenu){
		setSignApplyGeneralPageSizeToSession(pageSignGeneralSize);
		List list = new ArrayList();
		
		if(pageList!=null&&pageList.size()>0){
			totalSignGeneralCount = pageList.size();
			if(currentMenu!=null){
				pageSignGeneralCount = 1;
			}
			int base = ((pageSignGeneralCount-1)*pageSignGeneralSize);
			if(base<0)
				base=0;
			if(totalSignGeneralCount<=pageSignGeneralSize){
				pageSignGeneralCount =  1;
				totalSignGeneralSize =1;
				return pageList;
			}else{
				if(pageSignGeneralSize != 0)
					totalSignGeneralSize = totalSignGeneralCount/pageSignGeneralSize+(totalSignGeneralCount%pageSignGeneralSize==0?0:1);
			}
			if(pageSignGeneralCount==0||currentMenu!=null)
				pageSignGeneralCount=1;
			
			for(int i = 0; i < pageSignGeneralSize; i++) {
				if((base+i)<=(totalSignGeneralCount-1))
					list.add(pageList.get(base+i));
			}
		}else{
			pageSignGeneralCount =  0;
			totalSignGeneralSize =  0;
			totalSignGeneralCount = 0;
		}
		return list;
	}
	
	
	public List getPerformTargetSize(List pageList,String currentMenu){
		setPerformTargetPageSizeToSession(pagePerformTargetSize);
		List list = new ArrayList();
		
		if(pageList!=null&&pageList.size()>0){
			totalPerformTargetCount = pageList.size();
			if(currentMenu!=null){
				pagePerformTargetCount = 1;
			}
			int base = ((pagePerformTargetCount-1)*pagePerformTargetSize);
			if(base<0)
				base=0;
			if(totalPerformTargetCount<=pagePerformTargetSize){
				pagePerformTargetCount =  1;
				totalPerformTargetSize =1;
				return pageList;
			}else{
				if(pagePerformTargetSize != 0)
					totalPerformTargetSize = totalPerformTargetCount/pagePerformTargetSize+(totalPerformTargetCount%pagePerformTargetSize==0?0:1);
			}
			if(pagePerformTargetCount==0||currentMenu!=null)
				pagePerformTargetCount=1;
			
			for(int i = 0; i < pagePerformTargetSize; i++) {
				if((base+i)<=(totalPerformTargetCount-1))
					list.add(pageList.get(base+i));
			}
		}else{
			pagePerformTargetCount =  0;
			totalPerformTargetSize =  0;
			totalPerformTargetCount = 0;			
		}
		return list;
	}
	
	public List getProjectInvestmentSize(List pageList,String currentMenu){
		setProjectInvestmentPageSizeToSession(pageProjectInvestmentSize);
		List list = new ArrayList();
		
		if(pageList!=null&&pageList.size()>0){
			totalProjectInvestmentCount = pageList.size();
			if(currentMenu!=null){
				pageProjectInvestmentCount = 1;
			}
			int base = ((pageProjectInvestmentCount-1)*pageProjectInvestmentSize);
			if(base<0)
				base=0;
			if(totalProjectInvestmentCount<=pageProjectInvestmentSize){
				pageProjectInvestmentCount =  1;
				totalProjectInvestmentSize =1;
				return pageList;
			}else{
				if(pageProjectInvestmentSize != 0)
					totalProjectInvestmentSize = totalProjectInvestmentCount/pageProjectInvestmentSize+(totalProjectInvestmentCount%pageProjectInvestmentSize==0?0:1);
			}
			if(pageProjectInvestmentCount==0||currentMenu!=null)
				pageProjectInvestmentCount=1;
			
			for(int i = 0; i < pageProjectInvestmentSize; i++) {
				if((base+i)<=(totalProjectInvestmentCount-1))
					list.add(pageList.get(base+i));
			}
		}else{
			pageProjectInvestmentCount =  0;
			totalProjectInvestmentSize =  0;
			totalProjectInvestmentCount = 0;
		}
		return list;
	}
	
	public List getCompanyPaySize(List pageList,String currentMenu){
		setProjectInvestmentPageSizeToSession(pageCompanyPaySize);
		List list = new ArrayList();
		
		if(pageList!=null&&pageList.size()>0){
			totalCompanyPayCount = pageList.size();
			if(currentMenu!=null){
				pageCompanyPayCount = 1;
			}
			int base = ((pageCompanyPayCount-1)*pageCompanyPaySize);
			if(base<0)
				base=0;
			if(totalCompanyPayCount<=pageCompanyPaySize){
				pageCompanyPayCount =  1;
				totalCompanyPaySize =1;
				return pageList;
			}else{
				if(pageCompanyPaySize != 0)
					totalCompanyPaySize = totalCompanyPayCount/pageCompanyPaySize+(totalCompanyPayCount%pageCompanyPaySize==0?0:1);
			}
			if(pageCompanyPayCount==0||currentMenu!=null)
				pageCompanyPayCount=1;
			
			for(int i = 0; i < pageCompanyPaySize; i++) {
				if((base+i)<=(totalCompanyPayCount-1))
					list.add(pageList.get(base+i));
			}
		}else{
			pageCompanyPayCount =  0;
			totalCompanyPaySize =  0;
			totalCompanyPayCount = 0;
		}
		return list;
	}
	
	public List getPerformEstimateSize(List pageList,String currentMenu){
		setPerformEstimateSizeToSession(pagePerformEstimateSize);
		List list = new ArrayList();
		
		if(pageList!=null&&pageList.size()>0){
			totalPerformEstimateCount = pageList.size();
			if(currentMenu!=null){
				pagePerformEstimateCount  = 1;
			}
			int base = ((pagePerformEstimateCount -1)*pagePerformEstimateSize);
			if(base<0)
				base=0;			
			if(totalPerformEstimateCount<=pagePerformEstimateSize){
				pagePerformEstimateCount =  1;
				totalPerformEstimateSize =1;
				return pageList;
			}else{
				if(pagePerformEstimateSize != 0)
					totalPerformEstimateSize = totalPerformEstimateCount/pagePerformEstimateSize+(totalPerformEstimateCount%pagePerformEstimateSize==0?0:1);
			}
			if(pagePerformEstimateCount==0||currentMenu!=null)
				pagePerformEstimateCount=1;
			
			for(int i = 0; i < pagePerformEstimateSize; i++) {
				if((base+i)<=(totalPerformEstimateCount-1))
					list.add(pageList.get(base+i));
			}
		}else{
			pagePerformEstimateCount =  0;
			totalPerformEstimateSize =  0;
			totalPerformEstimateCount = 0;			
		}
		
		return list;
	}
	
	public List getCompanyFoundSize(List pageList,String currentMenu){
		setCompanyFoundPageSizeToSession(pageCompanyFoundSize);
		List list = new ArrayList();
		
		if(pageList!=null&&pageList.size()>0){
			totalCompanyFoundCount = pageList.size();			
			if(currentMenu!=null){
				pageCompanyFoundCount  = 1;
			}
			int base = ((pageCompanyFoundCount -1)*pageCompanyFoundSize);
			if(base<0)
				base=0;			
			if(totalCompanyFoundCount<=pageCompanyFoundSize){
				pageCompanyFoundCount =  1;
				totalCompanyFoundSize =1;
				return pageList;
			}else{
				if(pageCompanyFoundSize != 0)
					totalCompanyFoundSize = totalCompanyFoundCount/pageCompanyFoundSize+(totalCompanyFoundCount%pageCompanyFoundSize==0?0:1);
			}
			if(pageCompanyFoundCount==0||currentMenu!=null)
				pageCompanyFoundCount=1;
			
			for(int i = 0; i < pageCompanyFoundSize; i++) {
				if((base+i)<=(totalCompanyFoundCount-1))
					list.add(pageList.get(base+i));
			}
			
		}else{
			pageCompanyFoundCount =  0;
			totalCompanyFoundSize  =  0;
			totalCompanyFoundCount = 0;			
		}
		return list;
	}
	
	public List getbusinessprocesspageSize(List pageList,String currentMenu){
		setBusinessProcessPageSizeToSession(pagebusinessprocessSize);
		List list = new ArrayList();
		
		if(pageList!=null&&pageList.size()>0){
			totalbusinessprocessCount = pageList.size();	
			if(currentMenu!=null){
				pagebusinessprocessCount  = 1;
			}
			int base = ((pagebusinessprocessCount -1)*pagebusinessprocessSize);
			if(base<0)
				base=0;			
			if(totalbusinessprocessCount<=pagebusinessprocessSize){
				pagebusinessprocessCount =  1;
				totalbusinessprocessSize =1;
				return pageList;
			}else{
				if(pagebusinessprocessSize != 0)
					totalbusinessprocessSize = totalbusinessprocessCount/pagebusinessprocessSize+(totalbusinessprocessCount%pagebusinessprocessSize==0?0:1);
			}
			if(pagebusinessprocessCount==0||currentMenu!=null)
				pagebusinessprocessCount=1;
			
			for(int i = 0; i < pagebusinessprocessSize; i++) {
				if((base+i)<=(totalbusinessprocessCount-1))
					list.add(pageList.get(base+i));
			}
		}else{
			pagebusinessprocessCount =  0;
			totalbusinessprocessSize =  0;
			totalbusinessprocessCount = 0;
		}
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public void setApplicationContext(String arg0,Object arg1){
//		HttpServletRequest request=getRequest();
//		ServletContext context=request.getSession().getServletContext();
//		Object o=context.getAttribute(arg0);
//		if(o!=null){
//			Map sessionMap=(Map) o;
//			sessionMap.remove(Constants.USER_SESSION);
//		}
//		context.setAttribute(arg0, arg1);
	}
	@SuppressWarnings("unchecked")
	public void setPageSizeToSession(Integer pageSize){
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE,pageSize);
		}
		this.pageSize=Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE)+"");
	}
	public void setProjectInvestmentPageSizeToSession(Integer pageSize){
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE_PROJECT_INVESTMENT);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE_PROJECT_INVESTMENT,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE_PROJECT_INVESTMENT,pageSize);
		}
		this.pageProjectInvestmentSize=Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE_PROJECT_INVESTMENT)+"");
	}
	public void setCompanyPayPageSizeToSession(Integer pageSize){
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE_COMPANY_PAY);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE_COMPANY_PAY,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE_COMPANY_PAY,pageSize);
		}
		this.pageCompanyPaySize=Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE_COMPANY_PAY)+"");
	}
	public void setCompanyFoundPageSizeToSession(Integer pageSize){
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE_COMPANY_FOUND);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE_COMPANY_FOUND,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE_COMPANY_FOUND,pageSize);
		}
		this.pageCompanyFoundSize=Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE_COMPANY_FOUND)+"");
	}
	
	private void setPerformEstimateSizeToSession(Integer pageSize) {
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE_JXPGSP);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE_JXPGSP,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE_JXPGSP,pageSize);
		}
		this.pagePerformEstimateSize = Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE_JXPGSP)+"");
	}
	
	private void setBusinessProcessPageSizeToSession(Integer pageSize) {
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE_BUSINESS_PROCESS);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE_BUSINESS_PROCESS,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE_BUSINESS_PROCESS,pageSize);
		}
		this.pagebusinessprocessSize = Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE_BUSINESS_PROCESS)+"");
	}
	
	private void setPerformTargetPageSizeToSession(Integer pageSize) {
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE_JXMBSP);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE_JXMBSP,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE_JXMBSP,pageSize);
		}
		this.pagePerformTargetSize = Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE_JXMBSP)+"");
	}
	
	private void setSignApplyPageSizeToSession(Integer pageSize) {
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE_QBHB);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE_QBHB,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE_QBHB,pageSize);
		}
		this.pageSignSize = Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE_QBHB)+"");
		
	}
	
	private void setSignApplyGeneralPageSizeToSession(Integer pageSize) {
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE_TYQB);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE_TYQB,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE_TYQB,pageSize);
		}
		this.pageSignGeneralSize = Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE_TYQB)+"");
	}
	
	private void setSealApplyPageSizeToSession(Integer pageSize) {
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE_YZSQ);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE_YZSQ,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE_YZSQ,pageSize);
		}
		this.pageSealSize = Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE_YZSQ)+"");
	}
	
	private void setNotCommitClaimPageSizeToSession(Integer pageSize) {
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE_FYCLBX_NOT);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE_FYCLBX_NOT,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE_FYCLBX_NOT,pageSize);
		}
		this.pagenotcommitclaimSize = Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE_FYCLBX_NOT)+"");
	}
	
	private void setClaimPageSizeToSession(Integer pageSize) {
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE_FYCLBX);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE_FYCLBX,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE_FYCLBX,pageSize);
		}
		this.pageclaimSize = Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE_FYCLBX)+"");
	}
	
	private void setCostPageSizeToSession(Integer pageSize) {
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE_FYCLSQ);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE_FYCLSQ,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE_FYCLSQ,pageSize);
		}
		this.pagecostSize = Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE_FYCLSQ)+"");
	}
	

	private void setProjectPageSizeToSession(Integer pageSize) {
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE_PROJECT);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE_PROJECT,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE_PROJECT,pageSize);
		}
		this.pageProjectSize = Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE_PROJECT)+"");
	}
	
	private void setMonthlyScorePageSizeToSession(Integer pageSize) {
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE_YDPF);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE_YDPF,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE_YDPF,pageSize);
		}
		this.pageMonthlyScoreSize = Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE_YDPF)+"");
	}
	
	private void setTakeLeavePageSizeToSession(Integer pageSize) {
		Object oldSizeObj=getSession().get(Constants.USER_SESSION_PAGE_SIZE_QJSQ);
		if(oldSizeObj!=null){
			Integer oldSize=Integer.valueOf(oldSizeObj+"");
			if(oldSize.intValue()!=pageSize.intValue()){
				getSession().put(Constants.USER_SESSION_PAGE_SIZE_QJSQ,pageSize);
			}
		}else{
			getSession().put(Constants.USER_SESSION_PAGE_SIZE_QJSQ,pageSize);
		}
		this.pageTakeLeaveSize = Integer.valueOf(getSession().get(Constants.USER_SESSION_PAGE_SIZE_QJSQ)+"");
	}
	
	
	@SuppressWarnings("rawtypes")
	public Map getSession() {
		return ActionContext.getContext().getSession();
	}
	public  HttpServletRequest getRequest() {
		return (HttpServletRequest) ActionContext.getContext().get(
				ServletActionContext.HTTP_REQUEST);
	}

	public  HttpServletResponse getResponse() {
		return (HttpServletResponse) ActionContext.getContext().get(
				ServletActionContext.HTTP_RESPONSE);
	}
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPagecostSize() {
		return pagecostSize;
	}
	public void setPagecostSize(Integer pagecostSize) {
		this.pagecostSize = pagecostSize;
	}
	public Integer getPagecostCount() {
		return pagecostCount;
	}
	public void setPagecostCount(Integer pagecostCount) {
		this.pagecostCount = pagecostCount;
	}
	public Integer getTotalcostSize() {
		return totalcostSize;
	}
	public void setTotalcostSize(Integer totalcostSize) {
		this.totalcostSize = totalcostSize;
	}
	public Integer getTotalcostCount() {
		return totalcostCount;
	}
	public void setTotalcostCount(Integer totalcostCount) {
		this.totalcostCount = totalcostCount;
	}
	public Integer getPageclaimSize() {
		return pageclaimSize;
	}
	public void setPageclaimSize(Integer pageclaimSize) {
		this.pageclaimSize = pageclaimSize;
	}
	public Integer getPageclaimCount() {
		return pageclaimCount;
	}
	public void setPageclaimCount(Integer pageclaimCount) {
		this.pageclaimCount = pageclaimCount;
	}
	public Integer getTotalclaimSize() {
		return totalclaimSize;
	}
	public void setTotalclaimSize(Integer totalclaimSize) {
		this.totalclaimSize = totalclaimSize;
	}
	public Integer getTotalclaimCount() {
		return totalclaimCount;
	}
	public void setTotalclaimCount(Integer totalclaimCount) {
		this.totalclaimCount = totalclaimCount;
	}
	public Integer getPagenotcommitclaimSize() {
		return pagenotcommitclaimSize;
	}
	public void setPagenotcommitclaimSize(Integer pagenotcommitclaimSize) {
		this.pagenotcommitclaimSize = pagenotcommitclaimSize;
	}
	public Integer getPagenotcommitclaimCount() {
		return pagenotcommitclaimCount;
	}
	public void setPagenotcommitclaimCount(Integer pagenotcommitclaimCount) {
		this.pagenotcommitclaimCount = pagenotcommitclaimCount;
	}
	public Integer getTotalnotcommitclaimSize() {
		return totalnotcommitclaimSize;
	}
	public void setTotalnotcommitclaimSize(Integer totalnotcommitclaimSize) {
		this.totalnotcommitclaimSize = totalnotcommitclaimSize;
	}
	public Integer getTotalnotcommitclaimCount() {
		return totalnotcommitclaimCount;
	}
	public void setTotalnotcommitclaimCount(Integer totalnotcommitclaimCount) {
		this.totalnotcommitclaimCount = totalnotcommitclaimCount;
	}
	public Integer getPagebusinessprocessSize() {
		return pagebusinessprocessSize;
	}
	public void setPagebusinessprocessSize(Integer pagebusinessprocessSize) {
		this.pagebusinessprocessSize = pagebusinessprocessSize;
	}
	public Integer getPagebusinessprocessCount() {
		return pagebusinessprocessCount;
	}
	public void setPagebusinessprocessCount(Integer pagebusinessprocessCount) {
		this.pagebusinessprocessCount = pagebusinessprocessCount;
	}
	public Integer getTotalbusinessprocessSize() {
		return totalbusinessprocessSize;
	}
	public void setTotalbusinessprocessSize(Integer totalbusinessprocessSize) {
		this.totalbusinessprocessSize = totalbusinessprocessSize;
	}
	public Integer getTotalbusinessprocessCount() {
		return totalbusinessprocessCount;
	}
	public void setTotalbusinessprocessCount(Integer totalbusinessprocessCount) {
		this.totalbusinessprocessCount = totalbusinessprocessCount;
	}
	public Integer getPageSealSize() {
		return pageSealSize;
	}
	public void setPageSealSize(Integer pageSealSize) {
		this.pageSealSize = pageSealSize;
	}
	public Integer getPageSealCount() {
		return pageSealCount;
	}
	public void setPageSealCount(Integer pageSealCount) {
		this.pageSealCount = pageSealCount;
	}
	public Integer getTotalSealSize() {
		return totalSealSize;
	}
	public void setTotalSealSize(Integer totalSealSize) {
		this.totalSealSize = totalSealSize;
	}
	public Integer getTotalSealCount() {
		return totalSealCount;
	}
	public void setTotalSealCount(Integer totalSealCount) {
		this.totalSealCount = totalSealCount;
	}
	public Integer getPageSignSize() {
		return pageSignSize;
	}
	public void setPageSignSize(Integer pageSignSize) {
		this.pageSignSize = pageSignSize;
	}
	public Integer getPageSignCount() {
		return pageSignCount;
	}
	public void setPageSignCount(Integer pageSignCount) {
		this.pageSignCount = pageSignCount;
	}
	public Integer getTotalSignSize() {
		return totalSignSize;
	}
	public void setTotalSignSize(Integer totalSignSize) {
		this.totalSignSize = totalSignSize;
	}
	public Integer getTotalSignCount() {
		return totalSignCount;
	}
	public void setTotalSignCount(Integer totalSignCount) {
		this.totalSignCount = totalSignCount;
	}
	
	public Integer getPageSignGeneralSize() {
		return pageSignGeneralSize;
	}

	public void setPageSignGeneralSize(Integer pageSignGeneralSize) {
		this.pageSignGeneralSize = pageSignGeneralSize;
	}

	public Integer getPageSignGeneralCount() {
		return pageSignGeneralCount;
	}

	public void setPageSignGeneralCount(Integer pageSignGeneralCount) {
		this.pageSignGeneralCount = pageSignGeneralCount;
	}

	public Integer getTotalSignGeneralSize() {
		return totalSignGeneralSize;
	}

	public void setTotalSignGeneralSize(Integer totalSignGeneralSize) {
		this.totalSignGeneralSize = totalSignGeneralSize;
	}

	public Integer getTotalSignGeneralCount() {
		return totalSignGeneralCount;
	}

	public void setTotalSignGeneralCount(Integer totalSignGeneralCount) {
		this.totalSignGeneralCount = totalSignGeneralCount;
	}

	public Integer getPagePerformTargetSize() {
		return pagePerformTargetSize;
	}
	public void setPagePerformTargetSize(Integer pagePerformTargetSize) {
		this.pagePerformTargetSize = pagePerformTargetSize;
	}
	public Integer getPagePerformTargetCount() {
		return pagePerformTargetCount;
	}
	public void setPagePerformTargetCount(Integer pagePerformTargetCount) {
		this.pagePerformTargetCount = pagePerformTargetCount;
	}
	public Integer getTotalPerformTargetSize() {
		return totalPerformTargetSize;
	}
	public void setTotalPerformTargetSize(Integer totalPerformTargetSize) {
		this.totalPerformTargetSize = totalPerformTargetSize;
	}
	public Integer getTotalPerformTargetCount() {
		return totalPerformTargetCount;
	}
	public void setTotalPerformTargetCount(Integer totalPerformTargetCount) {
		this.totalPerformTargetCount = totalPerformTargetCount;
	}
	public Integer getPagePerformEstimateSize() {
		return pagePerformEstimateSize;
	}
	public void setPagePerformEstimateSize(Integer pagePerformEstimateSize) {
		this.pagePerformEstimateSize = pagePerformEstimateSize;
	}
	public Integer getPagePerformEstimateCount() {
		return pagePerformEstimateCount;
	}
	public void setPagePerformEstimateCount(Integer pagePerformEstimateCount) {
		this.pagePerformEstimateCount = pagePerformEstimateCount;
	}
	public Integer getTotalPerformEstimateSize() {
		return totalPerformEstimateSize;
	}
	public void setTotalPerformEstimateSize(Integer totalPerformEstimateSize) {
		this.totalPerformEstimateSize = totalPerformEstimateSize;
	}
	public Integer getTotalPerformEstimateCount() {
		return totalPerformEstimateCount;
	}
	public void setTotalPerformEstimateCount(Integer totalPerformEstimateCount) {
		this.totalPerformEstimateCount = totalPerformEstimateCount;
	}

	public Integer getPageCompanyFoundSize() {
		return pageCompanyFoundSize;
	}
	public void setPageCompanyFoundSize(Integer pageCompanyFoundSize) {
		this.pageCompanyFoundSize = pageCompanyFoundSize;
	}
	public Integer getPageCompanyFoundCount() {
		return pageCompanyFoundCount;
	}
	public void setPageCompanyFoundCount(Integer pageCompanyFoundCount) {
		this.pageCompanyFoundCount = pageCompanyFoundCount;
	}
	public Integer getTotalCompanyFoundSize() {
		return totalCompanyFoundSize;
	}
	public void setTotalCompanyFoundSize(Integer totalCompanyFoundSize) {
		this.totalCompanyFoundSize = totalCompanyFoundSize;
	}
	public Integer getTotalCompanyFoundCount() {
		return totalCompanyFoundCount;
	}
	public void setTotalCompanyFoundCount(Integer totalCompanyFoundCount) {
		this.totalCompanyFoundCount = totalCompanyFoundCount;
	}

	/**
	 * @return the pageProjectInvestmentSize
	 */
	public Integer getPageProjectInvestmentSize() {
		return pageProjectInvestmentSize;
	}
	/**
	 * @param pageProjectInvestmentSize the pageProjectInvestmentSize to set
	 */
	public void setPageProjectInvestmentSize(Integer pageProjectInvestmentSize) {
		this.pageProjectInvestmentSize = pageProjectInvestmentSize;
	}
	/**
	 * @return the pageProjectInvestmentCount
	 */
	public Integer getPageProjectInvestmentCount() {
		return pageProjectInvestmentCount;
	}
	/**
	 * @param pageProjectInvestmentCount the pageProjectInvestmentCount to set
	 */
	public void setPageProjectInvestmentCount(Integer pageProjectInvestmentCount) {
		this.pageProjectInvestmentCount = pageProjectInvestmentCount;
	}
	/**
	 * @return the totalProjectInvestmentSize
	 */
	public Integer getTotalProjectInvestmentSize() {
		return totalProjectInvestmentSize;
	}
	/**
	 * @param totalProjectInvestmentSize the totalProjectInvestmentSize to set
	 */
	public void setTotalProjectInvestmentSize(Integer totalProjectInvestmentSize) {
		this.totalProjectInvestmentSize = totalProjectInvestmentSize;
	}
	/**
	 * @return the totalProjectInvestmentCount
	 */
	public Integer getTotalProjectInvestmentCount() {
		return totalProjectInvestmentCount;
	}
	/**
	 * @param totalProjectInvestmentCount the totalProjectInvestmentCount to set
	 */
	public void setTotalProjectInvestmentCount(Integer totalProjectInvestmentCount) {
		this.totalProjectInvestmentCount = totalProjectInvestmentCount;
	}

	public Integer getPageProjectSize() {
		return pageProjectSize;
	}

	public void setPageProjectSize(Integer pageProjectSize) {
		this.pageProjectSize = pageProjectSize;
	}

	public Integer getPageProjectCount() {
		return pageProjectCount;
	}

	public void setPageProjectCount(Integer pageProjectCount) {
		this.pageProjectCount = pageProjectCount;
	}

	public Integer getTotalProjectSize() {
		return totalProjectSize;
	}

	public void setTotalProjectSize(Integer totalProjectSize) {
		this.totalProjectSize = totalProjectSize;
	}

	public Integer getTotalProjectCount() {
		return totalProjectCount;
	}

	public void setTotalProjectCount(Integer totalProjectCount) {
		this.totalProjectCount = totalProjectCount;
	}

	public Integer getPageMonthlyScoreSize() {
		return pageMonthlyScoreSize;
	}

	public void setPageMonthlyScoreSize(Integer pageMonthlyScoreSize) {
		this.pageMonthlyScoreSize = pageMonthlyScoreSize;
	}

	public Integer getPageMonthlyScoreCount() {
		return pageMonthlyScoreCount;
	}

	public void setPageMonthlyScoreCount(Integer pageMonthlyScoreCount) {
		this.pageMonthlyScoreCount = pageMonthlyScoreCount;
	}

	public Integer getTotalMonthlyScoreSize() {
		return totalMonthlyScoreSize;
	}

	public void setTotalMonthlyScoreSize(Integer totalMonthlyScoreSize) {
		this.totalMonthlyScoreSize = totalMonthlyScoreSize;
	}

	public Integer getTotalMonthlyScoreCount() {
		return totalMonthlyScoreCount;
	}

	public void setTotalMonthlyScoreCount(Integer totalMonthlyScoreCount) {
		this.totalMonthlyScoreCount = totalMonthlyScoreCount;
	}

	public Integer getPageTakeLeaveSize() {
		return pageTakeLeaveSize;
	}

	public void setPageTakeLeaveSize(Integer pageTakeLeaveSize) {
		this.pageTakeLeaveSize = pageTakeLeaveSize;
	}

	public Integer getPageTakeLeaveCount() {
		return pageTakeLeaveCount;
	}

	public void setPageTakeLeaveCount(Integer pageTakeLeaveCount) {
		this.pageTakeLeaveCount = pageTakeLeaveCount;
	}

	public Integer getTotalTakeLeaveSize() {
		return totalTakeLeaveSize;
	}

	public void setTotalTakeLeaveSize(Integer totalTakeLeaveSize) {
		this.totalTakeLeaveSize = totalTakeLeaveSize;
	}

	public Integer getTotalTakeLeaveCount() {
		return totalTakeLeaveCount;
	}

	public void setTotalTakeLeaveCount(Integer totalTakeLeaveCount) {
		this.totalTakeLeaveCount = totalTakeLeaveCount;
	}

	public Integer getPageCompanyPaySize() {
		return pageCompanyPaySize;
	}

	public void setPageCompanyPaySize(Integer pageCompanyPaySize) {
		this.pageCompanyPaySize = pageCompanyPaySize;
	}

	public Integer getPageCompanyPayCount() {
		return pageCompanyPayCount;
	}

	public void setPageCompanyPayCount(Integer pageCompanyPayCount) {
		this.pageCompanyPayCount = pageCompanyPayCount;
	}

	public Integer getTotalCompanyPaySize() {
		return totalCompanyPaySize;
	}

	public void setTotalCompanyPaySize(Integer totalCompanyPaySize) {
		this.totalCompanyPaySize = totalCompanyPaySize;
	}

	public Integer getTotalCompanyPayCount() {
		return totalCompanyPayCount;
	}

	public void setTotalCompanyPayCount(Integer totalCompanyPayCount) {
		this.totalCompanyPayCount = totalCompanyPayCount;
	}
}
