package com.ehome.spring.common.dao;

import java.io.Serializable;

/**
 * Created by haoxiaolei on 2015-01-27 16:35
 */
public abstract interface IBaseDao<T, PK extends Serializable> {

    T save(T entity);
}
