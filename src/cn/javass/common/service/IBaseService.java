package cn.javass.common.service;

import cn.javass.common.pagination.Page;

import java.util.List;

public interface IBaseService<M extends java.io.Serializable, PK extends java.io.Serializable> {
    
    public M save(M model);

    public void saveOrUpdate(M model);
    
    public void update(M model);
    
    public void merge(M model);

    public void delete(PK id);

    public void deleteObject(M model);

    public M get(PK id);
    
    public M JudgeIsExist(String hql,Object... params);
    
    public int updateSqlOne(String sql, final Object... paramlist);
    
    public int countAll();
    
    public int countAll(String hql,Object... params);
    
    public List<M> listAll();
    
    public Page<M> listAll(int pn);
    
    public Page<M> listAll(int pn, int pageSize);
    
    public List<M> listAll(String sql,Object... params);
    
    public List<M> listAll(String hql, PK pk, int pn, int pageSize, Object... params);
    
    public Page<M> pre(PK pk, int pn, int pageSize);
    
    public Page<M> next(PK pk, int pn, int pageSize);
    
    public Page<M> page(String hql, PK pk, int pn, int pageSize, Object... params);
    
    public Page<M> pre(PK pk, int pn);
    
    public Page<M> next(PK pk, int pn);
}
