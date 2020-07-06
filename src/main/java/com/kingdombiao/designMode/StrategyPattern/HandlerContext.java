package com.kingdombiao.designMode.StrategyPattern;

import lombok.Builder;

import java.util.Map;

/**
 * @Author shangbiao.wang
 * @Description: TODO
 * @Date 2020-07-03 09:56
 */
public class HandlerContext {
    private Map<String, Class> handleMap;

    public HandlerContext(Map<String, Class> handleMap) {
        this.handleMap = handleMap;
    }

    public AbstractHandler getInstance(String type){
        Class clazz = handleMap.get(type);
        if(clazz==null){
            throw new IllegalArgumentException("未找到订单类型【" + type + "】的处理类");
        }
        return (AbstractHandler) SpringContextUtil.getBean(clazz);
    }
}
