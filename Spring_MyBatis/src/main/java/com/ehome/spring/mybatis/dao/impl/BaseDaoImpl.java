package com.ehome.spring.mybatis.dao.impl;

import com.ehome.spring.mybatis.dao.IBaseDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 
 * @author  haoxiaolei
 * @date    2015-02-14 22:21
 */
@Repository("baseDao")
public  class BaseDaoImpl<T, PK extends Serializable> extends SqlSessionDaoSupport implements IBaseDao<T, PK> {


}
