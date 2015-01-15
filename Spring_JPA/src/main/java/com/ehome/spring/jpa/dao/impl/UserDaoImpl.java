package com.ehome.spring.jpa.dao.impl;

import com.ehome.spring.jpa.dao.IUserDao;
import com.ehome.spring.jpa.module.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * 
 * @author  xiaolei
 * @date    2015-01-14 23:49
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao{

    @PersistenceContext
    private EntityManager entityManager;

    public boolean save(User user) {
        entityManager.persist(user);
        return true;
    }

    public boolean update(User user) {
        return false;
    }

    public boolean delete(Long id) {
        return false;
    }

    public List<User> findList() {
        return null;
    }
}
