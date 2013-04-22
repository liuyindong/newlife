package cn.javass.newfile.comment.dao.impl;

import org.springframework.stereotype.Repository;

import cn.javass.common.dao.hibernate4.BaseHibernateDao;
import cn.javass.newfile.comment.dao.CommentDao;
import cn.javass.newfile.comment.entity.CommentEntity;

@Repository("CommentDao")
public class CommentDaoImpl extends BaseHibernateDao<CommentEntity, Integer> implements CommentDao
{

}
