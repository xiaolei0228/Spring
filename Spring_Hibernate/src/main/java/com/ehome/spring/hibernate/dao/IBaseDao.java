package com.ehome.spring.hibernate.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by haoxiaolei on 2015-01-27 16:35
 */
public abstract interface IBaseDao<T, PK extends Serializable> {
    public T save(T entity);

    public T get(Class<T> c, PK pk);

    public List<T> getAllList(Class<T> c);
}
