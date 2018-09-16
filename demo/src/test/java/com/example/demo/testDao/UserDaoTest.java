package com.example.demo.testDao;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Users;
import org.aspectj.bridge.MessageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDaoTest;

    @Test
    public void selectListTest(){
        List<Users> list =  userDaoTest.selectList();
        assertNotNull(list);
    }

}
