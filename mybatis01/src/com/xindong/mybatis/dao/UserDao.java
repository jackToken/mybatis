package com.xindong.mybatis.dao;

import com.xindong.mybatis.domain.User;

/**
 * Created by jack on 2016/12/29.
 */
public interface UserDao {
    public User findUserById(int id) throws Exception;
}
