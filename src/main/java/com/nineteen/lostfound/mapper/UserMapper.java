package com.nineteen.lostfound.mapper;

import org.springframework.stereotype.Repository;

import com.nineteen.lostfound.entity.User;

import tk.mybatis.mapper.common.Mapper;

/**
 * Created by mengxu on 2017/9/27.
 */
@Repository
public interface UserMapper extends Mapper<User> {
     User selectUser(User user);
}
