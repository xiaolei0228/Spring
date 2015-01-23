package com.ehome.spring.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by haoxiaolei on 2015-01-23 18:27
 */
public interface MyRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    String  sharedCustomMethod();
}
