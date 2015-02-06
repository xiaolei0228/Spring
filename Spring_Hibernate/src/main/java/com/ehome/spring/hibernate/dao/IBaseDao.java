package com.ehome.spring.hibernate.dao;

import java.io.Serializable;

/**
 * Created by haoxiaolei on 2015-01-27 16:35
 */
public abstract interface IBaseDao<T, PK extends Serializable> {
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

    /**
     * 更新
     *
     * @param enitty 对象实体
     *
     * @return 更新后的对象
     */
    T update(T enitty);

    /**
     * 删除
     *
     * @param entity 要删除的对象
     *
     * @return 返回删除的对象
     */
    T delete(T entity);

    /**
     * 根据主键起查询对象
     *
     * @param entityClass 对象的class
     * @param pk          主键
     *
     * @return 对象实体
     */
    T findById(Class<T> entityClass, PK pk);

}
