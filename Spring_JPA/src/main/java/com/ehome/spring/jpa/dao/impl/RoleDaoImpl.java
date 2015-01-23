package com.ehome.spring.jpa.dao.impl;

import com.ehome.spring.jpa.dao.IRoleDao;
import com.ehome.spring.jpa.module.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by haoxiaolei on 2015-01-20 11:10
 */
@Repository("roleDao")
public class RoleDaoImpl  implements IRoleDao<Role, Long> {

}
