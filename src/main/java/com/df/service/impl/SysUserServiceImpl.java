package com.df.service.impl;

import com.df.dao.SysUserMapper;
import com.df.dto.DataGridResult;
import com.df.dto.QueryDto;
import com.df.pojo.SysUser;
import com.df.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    /**
     * 获取用户的分页数据
     * @param queryDto
     * @return
     */
    @Override
    public DataGridResult findUserByPage(QueryDto queryDto) {

        PageHelper.offsetPage(queryDto.getOffset(),queryDto.getLimit());
        if (queryDto.getSort() != null && !queryDto.getSort().equals("")){
            queryDto.setSort("user_id");
        }
        List<SysUser> sysUsers = sysUserMapper.findByPage(queryDto);
        PageInfo<SysUser> info = new PageInfo<>(sysUsers);
        long total = info.getTotal();
        DataGridResult result = new DataGridResult(total, info.getList());
        return result;
    }


    /**
     * 导出用户信息excel
     * @return
     */
    @Override
    public Workbook exportUser() {
        //1 创建一个空的excel文件
        Workbook workbook = new HSSFWorkbook();
        //2 填充数据：创建sheet
        Sheet sheet = workbook.createSheet("某某公司员工信息表");
        //标题数组
        String titles[] = {"用户id","用户名","邮箱","电话","创建时间"};
        String columns[] = {"userId","username","email","mobile","createTime"};
        List<Map<String, Object>> maps = sysUserMapper.exportUser();
        Row rowTile = sheet.createRow(0);
        //标题行
        for (int i = 0; i < titles.length; i++) {
            Cell cell = rowTile.createCell(i);
            cell.setCellValue(titles[i]);

        }
        //遍历数据填充到单元格
        for (int i = 0; i < maps.size(); i++) {
            //一条记录就应该创建一个Row对象，这里从第二行开始所以+1
            Row row = sheet.createRow(i + 1);   //这个是空的，需要填充数据
            //填充单元格
            for (int j = 0; j < titles.length; j++) {
                Cell cell = row.createCell(j);
                //获取用户id的值
                Map<String, Object> rowValue = maps.get(i);
                //循环动态的设置多个字段的值
                Object o = rowValue.get(columns[j]);
                cell.setCellValue(o+"");
            }
        }
        return workbook;
    }

    @Override
    public SysUser findUserByUsername(String username) {
        SysUser userByUsername = sysUserMapper.findUserByUsername(username);
        return userByUsername;
    }


}
