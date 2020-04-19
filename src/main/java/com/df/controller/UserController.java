package com.df.controller;

import com.df.dto.UserDTO;
import com.df.pojo.SysUser;
import com.df.utils.MD5Utils;
import com.df.utils.R;
import com.df.utils.ShiroUtils;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @description: 用户登陆controller
 * @Cauthor: zb
 * @date: 2020/4/11 - 22:45
 */
@Controller
public class UserController {


    @Autowired
    private DefaultKaptcha kaptcha;

    /**
     *生成验证码
     * @param response
     */
    @RequestMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response){
        // 缓存设置-设置不缓存（可选操作）
        response.setHeader("Cache-Control","no-store, no-cache");
        // 设置响应内容
        response.setContentType("image/jpg");
        //生成验证码
        String text = kaptcha.createText();//文本
        //生成图片
        BufferedImage image = kaptcha.createImage(text);
        //验证码存储到shiro的 session
        ShiroUtils.setKaptcha(text);
        try {
            //返回到页面
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(image,"jpg",outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 登录
     * @param userDTO
     * @return
     */
    @RequestMapping("sys/login")
    @ResponseBody
    public R login(@RequestBody UserDTO userDTO){
        //比对验证码
        String serverKaptcha = ShiroUtils.getKaptcha();
        if(!serverKaptcha.equalsIgnoreCase(userDTO.getCaptcha())){
            return R.error("验证码错误");
        }
        Subject subject = SecurityUtils.getSubject();
        String newPass = MD5Utils.md5(userDTO.getPassword(),userDTO.getUsername(),1024);
        UsernamePasswordToken token = new UsernamePasswordToken(userDTO.getUsername(),newPass);
        if(userDTO.isRememberMe()){
            token.setRememberMe(true);
        }
        subject.login(token);
        //会去调用自定义的realm
        return R.ok();
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        ShiroUtils.logout();
        return "redirect:login.html";
    }


    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping("/sys/user/info")
    @ResponseBody
    public R userinfo(){
        //可以从shiro中获取
        SysUser userEntity = ShiroUtils.getUserEntity();
        return R.ok().put("user",userEntity);
    }
}
