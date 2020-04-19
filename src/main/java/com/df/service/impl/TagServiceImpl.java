package com.df.service.impl;

import com.df.dao.TagMapper;
import com.df.dto.DataGridResult;
import com.df.dto.QueryDto;
import com.df.pojo.Tag;
import com.df.pojo.TagExample;
import com.df.service.TagService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:   标签管理实现
 * @Cauthor: zb
 * @date: 2020/4/19 - 11:23
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    /**
     * 标签添加
     * @param tag
     * @return
     */
    @Override
    public int addTag(Tag tag) {
        int i = tagMapper.insertSelective(tag);
        return i;
    }

    /**
     * 根据id删除标签
     * @param id
     */
    @Override
    public void delTag(Integer id) {
        tagMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改标签
     * @param tag
     * @return
     */
    @Override
    public int updateTag(Tag tag) {
        int i = tagMapper.updateByPrimaryKeySelective(tag);
        return i;
    }

    /**
     * 根据id查询单个标签
     * @param id
     * @return
     */
    @Override
    public Tag findById(Integer id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询标签数据
     * @param queryDto
     * @return
     */
    @Override
    public DataGridResult findByPage(QueryDto queryDto) {
        PageHelper.offsetPage(queryDto.getOffset(), queryDto.getLimit());
        TagExample example = new TagExample();
        if (queryDto.getSort()!=null&&!queryDto.getSort().equals("")){
            example.setOrderByClause("id " +queryDto.getOrder());
        }
        List<Tag> tags = tagMapper.selectByExample(example);
        PageInfo<Tag> info = new PageInfo<>(tags);
        long total = info.getTotal();
        DataGridResult dataGridResult= new DataGridResult(total,tags);
        return dataGridResult;
    }
}
