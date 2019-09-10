package com.kingdombiao.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DemoDao {

    private Integer flag=1;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "DemoDao{" +
                "flag=" + flag +
                '}';
    }
}
