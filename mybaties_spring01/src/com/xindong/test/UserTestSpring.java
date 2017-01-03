package com.xindong.test;

import com.xindong.domain.User;
import com.xindong.mapper.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by jack on 2017/1/3.
 */
public class UserTestSpring {
    private ApplicationContext applicationContext;

    @Before
    public void setup() throws IOException {
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }
}
