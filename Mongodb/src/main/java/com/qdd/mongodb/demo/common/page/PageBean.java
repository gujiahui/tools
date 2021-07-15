package com.qdd.mongodb.demo.common.page;

import java.io.Serializable;

/**
 * 分页bean
 */

import java.util.List;

import lombok.Data;
import org.springframework.data.domain.Sort;


@Data
public class PageBean<T> implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3874418698465409409L;
	// 当前页

    private Integer currentPage = 1;
    // 每页显示的总条数
    private Integer pageSize = 1;
    // 总条数
    private long totalNum;
    // 是否有下一页
    private Integer isMore;
    // 总页数
    private long totalPage;
    // 开始索引
    private Integer startIndex;
    // 分页结果
    private List<T> items;

    private Sort sort;
	/**
	 * status code
	 */
    private Integer code;

	/**
	 * describe message
	 */
    private String msg;

    public PageBean() {
        super();
    }

    public PageBean(Integer currentPage, Integer pageSize, Integer totalNum) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = (this.totalNum+this.pageSize-1)/this.pageSize;
        this.startIndex = (this.currentPage-1)*this.pageSize;
        this.isMore = this.currentPage >= this.totalPage?0:1;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getIsMore() {
        return isMore;
    }

    public void setIsMore(Integer isMore) {
        this.isMore = isMore;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}