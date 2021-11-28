package com.zhouyu.spring.service;


import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @author 周瑜
 */
@Component
//@Conditional(ZhouyuCondition.class) 条件判断，返回true才会创建bean
public class UserService
//		implements
//		UserInterface,
//		SmartInitializingSingleton
//		, SmartFactoryBean, DisposableBean, AutoCloseable
{
//public abstract class UserService {

	@Autowired
	@Lazy
	private User user;


	public void test() {
		System.out.println("test");
		System.out.println(user);
//		throw new RuntimeException();
	}

	@PreDestroy
	public void a(){
		System.out.println("bean销毁");
	}


	//如果是抽象类，但是有LookUp注解，则可以创建bean
//	@Lookup("user")  //找名字叫做user的bean，不管返回值是啥都会返回user对象
//	public User a(){
//		return null;
//	}

	//所有单例bean创建完成之后执行（SmartInitializingSingleton）
//	@Override
//	public void afterSingletonsInstantiated() {
//
//	}


	//SmartFactoryBean
//	@Override
//	public Object getObject() throws Exception {
//		return null;
//	}
//
//	@Override
//	public Class<?> getObjectType() {
//		return null;
//	}
//
//	//如果返回true，在创建factorybean时就会调用getObject方法，否则会在getBean时调用
//	@Override
//	public boolean isEagerInit() {
//		return false;
//	}
//
//
//	//DisposableBean
//	@Override
//	public void destroy() throws Exception {
//		//在进程正常关闭时调用
//		System.out.println("销毁bean");
//	}
//
//
//	//AutoCloseable
//	@Override
//	public void close() throws Exception {
//		//在进程正常关闭时调用
//		System.out.println("销毁bean");
//	}
}
