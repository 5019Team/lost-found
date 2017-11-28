package com.nineteen.lostfound.dao.harmony.mapper;

import org.springframework.stereotype.Repository;

import com.nineteen.lostfound.dao.harmony.entity.User;

import tk.mybatis.mapper.common.Mapper;

/**
 * Created by mengxu on 2017/9/27.
 */
public interface UserMapper extends Mapper<User> {
     User selectUser(User user);
}
