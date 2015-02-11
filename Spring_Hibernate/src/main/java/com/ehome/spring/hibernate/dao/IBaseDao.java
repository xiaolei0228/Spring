package com.ehome.spring.hibernate.dao;

import com.ehome.spring.hibernate.util.Pager;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by haoxiaolei on 2015-01-27 16:35
 */
public abstract interface IBaseDao<T, PK extends Serializable> {
    T save(T entity);

    Collection<T> save(Collection<T> entities);

    T update(T entity);

    Collection<T> update(Collection<T> entities);

    List<T> findList(Class<T> entityClass, DetachedCriteria detachedCriteria);

    List<T> findList(Class<T> entityClass, DetachedCriteria detachedCriteria, Pager pager);

    List<T> findAll(Class<T> entityClass, DetachedCriteria detachedCriteria);

    T findById(Class<T> entityClass, PK pk);
}
