package com.xjgc.xjap.appframe.utils;

import java.util.List;

@SuppressWarnings("all")
public class Page {
	
	private int pageNum;
	private int rows;
	
	private Long total;
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public int getPageNum() {
		return (pageNum-1)*rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public int getRows() {
		return rows;
	}
	
	public Page() {}
	public Page(int pageNum, int rows) {
		super();
		this.pageNum = pageNum;
		this.rows = rows;
	}

}
