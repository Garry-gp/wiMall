package com.example.app.controller;

import com.example.app.service.imp.ActorServiceImpl;
import com.example.app.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/holloController")
public class Hello {

    @Autowired
    ActorServiceImpl actorServiceImpl;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/actor/{actorId}")
    public Actor getActorById(@PathVariable("actorId") int actorId){
       return actorServiceImpl.findActorById(actorId);
    }
}
