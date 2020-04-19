package com.df.controller;

import com.df.dto.DataGridResult;
import com.df.dto.QueryDto;
import com.df.pojo.SysUser;
import com.df.service.SysUserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
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

    /**
     * 获取用户分页数据
     * @param queryDto
     * @return
     */
    @RequestMapping("/sys/user/list")
    @ResponseBody
    public DataGridResult findUser(QueryDto queryDto){
        return sysUserService.findUserByPage(queryDto);
    }

    /**
     * 导出用户数据报表
     * @param response
     */
    @RequestMapping("/sys/user/export")
    public void exportUser(HttpServletResponse response){       //此处不用响应json格式数据，相应输出数据流
        Workbook workbook = sysUserService.exportUser();
        try {
            //设置响应头
            response.setContentType("application/octet-stream");    //所有文件都支持
            String fileName = "员工信息表.xls";
            fileName = URLEncoder.encode(fileName,"utf-8");
            response.setHeader("content-disposition","attachment;filename="+ fileName);
            //文件下载
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
