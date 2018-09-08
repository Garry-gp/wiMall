package com.example.demo.controller;


import com.example.demo.model.Templet;
import com.example.demo.model.Users;
import com.example.demo.service.TempletService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userInfo")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	TempletService templetService;

//	@InterceptMethod(Method = "aa", Value = "bb")  //拦截器
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

	/**
	 * 用户注册
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public Users getUserRegister(@Param("phone") String phone){
		Templet templet = templetService.queryTemplet();
		userService.getUserRegister(phone,templet);
		return null;
	}
	
	/**
	 * 验证输入的验证码
	 * @return
	 */
	@RequestMapping(value="/identifyinCode",method=RequestMethod.GET)
	public String checkIdentifyingCode(@Param("phone") String phone,@Param("code") String code,@Param("num") int num){
		return userService.checkIdentifyingCode(phone,code,num);
	}
	
	/**
	 * 记录用户的使用次数
	 * @return
	 */
	@RequestMapping(value="/count",method=RequestMethod.GET)
	public String countUser(@Param("phone") String phone){
		userService.countUser(phone);
		return null;
	}
	
	@RequestMapping(value="/query",method=RequestMethod.GET)
	public Map<String, Object> getUserDate(@RequestParam(value = "page")Integer page,@RequestParam(value = "rows")Integer size) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Pageable pageable = new PageRequest(page-1,size);
		Page<Users> pages= userService.getUserPage(page,size);
		List<Users> list = pages.getContent();
		map.put("total",pages.getTotalElements());
		map.put("rows",list);
		return map;
	}
}
