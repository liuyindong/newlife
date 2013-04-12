package cn.javass.newfile.internethome.dao.impl;

import org.springframework.stereotype.Repository;

import cn.javass.common.dao.hibernate4.BaseHibernateDao;
import cn.javass.newfile.internethome.dao.InternetHomeDao;
import cn.javass.newfile.internethome.entity.InternetHomeEntity;

@Repository("InternetHomeDao")
public class InternetHomeDaoImpl extends BaseHibernateDao<InternetHomeEntity, Integer> implements InternetHomeDao
{

}
