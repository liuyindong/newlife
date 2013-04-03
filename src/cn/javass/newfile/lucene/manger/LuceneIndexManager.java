package cn.javass.newfile.lucene.manger;

import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.wltea.analyzer.lucene.IKAnalyzer;

import cn.javass.newfile.newmsg.entity.NewsEntity;
import cn.javass.util.Config;

/**
 * 主要对index进行初始化，对索引进行更新、删除、添加方法。
 * 
 * @author Administrator
 * 
 */
public class LuceneIndexManager
{

	@Autowired
	private Config config;
	
	private LuceneIndexSettings indexSettings;
	private LuceneIndex luceneIndex;

	private LuceneIndexSearch luceneIndexSearch;

	/*
	 * 初始化方法
	 */
	public void indexInit() throws Exception
	{
		Analyzer analyzer = new IKAnalyzer();
		this.indexSettings = new LuceneIndexSettings(analyzer);
		this.indexSettings.createFSDirectory("D:\\lucene\\indexlucene");//config.getLucenePath()
		this.luceneIndex = new LuceneIndex(this.indexSettings);
		this.luceneIndexSearch = new LuceneIndexSearch(indexSettings, new LuceneResultCollector(indexSettings));
	}

	/**
	 * 创建索引
	 * 
	 * @param newMsgs
	 */
	public void create(NewsEntity newMsgs)
	{
		this.luceneIndex.createIndex(newMsgs);
	}

	/**
	 * 批量创建索引
	 * 
	 * @param newMsgs
	 */
	public void createALL(List<NewsEntity> newMsgs)
	{
		this.luceneIndex.createIndexALL(newMsgs);
		System.out.println("创建索引成功!");
	}
	public void updateOrCreate(NewsEntity newMsg)
	{
		exist(newMsg);
	}

	/**
	 * 更新索引
	 * 
	 * @return
	 */
	public void update(NewsEntity newMsgs)
	{
		this.luceneIndex.updateIndex(newMsgs);
	}

	/**
	 * 删除索引
	 * 
	 * @return
	 */
	public void delete(NewsEntity newMsgs)
	{
		this.luceneIndex.delIndex(newMsgs);
	}

	/**
	 * 判断索引是否存在
	 * 
	 * @return
	 */
	public boolean exist(NewsEntity newMsgs)
	{
		return this.luceneIndex.exist(newMsgs);
	}

	/**
	 * 搜索
	 * 
	 * @param searchString
	 * @return
	 * @throws Exception
	 */
	public List<?> search(String searchString,String queryType, int pageSize, int currentPage) throws Exception
	{
		return this.luceneIndexSearch.serarchFile(searchString,queryType,pageSize,currentPage);
	}
	
	public void createIndexSearch()
	{
		this.luceneIndexSearch.createIndexSearch();
	}

	public LuceneIndex getLuceneIndex()
	{
		return luceneIndex;
	}

	public LuceneIndexSearch getLuceneIndexSearch()
	{
		return luceneIndexSearch;
	}
}
