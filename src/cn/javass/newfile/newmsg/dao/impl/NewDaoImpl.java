package cn.javass.newfile.newmsg.dao.impl;

import org.springframework.stereotype.Repository;

import cn.javass.common.dao.hibernate4.BaseHibernateDao;
import cn.javass.newfile.newmsg.dao.NewDao;
import cn.javass.newfile.newmsg.entity.NewsEntity;
@Repository("NewDao")
public class NewDaoImpl extends BaseHibernateDao<NewsEntity, Integer> implements NewDao
{

	@Override
	public int updateNewsOn(String hql, Object... paramlist)
	{
		return this.execteNativeBulk(hql, paramlist);
	}

}
