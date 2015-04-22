package com.ehome.spring.hibernate.module;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-04-22 10:38
 * @desc: 用户表     复合主键
 */
@Entity
@Table(name = "t_user")
@DynamicUpdate(value = true)
public class User implements Serializable {
    private String name;
    private String mobile;
    private Integer age;
    private String address;

    @Id
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "mobile", nullable = false, length = 15)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "age", length = 3)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "address", length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
