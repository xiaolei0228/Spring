package com.ehome.spring.jpa.dao.impl;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;
import java.io.Serializable;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by haoxiaolei on 2015-01-23 18:43
 */
public class MyRepositoryFactory extends JpaRepositoryFactory {

    public MyRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
    }

    protected SimpleJpaRepository getTargetRepository(RepositoryMetadata metadata, EntityManager em) {
        JpaEntityInformation<Object, Serializable> entityMetadata = mock(JpaEntityInformation.class);
        when(entityMetadata.getJavaType()).thenReturn((Class<Object>) metadata.getDomainType());
        return new MyCustomRepository<>(entityMetadata, em);
    }

    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return MyCustomRepository.class;
    }
}
