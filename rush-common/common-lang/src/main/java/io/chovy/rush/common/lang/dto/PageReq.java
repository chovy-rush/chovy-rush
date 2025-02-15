package io.chovy.rush.common.lang.dto;

public class PageReq {
    private Integer pageNum;

    private Integer pageSize;

    public static PageReq of(Integer pageNum, Integer pageSize) {
        PageReq pageReq = new PageReq();
        pageReq.setPageNum(pageNum);
        pageReq.setPageSize(pageSize);
        return pageReq;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
