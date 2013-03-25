package cn.javass.common.dao;

import java.io.Serializable;
import java.util.List;

public interface NewCommonDao<T>
{
	public void add(T entity);
	
	public Serializable addReturn(T entity);
	
	public void del(T entity);
	
	public void update(T entity);
	
	@SuppressWarnings("rawtypes")
	public T get(Class c, Serializable id);
	
	@SuppressWarnings("rawtypes")
	public T load(Class c, Serializable id);
	
	public T findObject(final String hql, final Object... params);

	public List<T> findList(final String hql, final Object... params);
	
}
