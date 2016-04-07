package com.ehome.spring.jms.entity;

import java.io.Serializable;

/**
 * Spring
 *
 * @author: haoxiaolei
 * @date: 2016-04-06 16:12
 * @desc: 用户
 */
public class User implements Serializable {
    private static final long serialVersionUID = 4105363793571710222L;

    private Long id;
    private String name;
    private String password;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
