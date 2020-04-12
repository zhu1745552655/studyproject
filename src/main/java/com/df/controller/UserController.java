package com.df.controller;

import com.df.dto.UserDTO;
import com.df.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLOutput;

/**
 * @description: 用户登陆controller
 * @Cauthor: zb
 * @date: 2020/4/11 - 22:45
 */
@Controller
public class UserController {


    @RequestMapping("sys/login")
    @ResponseBody
    public R login(@RequestBody UserDTO userDTO){
        System.out.println(userDTO.getUsername());
        return R.ok();
    }
}
