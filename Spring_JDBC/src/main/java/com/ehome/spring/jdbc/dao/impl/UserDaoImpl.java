package com.ehome.spring.jdbc.dao.impl;

import com.ehome.spring.jdbc.dao.IUserDao;
import com.ehome.spring.jdbc.module.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public User save(User user) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("t_user").usingGeneratedKeyColumns("id");
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        Long id = jdbcInsert.executeAndReturnKey(parameterSource).longValue();
        user = findById(id);
        return user;
    }

    /**
     * 动态更新字段
     *  @param updateColumn 要更新的字段
     * @param where        where条件
     */
    public int update(Map<String, Object> updateColumn, Map<String, Object> where) {
        List paramList = new ArrayList();
        StringBuffer sql = new StringBuffer("update t_user set ");
        for (Map.Entry<String, Object> entry : updateColumn.entrySet()) {
            sql.append(entry.getKey()).append("=?,");
            paramList.add(entry.getValue());
        }
        sql = sql.delete(sql.length() - 1, sql.length());

        sql.append(" where ");
        for (Map.Entry<String, Object> entry : where.entrySet()) {
            sql.append(entry.getKey()).append("=? and ");
            paramList.add(entry.getValue());
        }
        sql = sql.delete(sql.lastIndexOf(" and "), sql.length());

        System.out.println(sql);

        return jdbcTemplate.update(sql.toString(), paramList.toArray());
    }


    public User update(User user) {
        String sql = "update t_user set mobile=? where id=?";
        jdbcTemplate.update(sql, user.getMobile(), user.getId());
        return user;
    }

    public User findById(Long id) {
        String sql = "select * from t_user where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<User>() {
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



}
