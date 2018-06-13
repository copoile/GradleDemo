package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.excption.MyRunTimeExcption;
import com.example.mapper.UserDoMapper;
import com.example.mapper.dao.UserDo;
import com.example.mapper.dao.UserDoExample;
import com.example.mapper.dao.UserDoExample.Criteria;

/**
 * 用户
 * @author Administrator
 *
 */
@Service
public class UserService {

	@Autowired
	private UserDoMapper userDoMapper;

	/**
	 * 通过主键查找User
	 * 
	 * @param id
	 * @return
	 */
	public UserDo findById(Long id) {
		return userDoMapper.selectByPrimaryKey(id);
	}

	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public UserDo login(String loginname, String password) {
		UserDoExample example = new UserDoExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginNameEqualTo(loginname);
		criteria.andPasswordEqualTo(password);
		List<UserDo> userDos = userDoMapper.selectByExample(example);
		if (userDos.isEmpty() || userDos.get(0) == null) {
			throw new MyRunTimeExcption("用户名或密码不正确");
		}
		return userDos.get(0);
	}

	/**
	 * 用户注册
	 * 
	 * @param userDo
	 */
	public void register(UserDo userDo) {
		userDoMapper.insert(userDo);
	}

	/**
	 * 用户个人信息修改
	 */
	public void updateUser(UserDo userDo) {

		userDoMapper.updateByPrimaryKey(userDo);
	}

}
