package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Templet;
import com.example.demo.model.Users;
import com.example.demo.repository.TempletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class TempletService {
	
	@Autowired
	TempletRepository templetRepository;
	
	public Templet saveTemplet(Templet templet){
		//ID为空插入一条数据
		String templetId = templet.getId();
		if(templetId!=null && !templetId.equals("")){
			return templetRepository.saveAndFlush(templet);
		}
		templet.setId(UUID.randomUUID().toString());
		return templetRepository.save(templet);
	}
	
	public Templet queryTemplet(){
		List<Templet> templetList = templetRepository.findAll();
		if(templetList.size()>0){
			return templetList.get(0);
		}
		return null;
	}
	
	public Page<Templet> findTemletPage(int page, int rows) {		
		Sort sort = new Sort(Sort.Direction.DESC,"createTime"); //创建时间降序排序
		Pageable pageable = new PageRequest(page-1, rows);  
		Page<Templet> pages = templetRepository.findAll(pageable);
		return pages;
	}
}
