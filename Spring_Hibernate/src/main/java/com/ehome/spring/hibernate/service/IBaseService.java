package com.ehome.spring.hibernate.service;

import java.io.Serializable;
import java.util.Collection;

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
    Collection<T> save(Collection<T> entities);

    /**
     * 更新
     *
     * @param enitty 对象实体
     *
     * @return 更新后的对象
     */
    T update(T enitty);

    /**
     * 批量更新
     *
     * @param entities 对象集合
     *
     * @return 更新后的对象集合
     */
    Collection<T> update(Collection<T> entities);

    /**
     * 删除
     *
     * @param entity 要删除的对象
     *
     * @return 返回删除的对象
     */
    //T delete(T entity);

    /**
     * 根据主键查询对象
     *
     * @param entityClass 对象的class
     * @param pk          主键
     *
     * @return 对象实体
     */
    T findById(Class<T> entityClass, PK pk);


}
