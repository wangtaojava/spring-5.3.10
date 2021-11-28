package com.zhouyu.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ZhouyuAspect {


//	@DeclareParents(value = "com.zhouyu.service.UserService", defaultImpl = UserImplement.class)
//	private UserInterface userInterface;

	@Before("execution(public void com.zhouyu.spring.service.UserService.test())")// pointCut
	public void zhouyuBefore(JoinPoint joinPoint) {//代理逻辑
		System.out.println("zhouyuBefore");
	}

//	@Before(value = "execution(public void com.zhouyu.service.UserService.test(..)) && args(a, b)", argNames = "a,b")
//	public void zhouyuBefore(String a, String b) {
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println("zhouyuBefore");
//	}


}
