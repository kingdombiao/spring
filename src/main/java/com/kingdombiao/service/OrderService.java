package com.kingdombiao.service;

import com.kingdombiao.dao.OrderDao;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderServiceB orderServiceB;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int addOrder(){
        int result = orderDao.insert();
        System.out.println("添加成功...........");

        OrderService orderService = (OrderService) AopContext.currentProxy();

        //orderService.delete();

       // int error=result/0;

        return result;
    }

    public void delete() {
        orderDao.delete();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public  List<Map<String, Object>> select(Integer id) {

        OrderService orderService = (OrderService) AopContext.currentProxy();
        for (int i=0;i<5;i++) {
            orderService.addOrder();
        }
        List<Map<String, Object>> mapList = orderDao.select(id);
        return mapList;
    }
}
