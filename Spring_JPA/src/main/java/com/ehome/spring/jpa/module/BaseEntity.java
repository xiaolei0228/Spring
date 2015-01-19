package com.ehome.spring.jpa.module;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by xiaolei on 2015-01-19 22:40
 */
public class BaseEntity implements Serializable {

    private Long id;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
