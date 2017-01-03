package com.xindong.mapper;

import com.xindong.domain.User;

/**
 * Created by jack on 2017/1/3.
 */
public interface UserMapper {
    public User findUserById(int id) throws Exception;
}
