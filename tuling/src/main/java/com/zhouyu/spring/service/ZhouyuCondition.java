package com.zhouyu.spring.service;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName ZhouyuCondition
 * @Description
 * @Author wangtao
 * @Date 2021/11/16 21:25
 */
public class ZhouyuCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		try {
			context.getClassLoader().loadClass("com.zhouyu.User");
			return true;
		}catch (Exception e){
			return false;
		}
	}
}
