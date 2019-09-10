package com.kingdombiao.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author biao
 * @create 2019-09-09 16:03
 */
public class Bird {

    private String name;
    private Integer age;

    @Value("${bird.color}")
    private String color;

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
