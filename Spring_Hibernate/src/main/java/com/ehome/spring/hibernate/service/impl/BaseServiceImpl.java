package com.ehome.spring.hibernate.service.impl;

import com.ehome.spring.hibernate.dao.IBaseDao;
import com.ehome.spring.hibernate.service.IBaseService;
import com.ehome.spring.hibernate.util.Pager;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by haoxiaolei on 2015-01-27 17:31
 */
@Service("baseService")
public class BaseServiceImpl<T, PK extends Serializable> implements IBaseService<T, PK> {

    @Resource
    private IBaseDao<T, PK> baseDao;


    /**
     * 保存
     *
     * @param entity 对象实体
     *
     * @return 保存后的对象
     */
    public T save(T entity) {
        return baseDao.save(entity);
    }

    /**
     * 批量保存
     *
     * @param entities 对象集合
     *
     * @return 保存后的对象集合
     */
    public Collection<T> save(Collection<T> entities) {
        if (entities != null && entities.size() > 0) {
            return baseDao.save(entities);
        } else return null;
    }

    /**
     * 更新
     *
     * @param entity 对象实体
     *
     * @return 更新后的对象
     */
    public T update(T entity) {
        return baseDao.update(entity);
    }

    /**
     * 批量更新
     *
     * @param entities 对象集合
     *
     * @return 更新后的对象集合
     */
    public Collection<T> update(Collection<T> entities) {
        if (entities != null && entities.size() > 0) {
            return baseDao.update(entities);
        } else return null;
    }

    /**
     * 删除
     *
     * @param entity 要删除的对象
     *
     * @return 返回删除的对象
     */
    public T delete(T entity) {
        return baseDao.delete(entity);
    }

    /**
     * 根据Id删除对象
     *
     * @param entityClass 要删除的对象的类型
     * @param id          对象主键
     *
     * @return 删除的对象
     */
    public T delete(Class<T> entityClass, PK id) {
        return baseDao.delete(entityClass, id);
    }

    /**
     * 批量删除
     *
     * @param entities 对象集合
     *
     * @return 删除的对象集合
     */
    public List<T> delete(List<T> entities) {
        return baseDao.delete(entities);
    }

    /**
     * 根据条件删除对象集合
     *
     * @param entityClass      要删除的对象的类型
     * @param detachedCriteria 删除条件，如果为null，则删除全部
     *
     * @return 删除的对象集合
     */
    public List<T> delete(Class<T> entityClass, DetachedCriteria detachedCriteria) {
        return baseDao.delete(entityClass, detachedCriteria);
    }

    /**
     * 根据某个字段查询
     * (单表操作)
     *
     * @param entityClass 要删除的对象的类型
     * @param name        字段名称
     * @param value       字段值
     */
    public List<T> find(Class<T> entityClass, String name, String value) {
        return baseDao.find(entityClass, name, value);
    }

    /**
     * 根据条件查询对象集合
     *
     * @param entityClass      要查询的对象的类型
     * @param detachedCriteria 查询条件，如果为null，则查询全部
     *
     * @return 对象集合
     */
    public List<T> findList(Class<T> entityClass, DetachedCriteria detachedCriteria) {
        return baseDao.findList(entityClass, detachedCriteria);
    }

    /**
     * 根据条件查询对象集合
     *
     * @param entityClass      要查询的对象的类型
     * @param detachedCriteria 查询条件，如果为null，则查询全部
     * @param propertyList 查询指定的属性(字段)
     *
     * @return 对象集合
     */
    public List<T> findList(Class<T> entityClass, DetachedCriteria detachedCriteria, List<String> propertyList) {
        return baseDao.findList(entityClass, detachedCriteria, propertyList);
    }

    /**
     * 根据条件分页查询对象集合
     *
     * @param entityClass      要查询的对象的类型
     * @param detachedCriteria 查询条件，如果为null，则查询全部
     * @param pager            分页对象
     *
     * @return 对象集合
     */
    public List<T> findListPager(Class<T> entityClass, DetachedCriteria detachedCriteria, Pager pager) {
        return baseDao.findListPager(entityClass, detachedCriteria, pager);
    }

    /**
     * 根据条件分页查询对象集合
     *
     * @param entityClass      要查询的对象的类型
     * @param detachedCriteria 查询条件，如果为null，则查询全部
     * @param propertyList 查询指定的属性(字段)
     * @param pager            分页对象
     *
     * @return 对象集合
     */
    public List<T> findListPager(Class<T> entityClass, DetachedCriteria detachedCriteria, Pager pager, List<String> propertyList) {
        return baseDao.findListPager(entityClass, detachedCriteria, pager, propertyList);
    }

    /**
     * 根据条件查询条件内的所有对象集合
     *
     * @param entityClass      要查询的对象的类型
     *
     * @return 对象集合
     */
    public List<T> findAll(Class<T> entityClass) {
        return baseDao.findAll(entityClass);
    }

    /**
     * 根据主键查询对象
     *
     * @param entityClass 对象的class
     * @param pk          主键
     *
     * @return 对象实体
     */
    public T findById(Class<T> entityClass, PK pk) {
        return baseDao.findById(entityClass, pk);
    }

    /**
     * 根据主键批量查询对象
     *
     * @param entityClass 对象的class
     * @param idList      主键集合
     *
     * @return 对象实体
     */
    public List<T> findByIds(Class<T> entityClass, List<PK> idList) {
        return baseDao.findByIds(entityClass, idList);
    }

    /**
     * 统计总记录
     *
     * @param entityClass      对象的class
     * @param detachedCriteria 条件，如果为null，则查询全部
     *
     * @return 总记录数量
     */
    public Long count(Class<T> entityClass, DetachedCriteria detachedCriteria) {
        return baseDao.count(entityClass, detachedCriteria);
    }

}
