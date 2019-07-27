package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Users;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;



@Service
public interface UserRepository
//		extends JpaRepository<Users, Long>, CrudRepository<Users, Long>,
//JpaSpecificationExecutor<Users>,PagingAndSortingRepository<Users, Long>
{
	//添加查詢方法
	List<Users> findAll();

    Users findByName(String name);
     
}
