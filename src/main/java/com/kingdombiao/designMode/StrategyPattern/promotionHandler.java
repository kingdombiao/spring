package com.kingdombiao.designMode.StrategyPattern;

import org.springframework.stereotype.Service;

/**
 * @Author shangbiao.wang
 * @Description: TODO
 * @Date 2020-07-03 10:06
 */
@Service
@HandleType("3")
public class promotionHandler extends AbstractHandler{
    @Override
    public String handle(OrderDto dto) {
        return dto.toString()+this.getClass().getName();
    }
}
