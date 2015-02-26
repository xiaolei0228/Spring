package com.ehome.spring.mybatis.dao.impl;

import com.ehome.spring.mybatis.dao.IBaseDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 
 * @author  haoxiaolei
 * @date    2015-02-14 22:21
 */
@Repository("baseDao")
public  class BaseDaoImpl<T, PK extends Serializable> extends SqlSessionDaoSupport implements IBaseDao<T, PK> {

    private SqlSessionTemplate sessionTemplate;

    @Autowired
    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }
}
