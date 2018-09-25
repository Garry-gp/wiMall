package com.example.demo.testDao;

import com.example.demo.dao.ActorDao;
import com.example.demo.model.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActorDaoTest {

    @Autowired
    ActorDao actorDao;

    @Test
    public void getActorById(){
        int actorId = 3;
        Actor actor = actorDao.getActorById(actorId);
        System.out.println(actor.getFirstName());
    }
}
