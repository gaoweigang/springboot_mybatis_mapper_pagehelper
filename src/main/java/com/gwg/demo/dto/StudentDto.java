package com.gwg.demo.dto;

import java.io.Serializable;

public class StudentDto implements Serializable{

    //开始年龄
    private Integer startAge;

    //结束年龄
    private Integer endAge;

    //页数
    private int pageIndex;

    //每页显示条数
    private int pageSize;

    //排序
    private String sort;


    public Integer getStartAge() {
        return startAge;
    }

    public void setStartAge(Integer startAge) {
        this.startAge = startAge;
    }

    public Integer getEndAge() {
        return endAge;
    }

    public void setEndAge(Integer endAge) {
        this.endAge = endAge;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
