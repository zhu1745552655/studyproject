package com.df.service.impl;

import com.df.dao.SysMenuMapper;
import com.df.dto.DataGridResult;
import com.df.dto.QueryDto;
import com.df.pojo.SysMenu;
import com.df.service.MenuService;
import com.df.utils.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @description: 查找菜单实现
 * @Cauthor: zb
 * @date: 2020/4/12 - 10:49
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;


    /**
     * 分页查询菜单
     *
     * @param queryDto
     * @return
     */
    @Override
    public DataGridResult findMenu(QueryDto queryDto) {

        //设置分页参数
        PageHelper.offsetPage(queryDto.getOffset(), queryDto.getLimit());
        //判断排序字段是否为空，设置menu_id排序
        if (queryDto.getSort() != null && !queryDto.getSort().equals("")) {
            //依据前台页面的menuid进行设置，保证和数据中的menu_id保持一致
            queryDto.setSort("menu_id");
        }

        List<SysMenu> menuByPage = sysMenuMapper.findMenuByPage(queryDto);

        //对查到的分页菜单信息进行获取
        PageInfo<SysMenu> info = new PageInfo<SysMenu>(menuByPage);
        long total = info.getTotal();
        List<SysMenu> list = info.getList();
        DataGridResult dataGridResult = new DataGridResult(total, list);

        return dataGridResult;
    }

    /**
     * 根据ids批量删除菜单
     *
     * @param ids
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public R deleteMenu(List<Long> ids) {
        for (Long id : ids) {
            if (id < 51) {
                return R.error("系统菜单，不支持删除！");
            }
        }
        int i = sysMenuMapper.deleteMenu(ids);
        if (i > 0) {
            return R.ok();
        } else {
            return R.error(-200, "删除失败！");
        }
    }

    /**
     * 加载树形目录结构，用于保存菜单页面的树形菜单的信息加载
     *
     * @return
     */
    @Override
    public R selectMenu() {

        List<SysMenu> menu = sysMenuMapper.selectMenu();

        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenuId(0L);
        sysMenu.setParentId(-1L);
        sysMenu.setType(0);
        sysMenu.setName("一级菜单");
        menu.add(sysMenu);
        return R.ok().put("menuList", menu);
    }

    /**
     * 添加菜单
     *
     * @param sysMenu
     * @return
     */
    @Override
    public R saveMenu(SysMenu sysMenu) {
        int i = sysMenuMapper.insertSelective(sysMenu);
        return i > 0 ? R.ok() : R.error("添加失败");
    }

    /**
     * 根据menuId获取菜单信息，用于修改菜单页面的数据回显
     *
     * @param menuId
     * @return
     */
    @Override
    public R findMenuById(Long menuId) {
        SysMenu sysMenu = sysMenuMapper.selectByPrimaryKey(menuId);
        return R.ok().put("menu", sysMenu);
    }

    /**
     * 修改菜单
     *
     * @param sysMenu
     * @return
     */
    @Override
    public R updateMenu(SysMenu sysMenu) {
        int i = sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
        return i > 0 ? R.ok() : R.error("修改失败！");
    }

    /**
     * 根据用户id查找权限
     *
     * @param userId
     * @return
     */
    @Override
    public List<String> findPermsByUserId(Long userId) {
        List<String> permsByUserId = sysMenuMapper.findPermsByUserId(userId);
        Set<String> set = new HashSet<>();
        for (String s : permsByUserId) {
            if (s != null && !s.equals("")) {
                String[] split = s.split(",");
                for (String s1 : split) {
                    set.add(s1);
                }
            }
        }
        List<String> perms = new ArrayList<>();
        perms.addAll(set);
        return perms;
    }

    /**
     * 根据用户id查找菜单
     *
     * @param userId
     * @return
     */
    @Override
    public R findUserMenu(Long userId) {
        //查询用户的一级目录
        List<Map<String, Object>> dirMenuByUserId = sysMenuMapper.findDirMenuByUserId(userId);
        //查询目录对应的子菜单
        for (Map<String, Object> map : dirMenuByUserId) {
            Long menuId = Long.parseLong(map.get("menuId") + "");
            List<Map<String, Object>> subList = sysMenuMapper.findMenuNotButtonByUserId(userId, menuId);
            map.put("list", subList);
        }
        List<String> permsByUserId = sysMenuMapper.findPermsByUserId(userId);
        return R.ok().put("menuList", dirMenuByUserId).put("permissions", permsByUserId);
    }
}
