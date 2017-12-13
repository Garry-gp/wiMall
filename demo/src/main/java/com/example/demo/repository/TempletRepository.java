package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Templet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public interface TempletRepository extends JpaRepository<Templet, Long>, CrudRepository<Templet, Long>,
JpaSpecificationExecutor<Templet>{
	//添加查詢方法
	List<Templet> findAll();
    
}
