package cn.javass.newfile.newmsg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.javass.common.dao.IBaseDao;
import cn.javass.common.service.impl.BaseService;
import cn.javass.newfile.newmsg.dao.CommentNewsDao;
import cn.javass.newfile.newmsg.entity.CommentNewsEntity;
import cn.javass.newfile.newmsg.service.CommentNewsService;

@Service("CommentNewsService")
public class CommentNewsServiceImpl extends BaseService<CommentNewsEntity, Integer> implements CommentNewsService
{

	@SuppressWarnings("unused")
	private CommentNewsDao commentNewsDao;

	@Autowired
	@Qualifier("CommentNewsDao")
	@Override
	public void setBaseDao(IBaseDao<CommentNewsEntity, Integer> baseDao)
	{
		this.baseDao = baseDao;
		this.commentNewsDao =  (CommentNewsDao) baseDao;
	}

}
