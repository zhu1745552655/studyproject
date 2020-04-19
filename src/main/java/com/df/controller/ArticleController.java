package com.df.controller;

import com.df.dto.ArticleDTO;
import com.df.dto.DataGridResult;
import com.df.dto.QueryDto;
import com.df.pojo.Article;
import com.df.service.ArticleService;
import com.df.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @description: 咨询管理控制层
 * @Cauthor: zb
 * @date: 2020/4/19 - 15:30
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 分页查询咨询信息
     * @param queryDto
     * @return
     */
    @RequestMapping("/sys/article/list")
    @ResponseBody
    public DataGridResult findArticle(QueryDto queryDto){
        return articleService.findByPage(queryDto);
    }

    /**
     * 根据id集合列删除咨询信息
     * @param ids
     * @return
     */
    @RequestMapping("/sys/article/del")
    @ResponseBody
    public R delArticle(@RequestBody List<Long> ids){
        for (Long id : ids) {
            articleService.delArticle(id);
        }
        return R.ok();
    }

    /**
     * 根据id查询咨询信息
     * @param id
     * @return
     */
    @RequestMapping("/sys/article/info/{id}")
    @ResponseBody
    public R findById(@PathVariable("id") Long id){
        Article byId = articleService.findById(id);
        return R.ok().put("article",byId);
    }

    /**
     * 添加咨询信息
     * @param articleDTO
     * @return
     */
    @RequestMapping("/sys/article/save")
    @ResponseBody
    public R addArticle(@RequestBody ArticleDTO articleDTO){
        int i = articleService.addArticle(articleDTO);
        return i>0?R.ok():R.error("添加失败");
    }

    /**
     * 更新咨询信息
     * @param articleDTO
     * @return
     */
    @RequestMapping("/sys/article/update")
    @ResponseBody
    public R updateArticle(@RequestBody ArticleDTO articleDTO){
        int i = articleService.updateArticle(articleDTO);
        return i>0?R.ok():R.error("更新失败");
    }

    /**
     * 上传文件
     * @param multipartFile
     * @param request
     * @return
     */
    @RequestMapping("/ytupload")
    @ResponseBody
    public R upload(@RequestParam("mypic") MultipartFile multipartFile, HttpServletRequest request){
        //得到文件名称
        String filename = multipartFile.getOriginalFilename();
        //上传的目的地,不做分布式，只是存储在本质,同时不考虑文件名重复的问题
        File dest = new File("D:\\certs\\"+filename);
        try {
            multipartFile.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok().put("file",filename);
    }
}
