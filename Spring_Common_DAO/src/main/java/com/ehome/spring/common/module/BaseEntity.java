package com.ehome.spring.common.module;

import java.io.Serializable;

/**
 * Created by haoxiaolei on 2015-02-05 16:42
 */
public abstract class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
