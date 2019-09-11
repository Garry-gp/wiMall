package com.example.app.service.templetService.imp;

import com.example.app.dao.TempletDao;
import com.example.app.model.Templet;
import com.example.app.service.templetService.TempletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




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
