package com.example.app.controller;


import com.example.app.model.Templet;
import com.example.app.service.imp.TempletServiceIpml;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "模板管理")
@RestController
@RequestMapping("/templet")
public class TempletController {
	
	@Autowired
	TempletServiceIpml templetServiceIpml;

	//添加短信模板
	@ApiOperation(value = "设置模板")
	@RequestMapping(value="/setTemplet" ,method=RequestMethod.POST)
	public boolean setConfig(HttpServletRequest request,HttpServletBean response, Templet templet){
		boolean flag = false;
		return flag;
	}
	
	//查询
	@ApiOperation(value = "查询模板")
	@RequestMapping(value="/queryTemplet",method=RequestMethod.GET)
	public Templet queryTemplet(){
		return templetServiceIpml.queryTemplet();
	}

}
