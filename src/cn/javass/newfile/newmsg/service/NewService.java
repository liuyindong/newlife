package cn.javass.newfile.newmsg.service;

import cn.javass.common.service.IBaseService;
import cn.javass.newfile.newmsg.entity.NewsEntity;

public interface NewService extends IBaseService<NewsEntity, Integer>
{
	int updateNewsOn(String hql,Object... paramlist);
	
}
