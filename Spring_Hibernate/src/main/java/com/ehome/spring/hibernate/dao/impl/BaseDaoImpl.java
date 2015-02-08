package com.ehome.spring.hibernate.dao.impl;

import com.ehome.spring.hibernate.dao.IBaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by haoxiaolei on 2015-01-27 16:37
 */
@Repository("baseDao")
public  class BaseDaoImpl<T, PK extends Serializable> extends HibernateDaoSupport implements IBaseDao<T, PK> {

    @Resource
    protected SessionFactory sessionFactory;
    protected Session session = sessionFactory.getCurrentSession();


    public T save(T entity) {
        return null;
    }

    public T get(Class<T> c, PK pk) {
        return (T) session.get(c, pk);
    }

    public List<T> getAllList(Class<T> c) {
        return null;
    }
}
