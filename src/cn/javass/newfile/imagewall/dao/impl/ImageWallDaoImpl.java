package cn.javass.newfile.imagewall.dao.impl;

import org.springframework.stereotype.Repository;

import cn.javass.common.dao.hibernate4.BaseHibernateDao;
import cn.javass.newfile.imagewall.dao.ImageWallDao;
import cn.javass.newfile.imagewall.entity.ImageWallEntity;

@Repository("ImageDao")
public class ImageWallDaoImpl extends BaseHibernateDao<ImageWallEntity, Integer> implements ImageWallDao
{

}
