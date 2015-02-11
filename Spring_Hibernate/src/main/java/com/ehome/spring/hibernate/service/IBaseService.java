package com.ehome.spring.hibernate.service;

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
     * @param entity 对象实体
     *
     * @return 更新后的对象
     */
    T update(T entity);

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
     *
     * @return 删除的对象
     */
    T delete(Class<T> entityClass, PK id);

    /**
     * 根据条件删除对象集合
     *
     * @param entityClass      要删除的对象的类型
     * @param detachedCriteria 删除条件
     *
     * @return 删除的对象集合
     */
    List<T> delete(Class<T> entityClass, DetachedCriteria detachedCriteria);

    /**
     * 根据某个字段查询
     *
     * @param entityClass 要删除的对象的类型
     * @param name        字段名称
     * @param value       字段值
     */
    List<T> find(Class<T> entityClass, String name, String value);

    /**
     * 根据条件查询对象集合
     *
     * @param entityClass      要查询的对象的类型
     * @param detachedCriteria 查询条件
     *
     * @return 对象集合
     */
    List<T> findList(Class<T> entityClass, DetachedCriteria detachedCriteria);

    /**
     * 根据条件分页查询对象集合
     *
     * @param entityClass      要查询的对象的类型
     * @param detachedCriteria 查询条件
     * @param pager            分页对象
     *
     * @return 对象集合
     */
    List<T> findList(Class<T> entityClass, DetachedCriteria detachedCriteria, Pager pager);

    /**
     * 根据条件查询条件内的所有对象集合
     *
     * @param entityClass      要查询的对象的类型
     * @param detachedCriteria 查询条件
     *
     * @return 对象集合
     */
    List<T> findAll(Class<T> entityClass, DetachedCriteria detachedCriteria);

    /**
     * 根据主键查询对象
     *
     * @param entityClass 对象的class
     * @param pk          主键
     *
     * @return 对象实体
     */
    T findById(Class<T> entityClass, PK pk);

    /**
     * 根据主键批量查询对象
     *
     * @param entityClass 对象的class
     * @param idList      主键集合
     *
     * @return 对象实体
     */
    List<T> findByIds(Class<T> entityClass, List<PK> idList);
}
