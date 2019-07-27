package com.example.demo.controller;


import ch.qos.logback.core.util.ContextUtil;
import com.example.demo.intercept.OperationAction;
import com.example.demo.model.Templet;
import com.example.demo.model.Users;
import com.example.demo.service.TempletService;
import com.example.demo.service.UserService;
import com.example.demo.util.ApplicationContextUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/userInfo")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	TempletService templetService;

//	@OperationAction(name ="role", value="operation")
	@ApiOperation(value = "登录")
	@ApiImplicitParam(name = "userName",value = "用户名称",required = true)
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
	@ApiOperation(value = "退出")
	@RequestMapping(value = "/logOff",method = RequestMethod.GET)
	public boolean logOff(HttpServletRequest request, HttpServletResponse response){
		request.getSession().removeAttribute("adminName");
		request.getSession().removeAttribute("password");
		return true;
	}

	@ApiOperation(value = "查询")
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
