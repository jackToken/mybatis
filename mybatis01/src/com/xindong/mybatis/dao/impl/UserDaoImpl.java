package com.xindong.mybatis.dao.impl;

import com.xindong.mybatis.dao.UserDao;
import com.xindong.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by jack on 2016/12/29.
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", id);
        if (sqlSession != null) {
            sqlSession.close();
        }
        return user;
    }
}
