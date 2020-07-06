package com.kingdombiao.designMode.StrategyPattern;

import java.lang.annotation.*;

/**
 * @Author shangbiao.wang
 * @Description: TODO
 * @Date 2020-07-03 10:01
 */
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface HandleType {

    String value() default "1";
}
