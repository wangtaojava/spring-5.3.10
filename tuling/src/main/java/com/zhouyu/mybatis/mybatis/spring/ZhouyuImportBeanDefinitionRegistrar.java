package com.zhouyu.mybatis.mybatis.spring;

import com.zhouyu.mybatis.mapper.OrderMapper;
import com.zhouyu.mybatis.mapper.UserMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author 周瑜
 */
//@Component
public class ZhouyuImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
		//获取扫描路径
		Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(ZhoyuMapperScan.class.getName());
		String path = (String) annotationAttributes.get("value");
		System.out.println(path);


		ZhouyuBeanDefinitionScanner scanner = new ZhouyuBeanDefinitionScanner(registry);

		scanner.addIncludeFilter(new TypeFilter() {
			@Override
			public boolean match(@NotNull MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
				//默认返回true，都可以扫描，因为spring内部会过滤接口
				return true;
			}
		});

		scanner.scan(path);


//		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//		beanDefinition.setBeanClass(ZhouyuFactoryBean.class);
//		//设置参数
//		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
//		//注册
//		registry.registerBeanDefinition("userMapper", beanDefinition);
//
//		AbstractBeanDefinition beanDefinition1 = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//		beanDefinition1.setBeanClass(ZhouyuFactoryBean.class);
//		//设置参数
//		beanDefinition1.getConstructorArgumentValues().addGenericArgumentValue(OrderMapper.class);
//		//注册
//		registry.registerBeanDefinition("orderMapper", beanDefinition1);


		// 扫描路径
//		Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(ZhoyuMapperScan.class.getName());
//		String path = (String) annotationAttributes.get("value");
//
//
//		ZhouyuBeanDefinitionScanner scanner = new ZhouyuBeanDefinitionScanner(registry);
//
//		scanner.addIncludeFilter(new TypeFilter() {
//			@Override
//			public boolean match(@NotNull MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
//				return true;
//			}
//		});
//
//		scanner.scan(path);
	}
}
