package com.zhouyu.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName BService
 * @Description
 * @Author wangtao
 * @Date 2021/11/21 19:18
 */
@Component
public class BService {

	@Autowired
	private AService aService;


}
