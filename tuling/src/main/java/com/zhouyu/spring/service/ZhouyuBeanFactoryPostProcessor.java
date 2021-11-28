package com.zhouyu.spring.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @ClassName ZhouyuBeanFactoryPostProcessor
 * @Description
 * @Author wangtao
 * @Date 2021/11/27 10:42
 */
@Component
public class ZhouyuBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	//可以注册BeanDefinition
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//		registry.registerBeanDefinition("a", new GenericBeanDefinition());
	}

	//不能注册
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}
