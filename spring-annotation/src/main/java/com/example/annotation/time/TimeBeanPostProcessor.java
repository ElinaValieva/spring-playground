package com.example.annotation.time;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Log4j2
@Configuration
public class TimeBeanPostProcessor implements BeanPostProcessor {

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
            Method[] declaredMethods = beanFromInitialization.getClass().getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                if (declaredMethod.isAnnotationPresent(Time.class)) {
                    return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                        long start = System.nanoTime();
                        log.info("Start execute method: {}", method.getName());
                        Object invoke = method.invoke(bean, args);
                        long end = System.nanoTime() - start;
                        log.info("Execution time: {} s {} ms",
                                TimeUnit.SECONDS.convert(end, TimeUnit.NANOSECONDS),
                                TimeUnit.MILLISECONDS.convert(end, TimeUnit.NANOSECONDS));
                        return invoke;
                    });
                }
            }
        }
        return bean;
    }
}
