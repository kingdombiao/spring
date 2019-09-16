package com.kingdombiao.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class OrderDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insert(){
        String sql="insert into t_order (ordertime,ordermoney,orderstatus) values(?,?,?)";
        return jdbcTemplate.update(sql,new Date(),100,1);
    }
}
