package cn.javass.common.dao.hibernate4;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.javass.common.dao.NewCommonDao;

public class NewCommonDaoImpl<T> implements NewCommonDao<T>
{

	private Class<T> persistentClass;

	@Autowired
	private HibernateTemplate template;

	@SuppressWarnings("unchecked")
	public NewCommonDaoImpl()
	{
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void add(T entity)
	{
		getTemplate().save(entity);
	}

	@Override
	public Serializable addReturn(T entity)
	{
		return getTemplate().save(entity);
	}

	@Override
	public void del(T entity)
	{
		getTemplate().delete(entity);
	}

	@Override
	public void update(T entity)
	{
		getTemplate().merge(entity);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public T get(Class c, Serializable id)
	{
		return (T) getTemplate().get(persistentClass, id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public T load(Class c, Serializable id)
	{
		return (T) getTemplate().load(persistentClass, id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public T findObject(final String hql, final Object... params)
	{
		return (T) getTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException, SQLException
			{
				Query query = createQuery(session, hql, params);
				return query.uniqueResult();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findList(String hql, Object... params)
	{
		return getTemplate().find(hql, params);
	}

	public Class<T> getPersistentClass()
	{
		return persistentClass;
	}

	public HibernateTemplate getTemplate()
	{
		return template;
	}

	private Query createQuery(Session session, String hql, Object... objects)
	{
		Query query = session.createQuery(hql);
		if (objects != null)
		{
			for (int i = 0; i < objects.length; i++)
			{
				query.setParameter(i, objects[i]);
			}
		}
		return query;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Integer count(final String hql, final Object... params)
	{
		Long totalCount = 0L;
		totalCount = (Long) getTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException, SQLException
			{
				Query q = createQuery(session, hql, params);
				return q.uniqueResult();
			}
		});
		return totalCount.intValue();
	}

	@SuppressWarnings("unused")
	private String getCountQuery(String hql)
	{
		int index = hql.indexOf("from");
		int index2 = hql.indexOf("order");
		if (index != -1)
		{
			if (index2 != -1)
			{
				return "select count(*) " + hql.substring(index, index2);
			}
			return "select count(*) " + hql.substring(index);
		}
		return null;
	}

}
