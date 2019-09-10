package com.kingdombiao.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author biao
 * @create 2019-09-09 10:03
 */
@Component
@Scope(value = "prototype")
public class Train implements InitializingBean, DisposableBean {

    public Train() {
        System.out.println("train constructor..................");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("train afterPropertiesSet..................");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("train destroy..................");
    }
}
