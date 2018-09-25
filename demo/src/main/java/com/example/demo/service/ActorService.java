package com.example.demo.service;

import com.example.demo.dao.ActorDao;
import com.example.demo.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

    @Autowired
    ActorDao actorDao;

    public Actor findActorById(int actorId){
        Actor actor = actorDao.getActorById(actorId);
        return actor;
    }
}
