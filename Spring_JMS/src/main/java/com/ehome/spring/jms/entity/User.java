package com.ehome.spring.jms.entity;

import java.io.Serializable;

/**
 * Spring
 *
 * @作者: haoxiaolei
 * @日期: 2016-04-06 16:12
 * @描述: 用户
 */
public class User implements Serializable {
    private static final long serialVersionUID = 4105363793571710222L;

    private Long id;
    private String name;
    private String password;
    private String pid;

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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
