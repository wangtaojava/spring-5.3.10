package com.zhouyu.mybatis.service;

import com.zhouyu.mybatis.mapper.MemberMapper;
import com.zhouyu.mybatis.mapper.OrderMapper;
import com.zhouyu.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 周瑜
 */
@Component
public class UserService {

	@Autowired
	private UserMapper userMapper; // Mybatis UserMapper代理对象-->Bean

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private MemberMapper memberMapper;

	public void test() {
		System.out.println(userMapper.selectById());
		System.out.println(orderMapper.selectById());
		System.out.println(memberMapper.selectById());
	}

}
