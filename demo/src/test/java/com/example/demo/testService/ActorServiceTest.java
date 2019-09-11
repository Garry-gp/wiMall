package com.example.demo.testService;

import com.example.app.model.Actor;
import com.example.app.service.ActorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActorServiceTest {

    @Autowired
    ActorService actorService;

    @Test
    public void testFindActorById(){
//        int actorId =2;
//        Actor actor = actorService.findActorById(actorId);
//        Assert.assertEquals(actor.getFirstName(),"NICK");
    }
}
