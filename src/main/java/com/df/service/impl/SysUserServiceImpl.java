package com.df.service.impl;

import com.df.dao.SysUserMapper;
import com.df.pojo.SysUser;
import com.df.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 系统用户实现类
 * @Cauthor: zb
 * @date: 2020/4/11 - 21:56
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.selectByExample(null);
    }
}
