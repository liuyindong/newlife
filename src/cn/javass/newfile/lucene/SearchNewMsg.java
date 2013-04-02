package cn.javass.newfile.lucene;

import java.util.Iterator;
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
	public static void main(String[] args)
	{
		try
		{
			
			List<NewsEntity> list = (List<NewsEntity>) searchNews("诺基亚", "title", 1000, 10);
			for (Iterator iterator = list.iterator(); iterator.hasNext();)
			{
				NewsEntity newsEntity = (NewsEntity) iterator.next();
				System.out.println(newsEntity.getTitle());
			}
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
