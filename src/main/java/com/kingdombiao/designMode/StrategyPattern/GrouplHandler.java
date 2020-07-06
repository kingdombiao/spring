package com.kingdombiao.designMode.StrategyPattern;

import org.springframework.stereotype.Service;

/**
 * @Author shangbiao.wang
 * @Description: TODO
 * @Date 2020-07-03 09:58
 */
@Service
@HandleType("2")
public class GrouplHandler extends AbstractHandler{
    @Override
    public String handle(OrderDto dto) {
        return dto.toString()+this.getClass().getName();
    }
}
