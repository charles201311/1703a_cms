package com.bobo.cms.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.bobo.cms.domain.Comment;
import com.bobo.cms.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.yangchunbo.common.utils.DateUtil;
import com.yangchunbo.common.utils.RandomUitl;
import com.yangchunbo.common.utils.StringUtil;

public class CommentServiceImplTest extends SpringJunit {
	
	@Resource
	private CommentService commentService;

	@Test
	public void testInsert() {
		
		for(int i =0;i <1000 ;i ++) {
		Comment c = new Comment();
		//随机文章
		int articleId = RandomUitl.random(1, 8);
		c.setArticleId(articleId);
		//评论人
		c.setUserId(123);
		//获取日历类
		Calendar ca = Calendar.getInstance();
		//默认开始时间
		ca.set(2019, 0, 1, 0, 0, 0);
		//获取从2019-01-01到现在的随机日期
		Date date = DateUtil.randomDate(ca.getTime());
		c.setCreated(date);
		//评论内容
	    String str = StringUtil.randomChineseString(100);
		c.setContent(str);
		commentService.insert(c);
		}
	}

	@Test
	public void testSelects() {
		
		PageHelper.startPage(0, 10);
		List<Map> list = commentService.selects(1);
		for (Map map : list) {
			System.out.println(map);
		}
		
		
	}

}
