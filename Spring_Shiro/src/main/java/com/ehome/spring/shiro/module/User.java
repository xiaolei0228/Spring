package com.ehome.spring.shiro.module;
/**
 * Spring
 *
 * @author: haoxiaolei
 * @date: 2015-05-04 23:56
 * @desc: 
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
