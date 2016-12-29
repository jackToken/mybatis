package com.xindong.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xindong.mybatis.domain.User;

public class DemoTest {
	@Test
	public void findUserById() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		sqlSession.close();
	}

    @Test
    public void deleteUserById() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUserById", 26);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertUser() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("jack");
        user.setAddress("beijing");
        sqlSession.insert("test.insertUser", user);
        System.out.println(user.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(28);
        user.setUsername("jsjackwang");
        user.setAddress("shanghai");
        sqlSession.update("test.updateUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertUuid() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        //user.setAddress("beijing");
        user.setUsername("uuid");
        sqlSession.insert("test.insertUuid", user);
        sqlSession.commit();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void findUser() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list = sqlSession.selectList("test.findUser", "张");
        System.out.println(list);
        sqlSession.close();
    }
}
