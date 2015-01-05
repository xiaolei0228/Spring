package com.ehome.spring_tx.module;

/**
 * @version V1.0
 * @Project: Spring
 * @Title:
 * @Package com.ehome.spring_aop.xml.service
 * @Description:
 * @Author xiaolei-0228@163.com
 * @Date 2014/6/27 0027 22:39
 * @Copyright: 2014 ihome.com
 */
public class User {
    private Long id;
    private String name;
    private String sex;
    private String mobile;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
