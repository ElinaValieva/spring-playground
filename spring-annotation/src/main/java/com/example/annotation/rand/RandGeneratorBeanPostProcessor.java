package com.example.annotation.rand;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Configuration
public class RandGeneratorBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(RandGenerator.class)) {
                RandGenerator annotation = declaredField.getAnnotation(RandGenerator.class);
                declaredField.setAccessible(true);
                int value = new Random().nextInt(annotation.max() - annotation.min()) + annotation.min();
                ReflectionUtils.setField(declaredField, bean, value);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
