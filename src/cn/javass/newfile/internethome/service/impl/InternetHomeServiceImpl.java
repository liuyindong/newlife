package cn.javass.newfile.internethome.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.javass.common.dao.IBaseDao;
import cn.javass.common.service.impl.BaseService;
import cn.javass.newfile.internethome.dao.InternetHomeDao;
import cn.javass.newfile.internethome.entity.InternetHomeEntity;
import cn.javass.newfile.internethome.service.InternetHomeService;



@Service("InternetHomeService")
public class InternetHomeServiceImpl extends BaseService<InternetHomeEntity, Integer> implements InternetHomeService 
{
	private InternetHomeDao internetHomeDao;

    @Autowired
    @Qualifier("InternetHomeDao")

	@Override
	public void setBaseDao(IBaseDao<InternetHomeEntity, Integer> internetHomeDao)
	{
		this.baseDao = internetHomeDao;
		this.internetHomeDao = (InternetHomeDao) internetHomeDao;
		
	}

}
