package com.df.service;


import com.df.dto.ArticleDTO;
import com.df.dto.DataGridResult;
import com.df.dto.QueryDto;
import com.df.pojo.Article;

/**
 * @description:
 * @Cauthor: zb
 * @date: 2020/4/19 - 14:52
 */
public interface ArticleService {

    public int addArticle(ArticleDTO articleDTO);

    public void delArticle(Long id);

    public int updateArticle(ArticleDTO articleDTO);

    public Article findById(Long id);

    public DataGridResult findByPage(QueryDto queryDto);
}
