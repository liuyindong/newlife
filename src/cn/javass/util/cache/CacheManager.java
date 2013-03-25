package cn.javass.util.cache;

import cn.javass.newfile.user.model.UserModel;

public class CacheManager
{
	private OsCacheMethods newsCache;
	private static CacheManager instance;
	private static Object lock = new Object();

	private CacheManager()
	{
		// 这个根据配置文件来，初始BaseCache而已;
		newsCache = new OsCacheMethods("news", 120);
	}

	public static CacheManager getInstance()
	{
		if (instance == null)
		{
			synchronized (lock)
			{
				if (instance == null)
				{
					instance = new CacheManager();
				}
			}
		}
		return instance;
	}

	public void putUser(UserModel news)
	{
		newsCache.put(news.getId() + "", news);
	}

	public void removeUser(String newsID)
	{
		newsCache.remove(newsID);
	}

	public void removeAllNews()
	{
		newsCache.removeAll();
	}
}