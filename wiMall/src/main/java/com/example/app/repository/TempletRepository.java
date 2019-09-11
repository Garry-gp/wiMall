package com.example.app.repository;

import java.util.List;

import com.example.app.model.Templet;
import org.springframework.stereotype.Service;


@Service
public interface TempletRepository {
	//添加查詢方法
	List<Templet> findAll();
    
}
