package com.ggsleeper.util;

import java.util.List;

import com.ggsleeper.bean.CarInfo;
import com.ggsleeper.dao.impl.CarInfoDaoImpl;

/**
 * 分页类
 * 
 * @author cx
 *
 */
public class Page {
	private int count;
	private int pageSize ;
	private int currentPage;
	private int totalPage;

	public Page() {

	}
	public Page(int count, int pageSize, int currentPage, int totalPage) {
		super();
		this.count = count;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
