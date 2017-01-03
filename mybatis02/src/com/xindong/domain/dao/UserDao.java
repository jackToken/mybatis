package com.xindong.domain.dao;

import com.xindong.domain.User;

/**
 * Created by jack on 2017/1/2.
 */
public interface UserDao {
    public User findUserById(int id) throws Exception;
}
