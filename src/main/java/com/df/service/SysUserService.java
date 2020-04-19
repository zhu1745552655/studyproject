package com.df.service;

import com.df.dto.DataGridResult;
import com.df.dto.QueryDto;
import com.df.pojo.SysUser;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**@description: 系统用户接口
 * @author: zb
 * @date: 2020/4/11 - 21:51
 */
public interface SysUserService {

    List<SysUser> findAll();

    DataGridResult findUserByPage(QueryDto queryDto);

    Workbook exportUser();

    SysUser findUserByUsername(String username);

}
