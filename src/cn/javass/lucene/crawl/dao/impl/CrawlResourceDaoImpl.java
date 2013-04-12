package cn.javass.lucene.crawl.dao.impl;

import org.springframework.stereotype.Repository;

import cn.javass.common.dao.hibernate4.BaseHibernateDao;
import cn.javass.lucene.crawl.dao.CrawlResourceDao;
import cn.javass.lucene.crawl.entity.CrawlResourceEntity;

@Repository("CrawlResourceDao")
public class CrawlResourceDaoImpl extends BaseHibernateDao<CrawlResourceEntity, Integer> implements CrawlResourceDao
{

}
