package cn.javass.newfile.imagewall.dao.impl;

import org.springframework.stereotype.Repository;

import cn.javass.common.dao.hibernate4.BaseHibernateDao;
import cn.javass.newfile.imagewall.dao.ImgWallLoveDao;
import cn.javass.newfile.imagewall.entity.ImgWallLoveEntity;

@Repository("ImgWallLoveDao")
public class ImgWallLoveDaoImpl extends BaseHibernateDao<ImgWallLoveEntity, Integer> implements ImgWallLoveDao
{

}
