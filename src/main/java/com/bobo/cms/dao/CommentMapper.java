package com.bobo.cms.dao;

import java.util.List;
import java.util.Map;

import com.bobo.cms.domain.Comment;
/**
 * 
 * @ClassName: ContentMapper 
 * @Description: 评论
 * @author: charles
 * @date: 2019年7月27日 上午8:33:12
 */
public interface CommentMapper {
	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加评论
	 * @param comment
	 * @return
	 * @return: int
	 */
	int insert(Comment comment);
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 根据id查询文章评论
	 * @param articleId
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selects(Integer articleId);

}
