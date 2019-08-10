package com.example.app.service.imp;

import com.example.app.cmd.dao.ActorDao;
import com.example.app.cmd.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl {

    @Autowired
    ActorDao actorDao;

    public Actor findActorById(int actorId){
        Actor actor = actorDao.getActorById(actorId);
        return actor;
    }
}