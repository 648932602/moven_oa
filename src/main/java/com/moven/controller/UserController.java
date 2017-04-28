package com.moven.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.moven.model.Administrator;
import com.moven.model.User;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController{
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(User user){
		System.out.println("userid:"+user.getId());
		System.out.println("username:"+user.getName());
		userService.add(user);
		return SUCCESS_PAGE;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(User user) {
		userService.update(user);
		return SUCCESS_PAGE;
	}
	@RequestMapping(value = "/getUserById", method = RequestMethod.POST)
	public String getUserById(Integer id) {
		userService.getUserById(id);
		return SUCCESS_PAGE;
	}
	
	// 获取用户列表
	@RequestMapping(value = "/getUserList", method = RequestMethod.POST)
	@ResponseBody
	public String getUserList(HttpServletRequest request){
		Administrator loginAdmin = (Administrator)request.getSession().getAttribute("admin");
		if(loginAdmin != null){
			List<User> userList = new ArrayList<User>();
			userList = userService.getUserList();
			String listJSON = JSON.toJSONString(userList);
			System.out.println(listJSON);
			return listJSON;
		} else {
			return "{}";
		}
	}
	
	// 访问页面
	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public String goPage(HttpServletRequest request, @PathVariable("page")String page){
		// 获取登录用户
		HttpSession session = request.getSession();
		Administrator admin = (Administrator)session.getAttribute("admin");
		// 访问页面参数
		if(null != page && !"".equals(page)){
			// 判断是否用户已登录
			// 若登录
			if(admin != null){
				// 访问用户管理页
				if("userManagement".equals(page)){
					return USER_MANAGEMENT_PAGE;
				} else {
					return HOME_PAGE;
				}
			// 若未登录
			} else {
				// 访问登录页
				return LOGIN_PAGE;
			}
		// 若无访问参数
		} else {
			if(admin != null){
				// 访问默认页（即用户登录，且页面未知）
				return HOME_PAGE;
			} else {
				// 访问登录页
				return LOGIN_PAGE;
			}
		}
	}
	
}