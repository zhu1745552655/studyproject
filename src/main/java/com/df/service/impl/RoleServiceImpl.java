package com.df.service.impl;

import com.df.dao.SysRoleMapper;
import com.df.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @Cauthor: zb
 * @date: 2020/4/18 - 14:54
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    /**
     * 根据用户id查找角色名称
     * @param userId
     * @return
     */
    @Override
    public List<String> findRolesByUserId(Long userId) {
        return sysRoleMapper.findRolesByUserId(userId);
    }
}
