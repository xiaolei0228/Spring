package com.ehome.spring.hibernate.dao.impl;

import com.ehome.spring.hibernate.dao.IBaseDao;
import com.ehome.spring.hibernate.util.Pager;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.RootEntityResultTransformer;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by haoxiaolei on 2015-01-27 16:37
 */
@Repository("baseDao")
public  class BaseDaoImpl<T, PK extends Serializable> implements IBaseDao<T, PK> {

    @Resource
    protected SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Session getNewSession() {
        return sessionFactory.openSession();
    }

    protected void flush() {
        getSession().flush();;
    }

    protected void clear() {
        getSession().clear();
    }

    /**
     * 保存
     *
     * @param entity 对象实体
     *
     * @return 保存后的对象
     */
    public T save(T entity) {
        getSession().save(entity);
        return entity;
    }

    /**
     * 批量保存
     *
     * @param entities 对象集合
     *
     * @return 保存后的对象集合
     */
    public Collection<T> save(Collection<T> entities) {
        for (T entity : entities) {
            getSession().save(entity);
        }
        return entities;
    }

    /**
     * 更新
     *
     * @param entity 对象实体
     *
     * @return 更新后的对象
     */
    public T update(T entity) {
        getSession().update(entity);
        return entity;
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
            for (T entity : entities) {
                getSession().update(entity);
            }
        }
        return entities;
    }

    /**
     * 删除
     *
     * @param entity 要删除的对象
     *
     * @return 返回删除的对象
     */
    public T delete(T entity) {
        getSession().delete(entity);
        return entity;
    }

    /**
     * 根据Id删除对象
     *
     * @param entityClass 要删除的对象的类型
     * @param pk          对象主键
     *
     * @return 删除的对象
     */
    public T delete(Class<T> entityClass, PK pk) {
        T obj = findById(entityClass, pk);
        return delete(obj);
    }

    /**
     * 批量删除
     *
     * @param entities 对象集合
     *
     * @return 删除的对象集合
     */
    public List<T> delete(List<T> entities) {
        List<T> deletedList = new ArrayList<>();
        if (entities != null && entities.size() > 0) {
            for (T entity : entities) {
                deletedList.add(delete(entity));
            }
        }
        return deletedList;
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
        List<T> deletedList = new ArrayList<>();
        Criteria criteria = getCriteria(entityClass, detachedCriteria, null);
        List list = criteria.list();
        for (Object obj : list) {
            deletedList.add(delete((T) obj));
        }
        return deletedList;
    }

    /**
     * 根据某个字段查询
     *
     * @param entityClass 要删除的对象的类型
     * @param name        字段名称
     * @param value       字段值
     */
    public List<T> find(Class<T> entityClass, String name, String value) {
        String sql = "from " + entityClass.getSimpleName() + " where " + name + "=:value";
        Query query = getSession().createQuery(sql);
        query.setParameter("value", value);
        return query.list();
    }

    /**
     * 根据条件查询对象集合
     *
     * @param entityClass      要查询的对象的类型
     * @param detachedCriteria 查询条件，如果为null，则查询全部
     * @param propertyList 查询指定的属性(字段)
     * @return 对象集合
     */
    public List<T> findList(Class<T> entityClass, DetachedCriteria detachedCriteria, List<String> propertyList) {
        Criteria criteria = getCriteria(entityClass, detachedCriteria, propertyList);
        return criteria.list();
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
    public List<T> findList(Class<T> entityClass, DetachedCriteria detachedCriteria, List<String> propertyList, Pager pager) {
        Criteria criteria = getCriteria(entityClass, detachedCriteria, propertyList);
        // 查询
        criteria.setFirstResult(pager.getStart());
        criteria.setMaxResults(pager.getPageSize());
        List resultList = criteria.list();

        // 统计总记录数
        criteria.setProjection(Projections.rowCount());
        pager.setTotalRow(Integer.valueOf(criteria.uniqueResult().toString()));

        return resultList;
    }

    /**
     * 根据条件查询条件内的所有对象集合
     *
     * @param entityClass      要查询的对象的类型
     *
     * @return 对象集合
     */
    public List<T> findAll(Class<T> entityClass) {
        return findList(entityClass, null, null);
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
        return (T) getSession().get(entityClass, pk);
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
        Criteria criteria = getSession().createCriteria(entityClass);
        criteria.add(Restrictions.in("id", idList));
        return criteria.list();
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
        Criteria criteria = getCriteria(entityClass, detachedCriteria, null);
        criteria.setProjection(Projections.rowCount());
        return Long.valueOf(criteria.uniqueResult().toString());
    }


    private Criteria getCriteria(Class<T> entityClass, DetachedCriteria detachedCriteria, List<String> propertyList) {
        Criteria criteria;
        if (detachedCriteria != null) {
            criteria = detachedCriteria.getExecutableCriteria(getSession());
        } else {
            criteria = getSession().createCriteria(entityClass);
        }

        if (propertyList != null && propertyList.size() > 0) {
            ProjectionList projectionList = Projections.projectionList();
            for (String prop : propertyList) {
                projectionList.add(Projections.property(prop));
            }
            criteria.setProjection(projectionList);
            criteria.setResultTransformer(new RootEntityResultTransformer(entityClass));
        }

        return criteria;
    }
}
