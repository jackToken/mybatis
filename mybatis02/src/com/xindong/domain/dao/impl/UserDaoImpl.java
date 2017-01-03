package com.xindong.domain.dao.impl;

import com.xindong.domain.User;
import com.xindong.domain.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by jack on 2017/1/2.
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory = null;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = null;
        User user = null;
        try {
            sqlSession = sqlSessionFactory
                    .openSession();
            user = sqlSession.selectOne("test.findUserById", id);
        } catch (Exception e) {
            throw e;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return user;
    }
}
