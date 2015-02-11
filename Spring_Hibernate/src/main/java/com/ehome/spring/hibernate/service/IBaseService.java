package com.ehome.spring.hibernate.service;

import com.ehome.spring.hibernate.module.Function;
import com.ehome.spring.hibernate.util.Pager;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

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
    T delete(T entity);

    /**
     * 根据Id删除对象
     *
     * @param entityClass 要删除的对象的类型
     * @param id          对象主键
     */
    void delete(Class<T> entityClass, PK id);

    /**
     * 根据主键查询对象
     *
     * @param entityClass 对象的class
     * @param pk          主键
     *
     * @return 对象实体
     */
    T findById(Class<T> entityClass, PK pk);

    List<T> findList(Class<T> entityClass, DetachedCriteria detachedCriteria);

    List<T> findList(Class<T> entityClass, DetachedCriteria detachedCriteria, Pager pager);

    List<T> findAll(Class<T> entityClass, DetachedCriteria detachedCriteria);

}
