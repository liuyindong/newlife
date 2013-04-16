package cn.javass.lucene;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import cn.javass.lucene.manger.LuceneIndexManager;
import cn.javass.newfile.newmsg.entity.NewsEntity;
import cn.javass.util.DateUtil;

public class SearchNewMsg
{
	public static List<?> searchNews(String srarchName, String searchType, int pageSize, int currentPage) throws Exception
	{
		LuceneIndexManager lim = new LuceneIndexManager();
		lim.indexInit();
		// 初始化索引
		
		List<NewsEntity> listNews = new ArrayList<NewsEntity>();
		
		String a = "D:\\2013\\04\\电影种子";
		
		File file = new File(a);
		File[] files = file.listFiles();
		
		for (int i = 1; i < files.length; i++)
		{
			NewsEntity n = new NewsEntity();
			n.setId(i);
			n.setDownDate(DateUtil.timeToString(new Date()));
			n.setNewMsgOne(files[i].getPath());
			n.setTitle(files[i].getName());
			listNews.add(n);
		}
		
//		lim.createALL(listNews);
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
			
			List<NewsEntity> list = (List<NewsEntity>) searchNews("喋血双雄", "title", 1000, 1);
			for (Iterator iterator = list.iterator(); iterator.hasNext();)
			{
				NewsEntity newsEntity = (NewsEntity) iterator.next();
				System.out.println(newsEntity.getNewMsgOne());
			}
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
