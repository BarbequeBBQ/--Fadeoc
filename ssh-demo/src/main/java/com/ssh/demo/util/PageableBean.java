package com.ssh.demo.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
/**
 * 分页条件对象简单封装
 * @author Administrator
 *
 */
public class PageableBean 
{
	//默认值:防止错误数据的提交
	private int rows = 30;
	private int page = 1;
	private String sidx ="id";
	private String sord ="desc";
	
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	
	public Pageable getPageable()
	{
		Sort sort = new Sort(Direction.DESC, sidx);
		if(!sord.equals("desc")){
			sort = new Sort(Direction.ASC, sidx);
		}

		return new PageRequest(page-1, rows,sort);
	}
	
}
