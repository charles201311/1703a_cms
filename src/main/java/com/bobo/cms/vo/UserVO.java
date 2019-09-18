package com.bobo.cms.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bobo.cms.domain.User;
/**
 * 
 * @ClassName: UserVO 
 * @Description: 用户的视图对象
 * @author: charles
 * @date: 2019年7月18日 上午9:22:38
 */
public class UserVO extends User implements Serializable {
	
	@NotNull(message="密码不能为空")
	@Size(min=6,max=10,message="密码长度在6-10之间")
	private String repassword;//确认密码

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	
	

}
