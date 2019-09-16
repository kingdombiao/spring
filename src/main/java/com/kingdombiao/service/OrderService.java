package com.kingdombiao.service;

import com.kingdombiao.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Transactional
    public int addOrder(){
        int result = orderDao.insert();
        System.out.println("添加成功...........");

        int error=result/0;

        return result;
    }

    public int test(){
        System.out.println("测试成功........");
        return 1;
    }
}
