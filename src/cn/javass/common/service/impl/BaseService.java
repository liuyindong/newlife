package cn.javass.common.service.impl;

import java.util.List;

import cn.javass.common.Constants;
import cn.javass.common.dao.IBaseDao;
import cn.javass.common.pagination.Page;
import cn.javass.common.pagination.PageUtil;
import cn.javass.common.service.IBaseService;

public abstract class BaseService<M extends java.io.Serializable, PK extends java.io.Serializable> implements IBaseService<M, PK>
{

	protected IBaseDao<M, PK> baseDao;

	public abstract void setBaseDao(IBaseDao<M, PK> baseDao);

	@Override
	public M save(M model)
	{
		baseDao.save(model);
		return model;
	}

	@Override
	public void merge(M model)
	{
		baseDao.merge(model);
	}

	@Override
	public void saveOrUpdate(M model)
	{
		baseDao.saveOrUpdate(model);
	}

	@Override
	public void update(M model)
	{
		baseDao.update(model);
	}

	@Override
	public void delete(PK id)
	{
		baseDao.delete(id);
	}

	@Override
	public void deleteObject(M model)
	{
		baseDao.deleteObject(model);
	}

	@Override
	public M get(PK id)
	{
		return baseDao.get(id);
	}

	@Override
	public M JudgeIsExist(String hql, Object... params)
	{
		return baseDao.JudgeIsExist(hql, params);
	}

	@Override
	public int countAll()
	{
		return baseDao.countAll();
	}

	@Override
	public int countAll(String hql, Object... params)
	{
		return baseDao.countAll(hql, params);
	}

	@Override
	public List<M> listAll()
	{
		return baseDao.listAll();
	}

	@Override
	public Page<M> listAll(int pn)
	{
		return this.listAll(pn, Constants.DEFAULT_PAGE_SIZE);
	}

	public Page<M> listAllWithOptimize(int pn)
	{
		return this.listAllWithOptimize(pn, Constants.DEFAULT_PAGE_SIZE);
	}

	@Override
	public Page<M> listAll(int pn, int pageSize)
	{
		Integer count = countAll();
		List<M> items = baseDao.listAll(pn, pageSize);
		return PageUtil.getPage(count, pn, items, pageSize);
	}

	@Override
	public List<M> listAll(String sql, Object... params)
	{
		return baseDao.listAll(sql, params);
	}

	public Page<M> listAllWithOptimize(int pn, int pageSize)
	{
		Integer count = countAll();
		List<M> items = baseDao.listAll(pn, pageSize);
		return PageUtil.getPage(count, pn, items, pageSize);
	}

	public List<M> listAll(String hql, PK pk, int pn, int pageSize, Object... params)
	{
		return baseDao.page(hql, pk, pn, pageSize, params);
	}

	@Override
	public Page<M> pre(PK pk, int pn, int pageSize)
	{
		Integer count = countAll();
		List<M> items = baseDao.pre(pk, pn, pageSize);
		return PageUtil.getPage(count, pn, items, pageSize);
	}

	@Override
	public Page<M> next(PK pk, int pn, int pageSize)
	{
		Integer count = countAll();
		List<M> items = baseDao.next(pk, pn, pageSize);
		return PageUtil.getPage(count, pn, items, pageSize);
	}

	@Override
	public Page<M> page(String hql, PK pk, int pn, int pageSize, Object... params)
	{
		Integer count = pageCount(hql, params);
		List<M> items = baseDao.page(hql, pk, pn, pageSize, params);
		return PageUtil.getPage(count, pn, items, pageSize);
	}

	@Override
	public int pageCount(String hql, Object... params)
	{
		return baseDao.pageCount(hql, params);
	}

	@Override
	public Page<M> pre(PK pk, int pn)
	{
		return pre(pk, pn, Constants.DEFAULT_PAGE_SIZE);
	}

	@Override
	public Page<M> next(PK pk, int pn)
	{
		return next(pk, pn, Constants.DEFAULT_PAGE_SIZE);
	}

}
