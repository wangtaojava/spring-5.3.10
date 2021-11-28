package com.zhouyu.spring;


import com.zhouyu.spring.service.UserService;
import com.zhouyu.spring.service.ZhouyuAroundAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.*;

import java.lang.reflect.Method;


@ComponentScan("com.zhouyu.spring")
//@PropertySource("spring.properties")
@EnableAspectJAutoProxy//支持aop
public class AppConfig {

//	@Bean
//	public ProxyFactoryBean userService(){
//		UserService userService = new UserService();
//		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//		proxyFactoryBean.setTarget(userService);
//		MethodBeforeAdvice methodBeforeAdvice = new MethodBeforeAdvice() {
//			@Override
//			public void before(Method method, Object[] args, Object target) throws Throwable {
//				System.out.println("方法执行之前");
//			}
//		};
//		proxyFactoryBean.addAdvice(methodBeforeAdvice);
//		return proxyFactoryBean;
//	}

//	@Bean
//	public BeanNameAutoProxyCreator beanNameAutoProxyCreator(){
//		BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
//		beanNameAutoProxyCreator.setBeanNames("userSer*");//被代理对象名
//		beanNameAutoProxyCreator.setInterceptorNames("zhouyuAroundAdvice");//代理逻辑
//		return beanNameAutoProxyCreator;
//	}

//	@Bean
//	public DefaultPointcutAdvisor defaultPointcutAdvisor(){
//		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
//		pointcut.addMethodName("test");//所有的bean只要有test方法就会被代理
//
//		DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
//		defaultPointcutAdvisor.setPointcut(pointcut);
//		defaultPointcutAdvisor.setAdvice(new ZhouyuAroundAdvice());//代理逻辑
//		return defaultPointcutAdvisor;
//	}
//
//	//非常重要，这个bean会去找所有Advisor类型的bean以及Advisor中的pointCut，来确定需要代理的bean以及代理逻辑
//	@Bean
//	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
//		return new DefaultAdvisorAutoProxyCreator();
//	}

//	@Bean
//	public JdbcTemplate jdbcTemplate() {
//		return new JdbcTemplate(dataSource());
//	}
//
//
//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//		transactionManager.setDataSource(dataSource());
//		return transactionManager;
//	}
//
//
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/tuling?characterEncoding=utf-8&useSSL=false");
//		dataSource.setUsername("root");
//		dataSource.setPassword("Zhouyu123456***");
//		return dataSource;
//	}


//	@Bean
//	public SqlSessionFactory sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//		sessionFactoryBean.setDataSource(dataSource());
//		return sessionFactoryBean.getObject();
//	}


}
