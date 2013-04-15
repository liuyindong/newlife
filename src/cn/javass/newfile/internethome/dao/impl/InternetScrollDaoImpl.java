package cn.javass.newfile.internethome.dao.impl;

import org.springframework.stereotype.Repository;

import cn.javass.common.dao.hibernate4.BaseHibernateDao;
import cn.javass.newfile.internethome.dao.InternetScrollDao;
import cn.javass.newfile.internethome.entity.InternetScrollEntity;

@Repository("InternetScrollDao")
public class InternetScrollDaoImpl extends BaseHibernateDao<InternetScrollEntity, Integer> implements InternetScrollDao
{

}
