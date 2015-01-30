package com.ehome.spring.jpa.service;

import com.ehome.spring.jpa.module.Function;

/**
 * Created by xiaolei on 2015-01-18 0:06
 */
public interface IFunctionService {

    public Function save(Function function);

    public Function update(Function function);

    public Function findById(Long id);
}
