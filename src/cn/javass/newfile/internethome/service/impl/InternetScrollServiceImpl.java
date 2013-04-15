package cn.javass.newfile.internethome.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.javass.common.dao.IBaseDao;
import cn.javass.common.service.impl.BaseService;
import cn.javass.newfile.internethome.dao.InternetScrollDao;
import cn.javass.newfile.internethome.entity.InternetScrollEntity;
import cn.javass.newfile.internethome.service.InternetScrollService;

@Service("InternetScrollService")
public class InternetScrollServiceImpl extends BaseService<InternetScrollEntity, Integer> implements InternetScrollService
{

	private InternetScrollDao internetScrollDao;

    @Autowired
    @Qualifier("InternetScrollDao")
	
	@Override
	public void setBaseDao(IBaseDao<InternetScrollEntity, Integer> internetScrollDao)
	{
		this.baseDao = internetScrollDao;
		this.internetScrollDao = (InternetScrollDao) internetScrollDao;
		
	}

}
