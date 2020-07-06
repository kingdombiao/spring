package com.kingdombiao.designMode.StrategyPattern;

/**
 * @Author shangbiao.wang
 * @Description: TODO
 * @Date 2020-07-03 09:53
 */
public interface OrderService {

    /**
     * 根据订单类型做出不同的处理
     * @param orderDto
     * @return
     */
    String handle(OrderDto orderDto);
}
