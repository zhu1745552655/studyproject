package com.df.controller;

import com.df.dto.DataGridResult;
import com.df.dto.QueryDto;
import com.df.pojo.Tag;
import com.df.service.TagService;
import com.df.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description:
 * @Cauthor: zb
 * @date: 2020/4/19 - 11:40
 */
@Controller
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 分页查询标签信息
     * @param queryDto
     * @return
     */
    @RequestMapping("/sys/tag/list")
    @ResponseBody
    public DataGridResult findTag(QueryDto queryDto){
        return tagService.findByPage(queryDto);
    }

    /**
     * 根据id集合列删除标签
     * @param ids
     * @return
     */
    @RequestMapping("/sys/tag/del")
    @ResponseBody
    public R delTag(@RequestBody List<Integer> ids){
        for (Integer id : ids) {
            tagService.delTag(id);
        }
        return R.ok();
    }

    /**
     * 添加标签
     * @param tag
     * @return
     */
    @RequestMapping("/sys/tag/save")
    @ResponseBody
    public R saveTag(@RequestBody Tag tag){
        int i = tagService.addTag(tag);
        return i>0?R.ok():R.error("添加失败");
    }

    /**
     * 基于restful风格id查询数据
     * @param id
     * @return
     */
    @RequestMapping("/sys/tag/info/{id}")
    @ResponseBody
    public R findById(@PathVariable("id") Integer id){
        Tag byId = tagService.findById(id);
        return R.ok().put("tag",byId);
    }

    /**
     * 修改标签
     * @param tag
     * @return
     */
    @RequestMapping("/sys/tag/update")
    @ResponseBody
    public R updateTag(@RequestBody Tag tag){
        int i = tagService.updateTag(tag);
        return i>0?R.ok():R.error("修改失败");
    }

}























