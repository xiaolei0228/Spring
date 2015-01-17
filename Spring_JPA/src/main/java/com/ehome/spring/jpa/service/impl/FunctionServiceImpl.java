package com.ehome.spring.jpa.service.impl;

import com.ehome.spring.jpa.dao.IFunctionDao;
import com.ehome.spring.jpa.module.Function;
import com.ehome.spring.jpa.service.IFunctionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xiaolei on 2015-01-18 0:07
 */
@Service(value = "funcService")
public class FunctionServiceImpl implements IFunctionService {

    @Resource
    private IFunctionDao functionDao;

    public Function sava(Function function) {
        return functionDao.save(function);
    }
}
