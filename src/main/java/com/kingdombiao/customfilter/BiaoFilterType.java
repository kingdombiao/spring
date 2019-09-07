package com.kingdombiao.customfilter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class BiaoFilterType implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        //获取当前扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        //获取当前类资源
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();

        System.out.println("*******" + className + "*******");
        if ("er".contains(className)) {
            return true;
        }
        return false;
    }
}
