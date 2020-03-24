package com.kingdombiao.circularReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Authror biao
 * @Description: 对象B
 * @Date: 2020-03-23 下午 6:15
 */
//@Component
public class ClzB {
    private ClzA clzA;

    public ClzB() {
    }

    public ClzB(ClzA clzA) {
        this.clzA = clzA;
    }

    @Autowired
    public void setClzA(ClzA clzA) {
        this.clzA = clzA;
    }
}
