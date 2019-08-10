package com.example.app.cmd.repository;

import java.util.List;

import com.example.app.cmd.model.Templet;
import org.springframework.stereotype.Service;


@Service
public interface TempletRepository {
	//添加查詢方法
	List<Templet> findAll();
    
}
