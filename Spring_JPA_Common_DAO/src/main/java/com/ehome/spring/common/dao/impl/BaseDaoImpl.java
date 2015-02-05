package com.ehome.spring.common.dao.impl;

import com.ehome.spring.common.dao.IBaseDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoxiaolei on 2015-01-27 16:37
 */
@Repository("baseDao")
public class BaseDaoImpl<T, PK extends Serializable> implements IBaseDao<T, PK> {

    @PersistenceContext
    private EntityManager em;

    public T save(T entity) {
        em.persist(entity);
        return entity;
    }

    /**
     * 批量保存
     *
     * @param entities 对象集合
     *
     * @return 保存后的对象集合
     */
    public Iterable<T> save(Iterable<T> entities) {
        List<T> result = new ArrayList<>();
        if (entities == null) {
            return result;
        }
        for (T entity : entities) {
            result.add(save(entity));
        }
        return result;
    }

    /**
     * 更新
     *
     * @param enitty 对象实体
     *
     * @return 更新后的对象
     */
    public T update(T enitty) {
        return em.merge(enitty);
    }

    /**
     * 删除
     *
     * @param entity 要删除的对象
     *
     * @return 返回删除的对象
     */
    public T delete(T entity) {
        em.remove(em.merge(entity));
        return entity;
    }

    /**
     * 根据主键起查询对象
     *
     * @param entityClass 对象的class
     * @param pk          主键
     *
     * @return 对象实体
     */
    public T findById(Class<T> entityClass, PK pk) {
        return em.find(entityClass, pk);
    }
}
