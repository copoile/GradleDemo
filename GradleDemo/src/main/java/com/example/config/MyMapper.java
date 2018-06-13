package com.example.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper
 * @author Administrator
 * @date 2018年3月27日
 * @Description:TODO
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T>{

}
