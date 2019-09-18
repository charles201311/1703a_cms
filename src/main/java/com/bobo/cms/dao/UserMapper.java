package com.bobo.cms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bobo.cms.domain.User;

/**
 * 
 * @ClassName: UserMapper 
 * @Description: 用户 
 * @author: charles
 * @date: 2019年7月17日 下午3:43:26
 */
public interface UserMapper {
	
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
	int updateLocked(@Param("id")Integer id,@Param("locked") Integer locked);

	/**
	 * 
	 * @Title: insert 
	 * @Description: 用户注册
	 * @param user
	 * @return
	 * @return: boolean
	 */
	int insert(User user);
	/**
	 * 
	 * @Title: selectByUsername 
	 * @Description:  根据用户名查询对象
	 * @param username
	 * @return
	 * @return: User
	 */
	User selectByUsername(String username);
	
}
