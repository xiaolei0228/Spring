package com.ehome.spring.jpa.dao.impl;

import com.ehome.spring.jpa.dao.MyRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by haoxiaolei on 2015-01-23 18:40
 */
@NoRepositoryBean
public class MyCustomRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID> {

    private EntityManager entityManager;

    public MyCustomRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public MyCustomRepository(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        entityManager = em;
    }

    public String sharedCustomMethod() {
        return "hello sharedCustomMethod";
    }
}
