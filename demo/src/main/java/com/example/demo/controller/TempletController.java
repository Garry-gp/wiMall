package com.example.demo.controller;


import com.example.demo.model.Templet;
import com.example.demo.service.TempletService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "模板管理")
@RestController
@RequestMapping("/templet")
public class TempletController {
	
	@Autowired
	TempletService templetService;

//	@ApiOperation(value = "查询")
//	@RequestMapping(value="/query",method=RequestMethod.GET)
//	public Map<String, Object> getUserDate(@RequestParam(value = "page")Integer page,@RequestParam(value = "rows")Integer size) throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>();
//		Page<Templet> pages= templetService.findTemletPage(page, size);
//		List<Templet> list = pages.getContent();
//		map.put("total",pages.getTotalElements());
//		map.put("rows",list);
//		return map;
//	}
//
	//添加短信模板
	@ApiOperation(value = "设置模板")
	@RequestMapping(value="/setTemplet" ,method=RequestMethod.POST)
	public boolean setConfig(HttpServletRequest request,HttpServletBean response, Templet templet){		
		boolean flag = false;
//		Templet tpl= templetService.saveTemplet(templet);
//		if(tpl!=null){
//			flag = true;
//		}
		return flag;
	}
	
	//查询
	@ApiOperation(value = "查询模板")
	@RequestMapping(value="/queryTemplet",method=RequestMethod.GET)
	public Templet queryTemplet(){
		return templetService.queryTemplet();
	}

}
