package com.df.controller;

import com.df.dto.DataGridResult;
import com.df.dto.QueryDto;
import com.df.pojo.SysMenu;
import com.df.service.MenuService;
import com.df.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: 菜单控制层
 * @Cauthor: zb
 * @date: 2020/4/12 - 11:15
 */
@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 分页查询菜单
     *
     * @param queryDto
     * @return
     */
    @RequestMapping("/sys/menu/list")
    @ResponseBody
    public DataGridResult findMenu(QueryDto queryDto) {
        return menuService.findMenu(queryDto);
    }

    /**
     * 根据ids批量删除菜单
     *
     * @param ids
     * @return
     */
    @RequestMapping("/sys/menu/del")
    @ResponseBody
    public R deleteMenu(@RequestBody List<Long> ids) {
        return menuService.deleteMenu(ids);
    }


    /**
     * 加载树形目录结构
     *
     * @return
     */
    @RequestMapping("/sys/menu/select")
    @ResponseBody
    public R selectMenu() {
        return menuService.selectMenu();
    }

    /**
     * 添加菜单
     *
     * @param sysMenu
     * @return
     */
    @RequestMapping("/sys/menu/save")
    @ResponseBody
    public R saveMenu(@RequestBody SysMenu sysMenu) {
        return menuService.saveMenu(sysMenu);
    }

    /**
     * 根据menuId获取菜单的信息
     *
     * @param menuId
     * @return
     */
    @RequestMapping("/sys/menu/info/{menuId}")
    @ResponseBody
    public R updateMenu(@PathVariable("menuId") Long menuId) {
        return menuService.findMenuById(menuId);
    }


    /**
     * 修改菜单
     *
     * @param sysMenu
     * @return
     */
    @RequestMapping("/sys/menu/update")
    @ResponseBody
    public R updateMenu(@RequestBody SysMenu sysMenu) {
        return menuService.updateMenu(sysMenu);
    }

}
