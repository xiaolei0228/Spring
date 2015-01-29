package com.ehome.spring.common.service.impl;

import com.ehome.spring.common.dao.IBaseDao;
import com.ehome.spring.common.service.IBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

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
    public Iterable<T> save(Iterable<T> entities) {
        return baseDao.save(entities);
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
}
