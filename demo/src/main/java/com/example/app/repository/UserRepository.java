package com.example.app.repository;

import java.util.List;

import com.example.app.model.Users;
import org.springframework.stereotype.Service;



@Service
public interface UserRepository {
	//添加查詢方法
	List<Users> findAll();

    Users findByName(String name);
     
}
