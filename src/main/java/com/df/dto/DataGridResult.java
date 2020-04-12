package com.df.dto;

import java.util.List;

/**
 * 返回结果集的封装
 */
public class DataGridResult {

    private long total;         //返回记录数
    private List<?> rows;       //返回条数

    DataGridResult(){}

    public DataGridResult(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
