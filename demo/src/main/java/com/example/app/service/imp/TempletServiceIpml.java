package com.example.app.service.imp;

import java.util.List;

import com.example.app.cmd.model.Templet;
import com.example.app.cmd.dao.TempletDao;
import com.example.app.service.TempletService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class TempletServiceIpml implements TempletService {
	
	@Autowired
	TempletDao templetDao;
	
	public Templet queryTemplet(){
		List<Templet> templetList = templetDao.findAll();
		if(templetList.size()>0){
			return templetList.get(0);
		}
		return null;
	}

}
