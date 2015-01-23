package com.ehome.spring.jpa.controller;

import com.ehome.spring.jpa.module.Function;
import com.ehome.spring.jpa.module.Role;
import com.ehome.spring.jpa.service.IFunctionService;
import com.ehome.spring.jpa.service.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by xiaolei on 2015-01-17 23:23
 */

@Controller
@RequestMapping("/role")
public class RoleController {

    @Resource
    private IRoleService roleService;


    @RequestMapping("save")
    @ResponseBody
    public Object save(Role role) {
        role.setName("管理员");

        return roleService.save(role);
    }
}
