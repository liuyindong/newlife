package cn.javass.newfile.newmsg.dao;

import cn.javass.common.dao.IBaseDao;
import cn.javass.newfile.newmsg.entity.NewsEntity;

public interface NewDao extends IBaseDao<NewsEntity, Integer>
{
	int updateNewsOn(String hql,Object... paramlist);
}
