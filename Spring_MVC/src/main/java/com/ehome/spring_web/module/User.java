package com.ehome.spring_web.module;

/**
 * @version V1.0
 * @Project: Spring
 * @Title:
 * @Package com.ehome.spring.ioc.module
 * @Description:
 * @Author xiaolei-0228@163.com
 * @Date 2014/6/13 0013 22:59
 * @Copyright: 2014 ihome.com
 */
public class User {
    private Long id;
    private String name;
    private String password;
    private Boolean enable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
