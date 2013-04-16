package cn.javass.newfile.newmsg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.javass.common.dao.IBaseDao;
import cn.javass.common.service.impl.BaseService;
import cn.javass.newfile.newmsg.dao.NewsTypeDao;
import cn.javass.newfile.newmsg.entity.NewsTypesEntity;
import cn.javass.newfile.newmsg.service.NewsTypeService;

@Service("NewsTypeService")
public class NewsTypeServiceImpl extends BaseService<NewsTypesEntity, Integer> implements NewsTypeService
{

	private NewsTypeDao newsTypeDao;

	@Autowired
	@Qualifier("NewsTypeDao")
	@Override
	public void setBaseDao(IBaseDao<NewsTypesEntity, Integer> newsTypeDao)
	{
		this.baseDao = newsTypeDao;
		this.newsTypeDao = (NewsTypeDao) newsTypeDao;

	}

}
