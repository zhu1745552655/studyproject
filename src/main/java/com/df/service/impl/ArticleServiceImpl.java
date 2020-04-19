package com.df.service.impl;

import com.df.dao.ArticleMapper;
import com.df.dto.ArticleDTO;
import com.df.dto.DataGridResult;
import com.df.dto.QueryDto;
import com.df.pojo.Article;
import com.df.pojo.ArticleExample;
import com.df.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 咨询管理实现层
 * @Cauthor: zb
 * @date: 2020/4/19 - 15:06
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 添加咨询管理信息
     * @param articleDTO
     * @return
     */
    @Override
    public int addArticle(ArticleDTO articleDTO) {
        Article record = new Article();
        BeanUtils.copyProperties(articleDTO,record);
        Boolean allowUp=articleDTO.getAllowUp();
        if (allowUp){
            record.setAllowUp((byte)1);
        }else{
            record.setAllowUp((byte)0);
        }
        Boolean allowFav=articleDTO.getAllowFav();
        if (allowFav){
            record.setAllowFav((byte)1);
        }else {
            record.setAllowFav((byte)0);
        }
        int i = articleMapper.insertSelective(record);
        return i;
    }

    /**
     * 根据主键删除咨询
     * @param id
     */
    @Override
    public void delArticle(Long id) {
        articleMapper.deleteByPrimaryKey(id);
    }


    /**
     * 更新咨询
     * @param articleDTO
     * @return
     */
    @Override
    public int updateArticle(ArticleDTO articleDTO) {
        Article record = new Article();
        BeanUtils.copyProperties(articleDTO,record);
        Boolean allowUp=articleDTO.getAllowUp();
        if (allowUp){
            record.setAllowUp((byte)1);
        }else{
            record.setAllowUp((byte)0);
        }
        Boolean allowFav=articleDTO.getAllowFav();
        if (allowFav){
            record.setAllowFav((byte)1);
        }else {
            record.setAllowFav((byte)0);
        }
        int i = articleMapper.updateByPrimaryKeySelective(record);
        return i;
    }

    /**
     * 根据id查询咨询
     * @param id
     * @return
     */
    @Override
    public Article findById(Long id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询咨询
     * @param queryDto
     * @return
     */
    @Override
    public DataGridResult findByPage(QueryDto queryDto) {
        PageHelper.offsetPage(queryDto.getOffset(),queryDto.getLimit());
        ArticleExample example = new ArticleExample();
        String sort = queryDto.getSort();
        if (StringUtils.isEmpty(sort)){
            example.setOrderByClause("id");
        }
        List<Article> articles = articleMapper.selectByExample(example);
        PageInfo<Article> info = new PageInfo<>(articles);
        long total = info.getTotal();
        DataGridResult dataGridResult = new DataGridResult(total,articles);
        return dataGridResult;
    }
}
