package com.zhouyu.spring.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @ClassName ZhouyuBeanPostProcessor
 * @Description
 * @Author wangtao
 * @Date 2021/11/17 21:32
 */
//@Component
public class ZhouyuBeanPostProcessor implements InstantiationAwareBeanPostProcessor, MergedBeanDefinitionPostProcessor {

	//InstantiationAwareBeanPostProcessor
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("实例化前");
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println("实例化后");
		return false;
	}

	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		//处理@Autowired @Resource @Value注解
		return null;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("初始化前");
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("初始化后");
		return null;
	}


	//MergedBeanDefinitionPostProcessor
	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
//		beanDefinition.setInitMethodName("a");//设置初始化方法
	}
}
