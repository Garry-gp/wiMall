package com.example.app.controller;


import com.example.app.model.Templet;
import com.example.app.service.templetService.TempletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/templet")
public class TempletController {
	
	@Autowired
	TempletService templetService;

	@RequestMapping(value="/setTemplet" ,method=RequestMethod.POST)
	public boolean setConfig(HttpServletRequest request,HttpServletBean response, Templet templet){
		boolean flag = false;
		return flag;
	}
	
	//查询
	@RequestMapping(value="/queryTemplet",method=RequestMethod.GET)
	public Templet queryTemplet(){
		return templetService.queryTemplet();
	}

}
