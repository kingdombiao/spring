package com.kingdombiao.designMode.StrategyPattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author shangbiao.wang
 * @Description: TODO
 * @Date 2020-07-03 09:55
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private HandlerContext handlerContext;


    /**
     * 根据订单类型做出不同的处理
     *
     * @param orderDto
     * @return
     */
    @Override
    public String handle(OrderDto orderDto) {
        AbstractHandler instance = handlerContext.getInstance(orderDto.getType());
        return instance.handle(orderDto);
    }
}
