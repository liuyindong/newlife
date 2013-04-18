package cn.javass.newfile.imagewall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.javass.common.dao.IBaseDao;
import cn.javass.common.service.impl.BaseService;
import cn.javass.newfile.imagewall.dao.ImgWallLoveDao;
import cn.javass.newfile.imagewall.entity.ImgWallLoveEntity;
import cn.javass.newfile.imagewall.service.ImgWallLoveService;

@Service("ImgWallLoveService")
public class ImgWallLoveServiceImpl  extends BaseService<ImgWallLoveEntity,Integer> implements ImgWallLoveService
{

	private ImgWallLoveDao imgWallLoveDao;
	
	@Autowired
	@Qualifier("ImgWallLoveDao")
	
	@Override
	public void setBaseDao(IBaseDao<ImgWallLoveEntity, Integer> imgWallLoveDao)
	{
		this.baseDao = imgWallLoveDao;
		this.imgWallLoveDao = (ImgWallLoveDao) imgWallLoveDao;
	}

}
