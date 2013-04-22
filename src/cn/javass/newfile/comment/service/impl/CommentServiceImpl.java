package cn.javass.newfile.comment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.javass.common.dao.IBaseDao;
import cn.javass.common.service.impl.BaseService;
import cn.javass.newfile.comment.dao.CommentDao;
import cn.javass.newfile.comment.entity.CommentEntity;
import cn.javass.newfile.comment.service.CommentService;

@Service("CommentService")
public class CommentServiceImpl extends BaseService<CommentEntity,Integer> implements CommentService
{
	private CommentDao commentDao;
	
	@Autowired
	@Qualifier("CommentDao")
	
	@Override
	public void setBaseDao(IBaseDao<CommentEntity, Integer> commentDao)
	{
		this.baseDao = commentDao;
		this.commentDao = (CommentDao) commentDao;
	}
	
}
