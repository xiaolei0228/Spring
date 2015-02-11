package com.ehome.spring.hibernate.dao.impl;

import com.ehome.spring.hibernate.dao.IBaseDao;
import com.ehome.spring.hibernate.util.Pager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by haoxiaolei on 2015-01-27 16:37
 */
@Repository("baseDao")
public  class BaseDaoImpl<T, PK extends Serializable> implements IBaseDao<T, PK> {

    @Resource
    protected SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Session getNewSession() {
        return sessionFactory.openSession();
    }

    protected void flush() {
        getSession().flush();;
    }

    protected void clear() {
        getSession().clear();
    }


    public T save(T entity) {
        getSession().save(entity);
        return entity;
    }

    public Collection<T> save(Collection<T> entities) {
        for (T entity : entities) {
            getSession().save(entity);
        }
        return entities;
    }

    public T update(T entity) {
        getSession().update(entity);
        return entity;
    }

    public Collection<T> update(Collection<T> entities) {
        if (entities != null && entities.size() > 0) {
            for (T entity : entities) {
                getSession().update(entity);
            }
        }
        return entities;
    }

    public List<T> findList(DetachedCriteria detachedCriteria) {
        Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());
        return criteria.list();
    }

    public List<T> findList(DetachedCriteria detachedCriteria, Pager pager) {
        // 查询
        Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());
        criteria.setFirstResult(pager.getStart());
        criteria.setMaxResults(pager.getPageSize());
        List resultList = criteria.list();

        // 统计总记录数
        criteria.setProjection(Projections.rowCount());
        pager.setTotalRow(Integer.valueOf(criteria.uniqueResult().toString()));

        return resultList;
    }

    public T findById(Class<T> entityClass, PK pk) {
        return (T) getSession().get(entityClass, pk);
    }
}
