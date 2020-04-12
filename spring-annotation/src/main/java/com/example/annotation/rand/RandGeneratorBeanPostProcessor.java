package com.example.annotation.rand;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;
import java.util.Random;

@Configuration
public class RandGeneratorBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(RandGenerator.class))
                .forEach(field -> {
                    RandGenerator annotation = field.getAnnotation(RandGenerator.class);
                    field.setAccessible(true);
                    int value = new Random().nextInt(annotation.max() - annotation.min()) + annotation.min();
                    ReflectionUtils.setField(field, bean, value);
                });

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
