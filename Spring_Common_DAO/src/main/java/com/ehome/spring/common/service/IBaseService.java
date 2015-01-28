package com.ehome.spring.common.service;

import java.io.Serializable;

/**
 * Created by haoxiaolei on 2015-01-27 17:30
 */
public interface IBaseService<T, PK extends Serializable> {

    /**
     * 保存
     *
     * @param entity 对象实体
     *
     * @return 保存后的对象
     */
    T save(T entity);

    /**
     * 批量保存
     *
     * @param entities 对象集合
     *
     * @return 保存后的对象集合
     */
    Iterable<T> save(Iterable<T> entities);
}
