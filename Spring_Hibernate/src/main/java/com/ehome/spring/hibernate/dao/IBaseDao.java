package com.ehome.spring.hibernate.dao;

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

    List<T> getAllList(Class<T> c);

    T findById(Class<T> entityClass, PK pk);
}
