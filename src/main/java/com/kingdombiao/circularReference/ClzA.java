package com.kingdombiao.circularReference;

import org.springframework.stereotype.Component;

/**
 * @Authror biao
 * @Description: 对象A
 * @Date: 2020-03-23 下午 6:14
 */
///@Component
public class ClzA {
    private ClzB clzB;

    public void setClzB(ClzB clzB) {
        this.clzB = clzB;
    }

    public ClzA() {
    }

    public ClzA(ClzB clzB) {
        this.clzB = clzB;
    }

    public ClzB getClzB() {
        return clzB;
    }
}
