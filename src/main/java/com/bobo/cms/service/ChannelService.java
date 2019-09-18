package com.bobo.cms.service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: ChannelService 
 * @Description: 栏目和分类
 * @author: charles
 * @date: 2019年7月23日 上午11:03:15
 */
public interface ChannelService {

	/**
	 * 
	 * @Title: selectChannels 
	 * @Description: 所有栏目
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selectChannels();
	/**
	 * 
	 * @Title: selectCategorys 
	 * @Description: 根据栏目查询其下分类
	 * @param channelId
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selectCategorys(Integer channelId);
}
 