package com.bobo.cms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bobo.cms.domain.User;
import com.bobo.cms.service.UserService;
import com.bobo.cms.utils.CMSConstant;

import com.bobo.cms.vo.UserVO;
import com.yangchunbo.common.utils.CMSRuntimeException;

/**
 * 
 * @ClassName: PassportController
 * @Description: 登录或注册
 * @author: charles
 * @date: 2019年7月17日 下午4:01:39
 */
@Controller
public class PassportController {

	@Resource
	private UserService userService;

	/***
	 * 
	 * @Title: toReg
	 * @Description: 去注册页面
	 * @return
	 * @return: String
	 */
//	@RequestMapping( value="toReg",method=RequestMethod.GET)
	@GetMapping("toReg")
	public String toReg(UserVO userVO, Model model) {

		return "passport/reg";

	}

	/**
	 * 
	 * @Title: reg
	 * @Description: 用户注册
	 * @param userVO
	 * @return
	 * @return: String
	 */
	// @RequestMapping(value="reg",method=RequestMethod.POST)
	@PostMapping("reg")
	public String reg(@Valid UserVO userVO, BindingResult result, Model model,RedirectAttributes redirectAttributes) {

		// 注册信息不符合要求
		if (result.hasErrors()) {
			return "passport/reg";// 注册失败,回到注册页面显示错误消息
		}

		try {
			userService.insert(userVO);
			// 注册成功.重定向到登录页面,把用户名携带到登录页面并填充
			redirectAttributes.addFlashAttribute("msg","恭喜您注册成功,请登录!");
			redirectAttributes.addFlashAttribute("username",userVO.getUsername());
			
			return "redirect:toLogin";
		} catch (CMSRuntimeException e) {
			//封装自定义异常消息
			model.addAttribute("msg", e.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "未知异常,请与管理员联系");
		}
		return "passport/reg";// 注册失败,回到注册页面

	}

	/**
	 * 
	 * @Title: toLogin
	 * @Description: 去登录
	 * @return
	 * @return: String
	 */
	@GetMapping("toLogin")
	public String toLogin(User user) {

		return "passport/login";
	}
	
	/**
	 * 
	 * @Title: login 
	 * @Description: 用户登录
	 * @param user
	 * @param session
	 * @param model
	 * @return
	 * @return: String
	 */
	@PostMapping(value="login")
	public String login(User user,HttpSession session,Model model) {
	
		try {
			//登录并返回用户对象
			User u = userService.login(user.getUsername(), user.getPassword());//登录成功
			
			//根据登录角色判断.进入对应角色页面
			if(u.getRole().equals(CMSConstant.RULE_ADMIN)) {//管理员
			session.setAttribute(CMSConstant.LOGIN_ADMIN,u);//存session	
			 return "redirect:"+CMSConstant.URL_ADMIN;
			}
			//普通用户session
			session.setAttribute(CMSConstant.LOGIN_GENERAL,u);//存session	
			return "redirect:"+CMSConstant.URL_GENERAL;//普通的用户url
			
		}catch (CMSRuntimeException e) {
			model.addAttribute("msg", e.getMessage());
		}/*catch (Exception e) {  通过统一异常处理了
			e.printStackTrace();
			model.addAttribute("msg", "登录失败,系统出现未知错误!");
		}*/
		return "passport/login";//登录失败,回到登录页面
		
	}
	/**
	 * 
	 * @Title: logout 
	 * @Description:注销
	 * @return
	 * @return: String
	 */
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		//清空session
		if(null!=session) {
			session.invalidate();	
		}
		return "redirect:toLogin";
		
		
	}

}
