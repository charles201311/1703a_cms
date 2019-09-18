package com.bobo.cms.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bobo.cms.service.CommentService;

@Controller
public class CommentController {
	
	@Resource
	CommentService commentService;
	
	
/*	@GetMapping("selectsByArticeId")
	public List<Map> selects(Integer articleId){
		
		List<Map> selects = commentService.selects(articleId);
	}*/
	

}
