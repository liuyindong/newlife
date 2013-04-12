package cn.javass.lucene.crawl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.javass.common.dao.IBaseDao;
import cn.javass.common.service.impl.BaseService;
import cn.javass.lucene.crawl.dao.CrawlResourceDao;
import cn.javass.lucene.crawl.entity.CrawlResourceEntity;
import cn.javass.lucene.crawl.service.CrawlResourceSrevice;

@Service("CrawlResourceSrevice")
public class CrawlResourceSreviceImpl extends BaseService<CrawlResourceEntity,Integer> implements CrawlResourceSrevice
{
	private CrawlResourceDao crawlResourceDao;
	
	@Autowired
	@Qualifier("CrawlResourceDao")

	@Override
	public void setBaseDao(IBaseDao<CrawlResourceEntity, Integer> crawlResourceDao)
	{
		this.baseDao = crawlResourceDao;
		this.crawlResourceDao = (CrawlResourceDao) crawlResourceDao;
	}

}
