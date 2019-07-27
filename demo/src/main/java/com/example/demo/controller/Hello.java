package com.example.demo.controller;

import com.example.demo.model.Actor;
import com.example.demo.model.Users;
import com.example.demo.service.ActorService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/holloController")
public class Hello {

    @Autowired
    ActorService actorService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/actor/{actorId}")
    public Actor getActorById(@PathVariable("actorId") int actorId){
       return actorService.findActorById(actorId);
    }
}
