package com.example.app.cmd.dao;


import com.example.app.cmd.model.Users;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserDao {

    public void add(Users users);

    public void update(Users users);

    public Users selectByUserId(String id);

    public List<Users> selectList();

    public Users findByName(String name);

//    public Page<Users> findAll(Pageable pageable);

}
