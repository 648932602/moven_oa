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
import com.moven.model.Role;

@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController{
	
	// 获取角色列表
	@RequestMapping(value = "/getRoleList", method = RequestMethod.POST)
	@ResponseBody
	public String getRoleList(HttpServletRequest request){
		Administrator loginAdmin = (Administrator)request.getSession().getAttribute("admin");
		if(loginAdmin != null){
			List<Role> roleList = new ArrayList<Role>();
			roleList = roleService.getRoleList();
			String listJSON = JSON.toJSONString(roleList);
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
				// 访问角色管理页
				if("roleManagement".equals(page)){
					return ROLE_MANAGEMENT_PAGE;
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