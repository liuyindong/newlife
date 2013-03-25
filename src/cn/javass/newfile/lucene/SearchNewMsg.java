package cn.javass.newfile.lucene;

import java.util.List;

import cn.javass.newfile.lucene.manger.LuceneIndexManager;
import cn.javass.newfile.newmsg.entity.NewsEntity;

public class SearchNewMsg
{
	public static List<?> searchNews(String srarchName, String searchType, int pageSize, int currentPage) throws Exception
	{
		LuceneIndexManager lim = new LuceneIndexManager();
		lim.indexInit();
		// 初始化索引
		
		// 查询
		List<?> posts =  lim.search(srarchName, searchType, pageSize, currentPage);
		return posts;
	}

	public static boolean searchNews(NewsEntity newsMsg)
	{
		LuceneIndexManager lim = new LuceneIndexManager();
		try
		{
			lim.indexInit();
			lim.create(newsMsg);
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
