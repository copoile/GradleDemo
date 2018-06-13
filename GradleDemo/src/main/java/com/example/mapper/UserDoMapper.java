package com.example.mapper;

import com.example.mapper.dao.UserDo;
import com.example.mapper.dao.UserDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDoMapper {
    int countByExample(UserDoExample example);

    int deleteByExample(UserDoExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(UserDo record);

    int insertSelective(UserDo record);

    List<UserDo> selectByExample(UserDoExample example);

    UserDo selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") UserDo record, @Param("example") UserDoExample example);

    int updateByExample(@Param("record") UserDo record, @Param("example") UserDoExample example);

    int updateByPrimaryKeySelective(UserDo record);

    int updateByPrimaryKey(UserDo record);
}