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
     * @param enitty 对象实体
     *
     * @return 更新后的对象
     */
    public T update(T enitty) {
        return baseDao.update(enitty);
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
     */
    public void delete(Class<T> entityClass, PK id) {
        baseDao.deleteById(entityClass, id);
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

    public List<T> findList(Class<T> entityClass, DetachedCriteria detachedCriteria) {
        return baseDao.findList(entityClass, detachedCriteria);
    }

    public List<T> findList(Class<T> entityClass, DetachedCriteria detachedCriteria, Pager pager) {
        return baseDao.findList(entityClass, detachedCriteria, pager);
    }

    public List<T> findAll(Class<T> entityClass, DetachedCriteria detachedCriteria) {
        return baseDao.findAll(entityClass, detachedCriteria);
    }


}
