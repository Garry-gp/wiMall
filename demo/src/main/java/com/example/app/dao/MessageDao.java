package com.example.app.dao;

import com.example.app.model.Message;

public interface MessageDao {

    public void add(Message msg);
    public void update(Message msg);
    public Message select();
}
