package com.example.annotation.deprecated;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.type.MethodMetadata;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class DeprecatedServiceBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanDefinitionName);
            String beanClassName = beanDefinition.getBeanClassName();

            if (beanClassName == null)
                beanClassName = resolveBeanClassNameFromConfigurationBeanDefinition(beanDefinition);
            try {
                Class<?> aClass = Class.forName(beanClassName);
                DeprecatedService annotation = aClass.getAnnotation(DeprecatedService.class);
                if (annotation != null) {
                    beanDefinition.setBeanClassName(annotation.actual().getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private String resolveBeanClassNameFromConfigurationBeanDefinition(BeanDefinition beanDefinition) {
        try {
            Object reader = Class.forName("org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader$ConfigurationClassBeanDefinition")
                    .cast(beanDefinition);
            Field field = reader.getClass().getDeclaredField("factoryMethodMetadata");
            field.setAccessible(true);
            return ((MethodMetadata) field.get(reader)).getReturnTypeName();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
