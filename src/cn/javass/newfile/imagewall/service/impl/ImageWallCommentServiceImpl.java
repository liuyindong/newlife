package cn.javass.newfile.imagewall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.javass.common.dao.IBaseDao;
import cn.javass.common.service.impl.BaseService;
import cn.javass.newfile.imagewall.dao.ImageWallCommentDao;
import cn.javass.newfile.imagewall.entity.ImageWallCommentEntity;
import cn.javass.newfile.imagewall.service.ImageWallCommentService;

@Service("ImageWallCommentService")
public class ImageWallCommentServiceImpl extends BaseService<ImageWallCommentEntity,Integer> implements ImageWallCommentService
{
	private ImageWallCommentDao imageWallCommentDao;
	
	@Autowired
	@Qualifier("ImageWallCommentDao")
	
	@Override
	public void setBaseDao(IBaseDao<ImageWallCommentEntity, Integer> imageWallCommentDao)
	{
		this.baseDao = imageWallCommentDao;
		this.imageWallCommentDao = (ImageWallCommentDao) imageWallCommentDao;
	}
	
}
