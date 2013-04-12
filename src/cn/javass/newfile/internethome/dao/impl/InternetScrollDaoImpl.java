package cn.javass.newfile.internethome.dao.impl;

import org.springframework.stereotype.Repository;

import cn.javass.common.dao.hibernate4.BaseHibernateDao;
import cn.javass.newfile.internethome.dao.InternetScrollDao;
import cn.javass.newfile.internethome.entity.InternetScroll;

@Repository("InternetScroll")
public class InternetScrollDaoImpl extends BaseHibernateDao<InternetScroll, Integer> implements InternetScrollDao
{

}
