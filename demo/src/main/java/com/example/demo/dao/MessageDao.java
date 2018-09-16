package com.example.demo.dao;

import com.example.demo.model.Message;

public interface MessageDao {

    public void add(Message msg);
    public void update(Message msg);
    public Message select();
}
