package com.ehome.spring.hibernate.service.impl;

import com.ehome.spring.hibernate.module.Function;
import com.ehome.spring.hibernate.service.IFunctionService;
import org.springframework.stereotype.Service;

/**
 * Created by xiaolei on 2015-01-18 0:07
 */
@Service(value = "functionService")
public class FunctionServiceImpl extends BaseServiceImpl<Function, Long> implements IFunctionService {


    public void saveFun() {
        Function function = findById(Function.class, 2L);
        function.setDescription("更新操作");
        update(function);

        Function viewFun = new Function();
        viewFun.setName("查看");
        viewFun.setEname("view");
        viewFun.setDescription("查看操作");
        save(viewFun);
    }
}
