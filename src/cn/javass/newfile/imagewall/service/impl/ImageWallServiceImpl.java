package cn.javass.newfile.imagewall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.javass.common.dao.IBaseDao;
import cn.javass.common.service.impl.BaseService;
import cn.javass.newfile.imagewall.dao.ImageWallDao;
import cn.javass.newfile.imagewall.entity.ImageWallEntity;
import cn.javass.newfile.imagewall.service.ImageWallService;

@Service("ImageWallService")
public class ImageWallServiceImpl extends BaseService<ImageWallEntity,Integer> implements ImageWallService
{
	private ImageWallDao imageWallDao;
	
	@Autowired
	@Qualifier("ImageWallDao")

	@Override
	public void setBaseDao(IBaseDao<ImageWallEntity, Integer> imageWallDao)
	{
		this.baseDao = imageWallDao;
		this.imageWallDao = (ImageWallDao) imageWallDao;
		
	}



}
