package cn.javass.newfile.newmsg.cache;

import java.util.List;

import cn.javass.util.cache.OsCacheMethods;

public class NewMsgCache
{
	private OsCacheMethods newsCache;
	private static NewMsgCache instance;
	private static Object lock = new Object();

	private NewMsgCache()
	{
		// 这个根据配置文件来，初始BaseCache而已;
		newsCache = new OsCacheMethods("newsMsg", 3600);
	}

	public static NewMsgCache getInstance()
	{
		if (instance == null)
		{
			synchronized (lock)
			{
				if (instance == null)
				{
					instance = new NewMsgCache();
				}
			}
		}
		return instance;
	}

	
	public void putMsgList(String name,List<?> listSearch)
	{
		newsCache.put(name, listSearch);
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> listNews(String name)
	{
		List<Object> listObject;
		try
		{
			listObject = (List<Object>) newsCache.get(name);
			return listObject;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
