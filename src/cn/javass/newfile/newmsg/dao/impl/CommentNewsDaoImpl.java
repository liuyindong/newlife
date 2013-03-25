package cn.javass.newfile.newmsg.dao.impl;

import org.springframework.stereotype.Repository;

import cn.javass.common.dao.hibernate4.BaseHibernateDao;
import cn.javass.newfile.newmsg.dao.CommentNewsDao;
import cn.javass.newfile.newmsg.entity.CommentNewsEntity;
@Repository("CommentNewsDao")
public class CommentNewsDaoImpl extends BaseHibernateDao<CommentNewsEntity, Integer> implements CommentNewsDao
{

}
