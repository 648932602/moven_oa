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
import com.alibaba.fastjson.JSONObject;
import com.moven.model.Administrator;
import com.moven.model.Order;
import com.moven.model.Production;

@Controller
@RequestMapping(value = "/order")
public class OrderController extends BaseController{
	
	// 获取订单列表
	@RequestMapping(value = "/getOrderList", method = RequestMethod.POST)
	@ResponseBody
	public String getOrderList(HttpServletRequest request){
		Administrator loginAdmin = (Administrator)request.getSession().getAttribute("admin");
		if(loginAdmin != null){
			List<Order> orderList = new ArrayList<Order>();
//			orderList = productionService.getProductionList();
			String listJSON = JSON.toJSONString(orderList);
			System.out.println(listJSON);
			return listJSON;
		} else {
			return "{}";
		}
	}
	
	// 获取编辑产品页面
	@RequestMapping(value = "/getEditProductionPage/{id}", method = RequestMethod.GET)
	public String getEditProductionPage(HttpServletRequest request, @PathVariable("id")Integer id){
		Administrator loginAdmin = (Administrator)request.getSession().getAttribute("admin");
		if(loginAdmin != null){
			if(null != id){
				HttpSession session = request.getSession();
				// 当ID为0时，添加产品
				if(0 == id){
					session.setAttribute("production", "{}");
					return EDIT_PRODUCTION_PAGE;
				// 当ID大于0时，修改产品
				} else {
					Production production = productionService.getProductionById(id);
					if(null != production){
						session.setAttribute("production", JSONObject.toJSONString(production));
						return EDIT_PRODUCTION_PAGE;
					} else {
						return FAILED_PAGE;
					}
				}
			} else {
				return SUCCESS_PAGE;
			}
		} else {
			return LOGIN_PAGE;
		}
	}
	
	// 添加或更新产品
	@RequestMapping(value = "/addOrUpdateProduction", method = RequestMethod.POST)
	@ResponseBody
	public String addOrUpdateProduction(HttpServletRequest request, Production production){
		Administrator loginAdmin = (Administrator)request.getSession().getAttribute("admin");
		if(loginAdmin != null){
			if(null != production){
				// 如果产品有ID，则调用修改方法
				if(null != production.getId() && 0 < production.getId()){
					productionService.updateProduction(production);
					return REQUEST_SUCCESS;
				// 如果产品没有ID，则调用添加方法
				} else {
					productionService.addProduction(production);
					if(null != production.getId() && 0 < production.getId()){
						return REQUEST_SUCCESS;
					} else {
						return REQUEST_FAILED;
					}
				}
			} else {
				return REQUEST_FAILED;
			}
		} else {
			return REQUEST_ERROR;
		}
	}
	
	// 删除产品
	@RequestMapping(value = "/deleteProduction", method = RequestMethod.POST)
	@ResponseBody
	public String deleteProduction(HttpServletRequest request, Integer id){
		Administrator loginAdmin = (Administrator)request.getSession().getAttribute("admin");
		if(loginAdmin != null){
			if(null != id){
				productionService.deleteProduction(id);
				return REQUEST_SUCCESS;
			} else {
				return REQUEST_FAILED;
			}
		} else {
			return REQUEST_ERROR;
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
				// 访问产品页
				if("productionManagement".equals(page)){
					return PRODUCTION_MANAGEMENT_PAGE;
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