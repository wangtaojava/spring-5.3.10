package com.zhouyu.spring.service;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @ClassName ZhouyuPointcutAdvisor
 * @Description
 * @Author wangtao
 * @Date 2021/11/29 20:53
 */
public class ZhouyuPointcutAdvisor implements PointcutAdvisor {
	@Override
	public Pointcut getPointcut() {//切入点
		return new StaticMethodMatcherPointcut() {
			@Override
			public boolean matches(Method method, Class<?> targetClass) {
				return method.getName().equals("test");//只有test方法可以走代理逻辑
			}
		};
	}

	@Override
	public Advice getAdvice() {//代理逻辑
		MethodInterceptor methodInterceptor = new MethodInterceptor() {
			@Nullable
			@Override
			public Object invoke(@NotNull MethodInvocation invocation) throws Throwable {
				System.out.println("around前");
				Object result = invocation.proceed();
				System.out.println("around后");
				return result;
			}
		};
		return methodInterceptor;
	}

	@Override
	public boolean isPerInstance() {
		return false;
	}
}
