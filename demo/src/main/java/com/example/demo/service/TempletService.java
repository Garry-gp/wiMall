package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Templet;
import com.example.demo.repository.TempletRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
