package com.df.dao;

import com.df.pojo.TbToken;
import com.df.pojo.TbTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTokenMapper {
    int countByExample(TbTokenExample example);

    int deleteByExample(TbTokenExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(TbToken record);

    int insertSelective(TbToken record);

    List<TbToken> selectByExample(TbTokenExample example);

    TbToken selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") TbToken record, @Param("example") TbTokenExample example);

    int updateByExample(@Param("record") TbToken record, @Param("example") TbTokenExample example);

    int updateByPrimaryKeySelective(TbToken record);

    int updateByPrimaryKey(TbToken record);
}