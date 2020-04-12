package com.df.service;

import com.df.pojo.SysUser;

import java.util.List;

/**@description: 系统用户接口
 * @author: zb
 * @date: 2020/4/11 - 21:51
 */
public interface SysUserService {

    List<SysUser> findAll();

}
