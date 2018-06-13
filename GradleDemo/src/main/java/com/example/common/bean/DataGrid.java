package com.example.common.bean;

import java.io.Serializable;
import java.util.List;

public class DataGrid<T> implements Serializable {

	private static final long serialVersionUID = 2914752879851283376L;
	/**
	 * 实体内容
	 */
	private List<T> tbody;
	/**
	 * 分页数据
	 */
	private PageBean page;

	public DataGrid() {

	}
	
	/**
	 * 
	 * @param pageSize 每页条数
	 * @param currentPage 当前页数
	 * @param recordCount 总条数
	 * @param tbody 实体内容
	 */
	public DataGrid(int pageSize, int currentPage, int recordCount,List<T> tbody) {
		PageBean page = new PageBean(pageSize,currentPage,recordCount);
		this.page = page;
		this.tbody = tbody;
	}

	/**
	 * 实体内容
	 */
	public List<T> getTbody() {
		return tbody;
	}

	/**
	 * 实体内容
	 */
	public void setTbody(List<T> tbody) {
		this.tbody = tbody;
	}

	/**
	 * 分页数据
	 */
	public PageBean getPage() {
		return page;
	}

	/**
	 * 分页数据
	 */
	public void setPage(PageBean page) {
		this.page = page;
	}
}

