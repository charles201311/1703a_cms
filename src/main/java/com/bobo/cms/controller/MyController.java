package com.bobo.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/***
 * 
 * @ClassName: AdminController 
 * @Description:个人中心
 * @author: charles
 * @date: 2019年7月19日 上午10:50:25
 */
@Controller
public class MyController {
	
	
	@GetMapping("my")
	public String toIndex() {
		
		return "my/index";
		
	}

}
