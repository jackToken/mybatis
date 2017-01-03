package com.xindong.mybatis.test;

import com.xindong.mybatis.dao.UserDao;
import com.xindong.mybatis.dao.impl.UserDaoImpl;
import com.xindong.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jack on 2016/12/29.
 */
public class UserTest {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void test() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = null;
        try {
            user = userDao.findUserById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}
