package com.example.app.controller;


import com.example.app.service.templetService.TempletService;
import com.example.app.service.templetService.imp.TempletServiceIpml;
import com.example.app.service.userService.UserService;
import com.example.app.util.ApplicationContextUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/userInfo")
public class UserController {
	
	@Autowired
    UserService userService;
	@Autowired
	TempletService templetService;

	@RequestMapping(value = "/toLogin",method = RequestMethod.POST)
	public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> map =new HashMap<String,Object>();
		String adminName=request.getParameter("adminName");
		String password=request.getParameter("password");
		if(!adminName.equals("") && !password.equals("")){
			request.getSession().setAttribute("adminName",adminName);
			request.getSession().setAttribute("apssword",password);
			if(adminName.equals("admin") && password.equals("admin001")){
				map.put("result","2");
				return map;
			}
			map.put("result","1");
		}else{
			map.put("result","0");
		}
		return map;
	}
	@RequestMapping(value = "/logOff",method = RequestMethod.GET)
	public boolean logOff(HttpServletRequest request, HttpServletResponse response){
		request.getSession().removeAttribute("adminName");
		request.getSession().removeAttribute("password");
		return true;
	}

	@RequestMapping(value="/query",method=RequestMethod.GET)
	public Map<String, Object> getUserDate(@RequestParam(value = "page")Integer page,@RequestParam(value = "rows")Integer size) throws Exception{

		ApplicationContext contxt = ApplicationContextUtil.getApplicationContext();
		Object bean = contxt.getBean("userService");
		Class classType = contxt.getType("userService");

		Method method = classType.getMethod("findUserById",String.class);
		Object obj = method.invoke(bean,"1");
		return null;
	}
}
