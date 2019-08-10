package com.example.app.cmd.repository;

import java.util.List;

import com.example.app.cmd.model.Users;
import org.springframework.stereotype.Service;



@Service
public interface UserRepository {
	//添加查詢方法
	List<Users> findAll();

    Users findByName(String name);
     
}
