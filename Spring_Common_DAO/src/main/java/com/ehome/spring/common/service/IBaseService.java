package com.ehome.spring.common.service;

import java.io.Serializable;

/**
 * Created by haoxiaolei on 2015-01-27 17:30
 */
public interface IBaseService<T, PK extends Serializable> {

    T save(T entity);
}
