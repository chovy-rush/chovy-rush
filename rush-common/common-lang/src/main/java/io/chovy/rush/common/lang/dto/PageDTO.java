package io.chovy.rush.common.lang.dto;

import java.util.List;

public class PageDTO<T> {

    private Integer pageNum;

    private Integer pageSize;

    private Long total;

    private Integer totalPage;

    private List<T> rows;

    public Integer getPageNum() {
        return pageNum;
    }

    public PageDTO<T> setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public PageDTO<T> setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Long getTotal() {
        return total;
    }

    public PageDTO<T> setTotal(Long total) {
        this.total = total;
        return this;
    }

    public List<T> getRows() {
        return rows;
    }

    public PageDTO<T> setRows(List<T> rows) {
        this.rows = rows;
        return this;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
