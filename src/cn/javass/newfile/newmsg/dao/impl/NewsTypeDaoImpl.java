package cn.javass.newfile.newmsg.dao.impl;

import org.springframework.stereotype.Repository;

import cn.javass.common.dao.hibernate4.BaseHibernateDao;
import cn.javass.newfile.newmsg.dao.NewsTypeDao;
import cn.javass.newfile.newmsg.entity.NewsTypesEntity;

@Repository("NewsTypeDao")
public class NewsTypeDaoImpl extends BaseHibernateDao<NewsTypesEntity, Integer> implements NewsTypeDao
{
	
}
