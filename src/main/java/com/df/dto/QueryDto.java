package com.df.dto;

/**
 * @description:  查询参数的封装
 * @Cauthor: zb
 * @date: 2020/4/12 - 9:48
 */
public class QueryDto {

    //http://localhost:8080/sys/menu/list?order=asc&limit=10&offset=0
    private int offset;     //分页参数的起始页

    private int limit;      //分页参数的每页显示记录数

    private String order;   //排序参数

    private String sort;    //排序的字段

    private String search;  //模糊搜索

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
