package com.bobo.cms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bobo.cms.service.UserService;
import com.bobo.cms.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("user")
@Controller
public class UserController {

	@Resource
	private UserService userService;
	
	@GetMapping("selects")
	public String selects(@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="3")Integer pageSize,
			@RequestParam(defaultValue="")String username,@RequestParam(defaultValue="")String locked,Model model) {
	
		   //封装查询条件
		HashMap<Object, Object> map = new HashMap<>();
		map.put("username", username);
		map.put("locked", locked);
	    //分页
		PageHelper.startPage(page, pageSize);
		List<Map> userList = userService.selects(map);
		
		
		PageInfo<Map> info = new PageInfo<>(userList);
		//分页信息
		String pageInfo = PageUtil.page(page, info.getPages(), "/user/selects?username="+username+"&locked="+locked, pageSize);
		
		
		model.addAttribute("userList", userList);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("map", map);
		return "user/list";
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 改变用户状态
	 * @param id
	 * @param locked
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("update")
	public boolean update(Integer id ,Integer locked) {
		return userService.updateLocked(id, locked)>0;
	}
}
