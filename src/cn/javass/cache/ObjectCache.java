package cn.javass.cache;

import java.util.ArrayList;
import java.util.List;

import cn.javass.newfile.internethome.entity.InternetHomeEntity;
import cn.javass.util.cache.OsCacheMethods;

public class ObjectCache
{
	private OsCacheMethods osCacheMethods;
	private String osCacheName;
	private static Object lock = new Object();
	private static ObjectCache instance;

	private ObjectCache (String name,Integer time)
	{
		this.osCacheName = name;
		// 这个根据配置文件来，初始BaseCache而已;
		osCacheMethods = new OsCacheMethods(osCacheName, time);
	}
	
	public static ObjectCache getInstance(String name,Integer time)
	{
		if (instance == null)
		{
			synchronized (lock)
			{
				if (instance == null)
				{
					instance = new ObjectCache(name,time);
				}
			}
		}
		return instance;
	}

	public void putMsgList(List<?> listSearch)
	{
		osCacheMethods.put(this.osCacheName, listSearch);
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> listNews()
	{
		List<Object> listObject;
		try
		{
			listObject = (List<Object>) osCacheMethods.get(this.osCacheName);
			return listObject;
		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	public void remove()
	{
		osCacheMethods.remove(this.osCacheName);
	}
	
	public static void main(String[] args)
	{
		ObjectCache o = ObjectCache.getInstance("zhangsan111");
		List<Object> l = o.listNews();
		
		List<InternetHomeEntity> list = new ArrayList<InternetHomeEntity>();
		
		if(l == null)
		{
			System.out.println("没有数据");
			InternetHomeEntity a = new InternetHomeEntity();
			a.setId(111);
			list.add(a);
			o.putMsgList(list);
		//	main(null);
		}
		InternetHomeEntity a = (InternetHomeEntity) l.get(0);
		System.out.println(a.getId());
		return;
	}
}
