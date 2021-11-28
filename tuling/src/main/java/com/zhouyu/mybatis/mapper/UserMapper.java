package com.zhouyu.mybatis.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author 周瑜
 */
public interface UserMapper {

	@Select("select 'user'")
	String selectById();
}
