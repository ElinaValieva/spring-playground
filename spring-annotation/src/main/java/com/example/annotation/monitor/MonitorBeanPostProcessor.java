package com.example.annotation.monitor;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Log4j2
@Configuration
public class MonitorBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Object> beanMap = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        beanMap.put(beanName, bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Object beanFromInitialization = beanMap.get(beanName);
        if (beanFromInitialization != null) {
            Class<?> aClass = beanFromInitialization.getClass();
            if (aClass.isAnnotationPresent(Monitor.class)) {
                return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                    long start = System.nanoTime();
                    Object invoke = method.invoke(bean, args);
                    long timeSeconds = TimeUnit.SECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS);
                    long timeMilliSeconds = TimeUnit.MILLISECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS);
                    log.info("Memory: {}, Time: {} s {} ms", Runtime.getRuntime().freeMemory(), timeSeconds, timeMilliSeconds);

                    return invoke;
                });
            }
        }
        return bean;
    }
}
