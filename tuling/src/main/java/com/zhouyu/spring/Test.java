package com.zhouyu.spring;

import com.zhouyu.spring.service.User;
import com.zhouyu.spring.service.UserInterface;
import com.zhouyu.spring.service.UserService;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInvocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.aop.*;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.cglib.proxy.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		//cglib动态代理
//		cglibProxy();

		//JDK动态代理
//		jdkProxy();

//		proxyFactory();

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.test();

//
//		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//		ConstructorArgumentValues constructorArgumentValues = beanDefinition.getConstructorArgumentValues();
//		constructorArgumentValues.addIndexedArgumentValue(0, new UserService());
//		beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR);

//		applicationContext.close();

	}

	public static void cglibProxy(){
		UserService target = new UserService();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserService.class);//设置父类
		//设置回调
		enhancer.setCallbacks(new Callback[]{new MethodInterceptor() {
			@Override
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//				System.out.println("代理对象:" + o);
				System.out.println("before...");
				//被代理的对象
//				Object result = methodProxy.invoke(target, objects);
				Object result = method.invoke(target, objects);
//				Object result = methodProxy.invokeSuper(o, objects);//执行父类的方法，即被代理的方法
				System.out.println("after...");
				return result;
			}
		}, //第一个拦截器
				NoOp.INSTANCE//第二个拦截器
		});

		enhancer.setCallbackFilter(new CallbackFilter() {
			@Override
			public int accept(Method method) {
				if(method.getName().equals("test")){//执行test方法时才会走第一个拦截器
					return 0;
				}
				return 1;
			}
		});

		UserService userService = (UserService) enhancer.create();

		System.out.println("代理对象：" + userService);
		userService.test();

		userService.a();//通过设置setCallbackFilter，可以自定义设置哪些方法需要走拦截器
	}

//	public static void jdkProxy(){
//		UserInterface target = new UserService();
//
//
//		UserInterface userInterface = (UserInterface) Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{UserInterface.class}, new InvocationHandler() {
//			@Override
//			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//				System.out.println("jdk before...");
//				Object result = method.invoke(target, args);
//				System.out.println("jdk after...");
//				return result;
//			}
//		});
//
//		userInterface.test();
//	}

	public static void proxyFactory(){
		UserService target = new UserService();

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);

		MethodBeforeAdvice methodBeforeAdvice = new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println("方法执行之前");
			}
		};

		AfterReturningAdvice afterReturningAdvice = new AfterReturningAdvice() {
			@Override
			public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
				System.out.println("方法return之后执行");
			}
		};

		ThrowsAdvice throwsAdvice = new ThrowsAdvice() {
			public void afterThrowing(Method method, Object[] args, Object target, RuntimeException e) {
				System.out.println("抛出异常之后执行");
			}
		};

		org.aopalliance.intercept.MethodInterceptor methodInterceptor = new org.aopalliance.intercept.MethodInterceptor() {
			@Nullable
			@Override
			public Object invoke(@NotNull MethodInvocation invocation) throws Throwable {
				System.out.println("around前");
				Object result = invocation.proceed();
				System.out.println("around后");
				return result;
			}
		};

//		proxyFactory.addAdvice(methodInterceptor);
//		proxyFactory.addAdvice(methodBeforeAdvice);//可以指定多个

		proxyFactory.addAdvisor(new PointcutAdvisor() {
			@Override
			public Pointcut getPointcut() {
				return new StaticMethodMatcherPointcut() {
					@Override
					public boolean matches(Method method, Class<?> targetClass) {
						return method.getName().equals("test");//只有test方法可以走代理逻辑
					}
				};
			}

			@Override
			public Advice getAdvice() {//指定代理逻辑
				return methodInterceptor;
			}

			@Override
			public boolean isPerInstance() {
				return false;
			}
		});

		UserService proxy = (UserService) proxyFactory.getProxy();
		proxy.test();
		proxy.a();
	}
}
