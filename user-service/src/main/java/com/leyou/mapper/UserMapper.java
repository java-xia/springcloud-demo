package com.leyou.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.leyou.pojo.User;

@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {
}
