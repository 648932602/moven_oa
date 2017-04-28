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
import com.moven.model.Menu;
import com.moven.model.Tree;
import com.moven.utils.TreeUtils;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController{
	
	// 用户登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request, Administrator admin){
		Administrator loginAdmin = adminService.login(admin);
		if(loginAdmin != null){
			// 清空用户密码
			loginAdmin.setPassword("");
			HttpSession session = request.getSession();
			session.setAttribute("admin", loginAdmin);
			return REQUEST_SUCCESS;
		} else {
			return REQUEST_FAILED;
		}
	}
	
	// 用户注册
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String register(HttpServletRequest request, Administrator admin){
		Integer adminCount = adminService.isRegistered(admin.getUsername());
		if(adminCount == 0){
			adminService.register(admin);
			if(null != admin.getId() && admin.getId() > 0){
				return REQUEST_SUCCESS;
			} else {
				return REQUEST_FAILED;
			}
		} else {
			return REQUEST_ERROR;
		}
	}
	
	// 获取菜单
	@RequestMapping(value = "/getMenuByRoleId", method = RequestMethod.GET)
	@ResponseBody
	public String getMenuByRoleId(HttpServletRequest request){
		Administrator loginAdmin = (Administrator)request.getSession().getAttribute("admin");
		if(loginAdmin != null){
			List<Menu> menuList = new ArrayList<Menu>();
			Integer roleId = loginAdmin.getRoleId();
			menuList = adminService.getMenuByRoleId(roleId);
			List<Tree> treeList = new ArrayList<Tree>();
			treeList = TreeUtils.getTree(menuList);
			String listJSON = JSON.toJSONString(treeList);
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
				// 访问主页（即用户登录，访问登录页）
				if("login".equals(page)){
					return HOME_PAGE;
				// 用户登出
				} else if("logout".equals(page)){
					session.removeAttribute("admin");
					return LOGIN_PAGE;
				// 访问菜单页
				} else if("home_menu".equals(page)){
					return HOME_MENU_PAGE;
				// 访问展板页
				} else if("home_dashboard".equals(page)){
					return HOME_DASHBOARD_PAGE;
				// 访问默认页（即用户登录，且页面未知）
				} else {
					return HOME_PAGE;
				}
			// 若未登录
			} else {
				// 访问注册页
				if("register".equals(page)){
					return REGISTER_PAGE;
				// 访问登录页
				} else {
					return LOGIN_PAGE;
				}
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