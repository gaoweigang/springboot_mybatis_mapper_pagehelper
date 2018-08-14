package com.gwg.demo.common;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer recordCount = 0;

    private List<T> items;

    public PageResult(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public PageResult(Integer recordCount, List<T> items) {
        this.recordCount = recordCount;
        this.items = items;
    }



    public PageResult() {
        super();
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public List<T> getItems() {
        return items == null? new ArrayList<T>(): items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

}
