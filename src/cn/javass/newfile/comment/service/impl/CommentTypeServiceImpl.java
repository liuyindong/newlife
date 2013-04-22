package cn.javass.newfile.comment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.javass.common.dao.IBaseDao;
import cn.javass.common.service.impl.BaseService;
import cn.javass.newfile.comment.dao.CommentTypeDao;
import cn.javass.newfile.comment.entity.CommentTypeEntity;
import cn.javass.newfile.comment.service.CommentTypeService;

@Service("CommentTypeService")
public class CommentTypeServiceImpl extends BaseService<CommentTypeEntity, Integer> implements CommentTypeService
{

	private CommentTypeDao commentTypeDao;

	@Autowired
	@Qualifier("CommentTypeDao")
	@Override
	public void setBaseDao(IBaseDao<CommentTypeEntity, Integer> commentTypeDao)
	{
		this.baseDao = commentTypeDao;
		this.commentTypeDao = (CommentTypeDao) commentTypeDao;
	}

}
