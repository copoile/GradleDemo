package com.example.common.bean;

import java.io.Serializable;

public class PageBean implements Serializable {
	private static final long serialVersionUID = -104665411959731845L;
	/**
	 * 页数
	 */
	private int pageCount;
	/**
	 * 每页条数
	 */
	private int pageSize;
	/**
	 * 当前页数
	 */
	private int currentPage;
	/**
	 * 总条数
	 */
	private int recordCount;
	/**
	 * 最后一页条数
	 */
	private int lastPageSize;

	public PageBean() {
	}
	
	/**
	 * 
	 * @param pageSize 每页条数
	 * @param currentPage 当前页数
	 * @param recordCount 总条数
	 */
	public PageBean(int pageSize, int currentPage, int recordCount) {
		this.currentPage = currentPage;
		this.recordCount = recordCount;
		this.pageSize = pageSize;
		this.pageCount = recordCount == 0 ? 1 : (recordCount - 1) / pageSize + 1;
		this.lastPageSize = recordCount - pageSize * (pageCount - 1);
	}
	/**
	 * 页数
	 */
	public int getPageCount() {
		return pageCount;
	}
	/**
	 * 页数
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	/**
	 * 每页条数
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * 每页条数
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 当前页数
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * 当前页数
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * 总条数
	 */
	public int getRecordCount() {
		return recordCount;
	}
	/**
	 * 总条数
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	/**
	 * 最后一页条数
	 */
	public int getLastPageSize() {
		return lastPageSize;
	}
	/**
	 * 最后一页条数
	 */
	public void setLastPageSize(int lastPageSize) {
		this.lastPageSize = lastPageSize;
	}

	@Override
	public String toString() {
		return "PageBean [pageCount=" + pageCount + ", pageSize=" + pageSize + ", currentPage=" + currentPage
				+ ", recordCount=" + recordCount + ", lastPageSize=" + lastPageSize + "]";
	}

}
