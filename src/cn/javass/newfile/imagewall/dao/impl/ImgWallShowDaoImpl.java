package cn.javass.newfile.imagewall.dao.impl;

import org.springframework.stereotype.Repository;

import cn.javass.common.dao.hibernate4.BaseHibernateDao;
import cn.javass.newfile.imagewall.dao.ImgWallShowDao;
import cn.javass.newfile.imagewall.entity.ImgWallShowEntity;

@Repository("ImgWallShowDao")
public class ImgWallShowDaoImpl  extends BaseHibernateDao<ImgWallShowEntity, Integer> implements ImgWallShowDao
{

}
