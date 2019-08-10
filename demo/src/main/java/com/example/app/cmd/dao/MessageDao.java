package com.example.app.cmd.dao;

import com.example.app.cmd.model.Message;

public interface MessageDao {

    public void add(Message msg);
    public void update(Message msg);
    public Message select();
}
