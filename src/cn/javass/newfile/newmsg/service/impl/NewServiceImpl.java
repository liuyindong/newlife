package cn.javass.newfile.newmsg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.javass.common.dao.IBaseDao;
import cn.javass.common.service.impl.BaseService;
import cn.javass.newfile.newmsg.dao.NewDao;
import cn.javass.newfile.newmsg.entity.NewsEntity;
import cn.javass.newfile.newmsg.service.NewService;

@Service("NewService")
public class NewServiceImpl extends BaseService<NewsEntity, Integer> implements NewService
{

	private NewDao newDao;

	@Autowired
	@Qualifier("NewDao")
	@Override
	public void setBaseDao(IBaseDao<NewsEntity, Integer> newDao)
	{
		this.baseDao = newDao;
        this.newDao = (NewDao) newDao;
	}

	@Override
	public int updateNewsOn(String hql, Object... paramlist)
	{
		return newDao.updateNewsOn(hql, paramlist);
	}

}
