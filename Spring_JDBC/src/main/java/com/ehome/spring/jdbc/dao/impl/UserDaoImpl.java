package com.ehome.spring.jdbc.dao.impl;

import com.ehome.spring.jdbc.dao.IUserDao;
import com.ehome.spring.jdbc.module.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @version V1.0
 * @Project: Spring
 * @Title:
 * @Package com.ehome.spring.ioc.dao.impl
 * @Description:
 * @Author xiaolei-0228@163.com
 * @Date 2014/6/13 0013 23:33
 * @Copyright: 2014 ihome.com
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao {

    @Resource
    JdbcTemplate jdbcTemplate;

    public User getById(Long id) {
        System.out.println("=============IUserDao.getUserById(88) Dao层方法执行了...");
        User user = new User();
        user.setId(id);
        user.setName("单车上的理想");
        return user;
    }

    public User save(User user) {
        int result = jdbcTemplate.update("INSERT INTO t_user(name, sex, mobile) VALUES ('" + user.getName() + "'," + user.getSex() + ",'" + user.getMobile() + "')");
        return user;
    }

    public List findList() {
        String sql = "select * from t_user";
        return jdbcTemplate.query(sql, new RowMapper() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User u = new User();
                u.setId(rs.getLong("id"));
                u.setName(rs.getString("name"));
                u.setSex(rs.getInt("sex"));
                u.setMobile(rs.getString("mobile"));
                return u;
            }
        });
    }

    public User update(User user) {
        String sql = "update t_user set mobile=? where id=?";
        jdbcTemplate.update(sql, user.getMobile(), user.getId());
        return user;
    }
}
