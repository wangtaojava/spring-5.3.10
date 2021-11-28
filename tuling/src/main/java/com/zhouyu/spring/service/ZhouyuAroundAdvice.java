package com.zhouyu.spring.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

/**
 * @ClassName ZhouyuAroundAdvice
 * @Description
 * @Author wangtao
 * @Date 2021/11/28 11:53
 */
@Component
public class ZhouyuAroundAdvice implements MethodInterceptor {
	@Nullable
	@Override
	public Object invoke(@NotNull MethodInvocation invocation) throws Throwable {
		System.out.println("around前。。。");
		Object proceed = invocation.proceed();
		System.out.println("around后。。。");
		return proceed;
	}
}
