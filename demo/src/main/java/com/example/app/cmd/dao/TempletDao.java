package com.example.app.cmd.dao;

import com.example.app.cmd.model.Templet;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TempletDao {

    //添加查詢方法
    List<Templet> findAll();

//    Page<Templet> findAll(Pageable pageable);

    Templet saveAndFlush(Templet templet);

    Templet save(Templet templet);
}
