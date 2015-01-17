package com.ehome.spring.jpa.dao;

import com.ehome.spring.jpa.module.Function;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by xiaolei on 2015-01-17 23:37
 */
public interface IFunctionDao extends PagingAndSortingRepository<Function, Long> {

}
