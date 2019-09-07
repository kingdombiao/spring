package com.kingdombiao.factoryBean;

import com.kingdombiao.bean.Fish;
import org.springframework.beans.factory.FactoryBean;

public class BiaoFactoryBean implements FactoryBean<Fish> {
    @Override
    public Fish getObject() throws Exception {
        return new Fish();
    }

    @Override
    public Class<?> getObjectType() {
        return Fish.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
