package com.df.service;

import com.df.dto.DataGridResult;
import com.df.dto.QueryDto;
import com.df.pojo.SysMenu;
import com.df.utils.R;

import java.util.List;

/**
 * @description: 菜单服务层接口
 * @Cauthor: zb
 * @date: 2020/4/12 - 10:46
 */
public interface MenuService {

    public DataGridResult findMenu(QueryDto queryDto);

    public R deleteMenu(List<Long> ids);

    public R selectMenu();

    public R saveMenu(SysMenu sysMenu);

    public R findMenuById(Long menuId);

    public R updateMenu(SysMenu sysMenu);

}
