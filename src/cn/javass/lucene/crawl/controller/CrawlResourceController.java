package cn.javass.lucene.crawl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.javass.lucene.crawl.service.CrawlResourceSrevice;

public class CrawlResourceController
{
	@Autowired
	@Qualifier("CrawlResourceSrevice")
	private CrawlResourceSrevice crawlResourceSrevice;
}
