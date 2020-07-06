package com.kingdombiao.designMode.StrategyPattern;

import lombok.Builder;
import lombok.Data;

/**
 * @Author shangbiao.wang
 * @Description: TODO
 * @Date 2020-07-03 09:50
 */
@Builder
@Data
public class OrderDto {

    /**
     * 订单类型：
     * 1-普通订单
     * 2-团购订单
     * 3-促销订单
     *
     */
    private String type;
}
