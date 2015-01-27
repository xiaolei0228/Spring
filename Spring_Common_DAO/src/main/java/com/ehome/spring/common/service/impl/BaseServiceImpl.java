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


    public T save(T entity) {
        return baseDao.save(entity);
    }
}
