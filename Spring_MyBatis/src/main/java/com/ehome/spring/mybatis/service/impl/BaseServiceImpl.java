package com.ehome.spring.mybatis.service.impl;

import com.ehome.spring.mybatis.service.IBaseService;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author haoxiaolei
 * @date 2015-02-14 22:24
 */
@Service("baseService")
public class BaseServiceImpl<T, PK extends Serializable> implements IBaseService<T, PK> {


}
