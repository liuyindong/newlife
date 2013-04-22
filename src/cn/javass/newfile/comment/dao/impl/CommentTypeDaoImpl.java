package cn.javass.newfile.comment.dao.impl;

import org.springframework.stereotype.Repository;

import cn.javass.common.dao.hibernate4.BaseHibernateDao;
import cn.javass.newfile.comment.dao.CommentTypeDao;
import cn.javass.newfile.comment.entity.CommentTypeEntity;

@Repository("CommentTypeDao")
public class CommentTypeDaoImpl extends BaseHibernateDao<CommentTypeEntity, Integer> implements CommentTypeDao
{

}
