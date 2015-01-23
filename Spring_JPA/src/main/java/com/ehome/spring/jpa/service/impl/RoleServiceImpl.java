package com.ehome.spring.jpa.service.impl;

import com.ehome.spring.jpa.dao.IRoleDao;
import com.ehome.spring.jpa.module.Role;
import com.ehome.spring.jpa.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by haoxiaolei on 2015-01-20 11:08
 */
@Service(value = "roleService")
public class RoleServiceImpl implements IRoleService<Role, Long> {

    @Resource
    private IRoleDao roleDao;


    public Role save(Role role) {
        return roleDao.saveAndFlush(role);
    }

    public List<Role> saveInBatch(List<Role> roleList) {
        return null;
    }

}
