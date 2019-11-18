package com.kingdombiao.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insert(){
        String sql="insert into t_order (ordertime,ordermoney,orderstatus) values(?,?,?)";
        return jdbcTemplate.update(sql,new Date(),100,"1");
    }

    public int delete(){
        String sql="delete from t_order where id=?";
        return jdbcTemplate.update(sql,5);
    }

    public List<Map<String, Object>> select(Integer id){
        String sql="select * from t_order where id=?";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql, id);
        return mapList;
    }
}
