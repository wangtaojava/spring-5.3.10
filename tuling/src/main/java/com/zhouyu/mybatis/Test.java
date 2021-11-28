package com.zhouyu.mybatis;

import com.zhouyu.mybatis.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();

		UserService userService = (UserService) context.getBean("userService");
		userService.test();


	}
}
