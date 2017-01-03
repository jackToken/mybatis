package com.xindong.test;

import com.xindong.domain.User;
import com.xindong.domain.dao.UserDao;
import com.xindong.domain.dao.impl.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jack on 2017/1/2.
 */
public class UserTest01 {

    @Test
    public void findUserById() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", 1);
        System.out.print(user);
        sqlSession.close();
    }

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void setUp() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void daoFindUserById() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(1);
        System.out.println(user);
    }
}
