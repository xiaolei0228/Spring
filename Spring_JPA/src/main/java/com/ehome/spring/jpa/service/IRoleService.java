package com.ehome.spring.jpa.service;

import java.util.List;

/**
 * Created by haoxiaolei on 2015-01-20 11:06
 */
public interface IRoleService<T, ID> {

    T save(T role);

    List<T> saveInBatch(List<T> roleList);

}
