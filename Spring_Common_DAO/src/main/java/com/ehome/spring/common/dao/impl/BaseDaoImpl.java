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
public abstract class BaseDaoImpl<T, PK extends Serializable> implements IBaseDao<T, PK> {

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
}
