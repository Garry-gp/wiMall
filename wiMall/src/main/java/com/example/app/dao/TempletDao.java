package com.example.app.dao;

import com.example.app.model.Templet;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TempletDao {

    //添加查詢方法
    List<Templet> findAll();

    Templet saveAndFlush(Templet templet);

    Templet save(Templet templet);
}
