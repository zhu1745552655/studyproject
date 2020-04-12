package com.df.controller;

import com.df.pojo.SysUser;
import com.df.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description:
 * @Cauthor: zb
 * @date: 2020/4/11 - 22:02
 */
@Controller
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<SysUser> findAll(){
        return sysUserService.findAll();
    }
}
