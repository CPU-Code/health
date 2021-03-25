package com.cpucode.entity;

import java.io.Serializable;

/**
 * 封装查询条件
 *
 * @author : cpucode
 * @date : 2021/3/25
 * @time : 15:15
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
public class QueryPageBean implements Serializable {

    /**
     * 页码
     */
    private Integer currentPage;
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 查询条件
     */
    private String queryString;

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

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }
}