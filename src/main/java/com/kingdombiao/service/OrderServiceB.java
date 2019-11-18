package com.kingdombiao.service;

import com.kingdombiao.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author biao
 * @create 2019-09-24 14:47
 */
@Service
public class OrderServiceB {

    @Autowired
    private OrderDao orderDao;

    @Transactional(propagation = Propagation.NEVER)
    public int delete(){
        int result = orderDao.delete();
        System.out.println("删除成功...........");
        return result;
    }
}
