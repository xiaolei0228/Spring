package com.ehome.spring.jpa.dao.impl;

import com.ehome.spring.jpa.dao.IBaseDao;
import com.ehome.spring.jpa.module.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by xiaolei on 2015-01-19 22:37
 */
public class BaseDaoImpl implements IBaseDao {

    @PersistenceContext
    private EntityManager em;


    /**
     * 保存
     *
     * @param entity 实体对象
     *
     * @return 保存后的对象
     */
    public BaseEntity save(BaseEntity entity) {
        em.persist(entity);
        return entity;
    }

    /**
     * 批量保存
     *
     * @param iterable 对象集合
     *
     * @return 保存后的对象集合
     */
    public Iterable saveInBatch(Iterable iterable) {
        return null;
    }

    /**
     * 更新
     *
     * @param entity 实体对象
     *
     * @return 更新后的对象
     */
    public BaseEntity update(BaseEntity entity) {
        return null;
    }

    /**
     * 批量更新
     *
     * @param iterable 对象集合
     *
     * @return 更新后的对象
     */
    public Iterable updateInBatch(Iterable iterable) {
        return null;
    }
}
