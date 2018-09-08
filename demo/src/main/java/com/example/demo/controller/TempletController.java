package com.example.demo.controller;


import com.example.demo.model.Templet;
import com.example.demo.service.TempletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/templet")
public class TempletController {
	
	@Autowired
	TempletService templetService;
	
	@RequestMapping(value="/query",method=RequestMethod.GET)
	public Map<String, Object> getUserDate(@RequestParam(value = "page")Integer page,@RequestParam(value = "rows")Integer size) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Templet> pages= templetService.findTemletPage(page, size);
		List<Templet> list = pages.getContent();
		map.put("total",pages.getTotalElements());
		map.put("rows",list);
		return map;
	}
	
	//启用设置
	public boolean settingStatus(){
		return true;
	}
	
	//添加短信模板
	@RequestMapping(value="/setTemplet")
	public boolean setConfig(HttpServletRequest request,HttpServletBean response, Templet templet){		
		boolean flag = false;
		Templet tpl= templetService.saveTemplet(templet);
		if(tpl!=null){
			flag = true;
		}
		return flag;
	}
	
	//查询
	@RequestMapping(value="/queryTemplet")
	public Templet queryTemplet(){
		return templetService.queryTemplet();
	}

}
