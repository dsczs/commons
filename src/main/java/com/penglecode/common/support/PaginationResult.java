package com.penglecode.common.support;
/**
 * 分页结果
 * @param <T>
 * @author	  	pengpeng
 * @date	  	2014年12月18日 下午4:37:10
 * @version  	1.0
 */
public class PaginationResult<T> extends Result<T> {

	private Integer totalRowCount;

	public Integer getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(Integer totalRowCount) {
		this.totalRowCount = totalRowCount;
	}
	
}
