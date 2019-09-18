package com.bobo.cms.service;

import java.util.List;
import java.util.Map;

import com.bobo.cms.domain.User;
import com.bobo.cms.vo.UserVO;

public interface UserService {
	

	/**
	 * 
	 * @Title: selects 
	 * @Description: 根据条件查询用户信息
	 * @param map
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selects(Map map);
	
	
	/**
	 * 
	 * @Title: updateStatus 
	 * @Description: 改变用户的登录状态 .禁用或启用
	 * @param uid
	 * @param locked
	 * @return
	 * @return: int
	 */
	int updateLocked(Integer uid,Integer locked);
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 用户注册
	 * @param user
	 * @return
	 * @return: int
	 */
	boolean insert(UserVO userVO);
	/**
	 * 
	 * @Title: selectByUsername 
	 * @Description:  根据用户名查询对象
	 * @param username
	 * @return
	 * @return: User
	 */
	User selectByUsername(String username);
	/**
	 * 
	 * @Title: login 
	 * @Description: 登录
	 * @param username
	 * @param password
	 * @return
	 * @return: boolean
	 */
	User login(String username,String password);

}
