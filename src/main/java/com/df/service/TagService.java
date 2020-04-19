package com.df.service;

import com.df.dto.DataGridResult;
import com.df.dto.QueryDto;
import com.df.pojo.Tag;

/**
 * @description:
 * @Cauthor: zb
 * @date: 2020/4/19 - 11:20
 */
public interface TagService {

    public int addTag(Tag tag);

    public void delTag(Integer id);

    public int updateTag(Tag tag);

    public Tag findById(Integer id);

    public DataGridResult findByPage(QueryDto queryDto);
}
