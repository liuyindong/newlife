package cn.javass.newfile.imagewall.dao.impl;

import org.springframework.stereotype.Repository;

import cn.javass.common.dao.hibernate4.BaseHibernateDao;
import cn.javass.newfile.imagewall.dao.ImageWallCommentDao;
import cn.javass.newfile.imagewall.entity.ImageWallCommentEntity;

@Repository("ImageWallCommentDao")
public class ImageWallCommentDaoImpl extends BaseHibernateDao<ImageWallCommentEntity, Integer> implements ImageWallCommentDao
{

}
