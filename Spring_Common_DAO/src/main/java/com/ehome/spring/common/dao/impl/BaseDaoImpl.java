package com.ehome.spring.common.dao.impl;

import com.ehome.spring.common.dao.IBaseDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

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
}
