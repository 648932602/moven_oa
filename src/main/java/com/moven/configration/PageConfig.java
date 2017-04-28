package com.moven.configration;
/**
 * 跳转页面
 */
public interface PageConfig {
	//	功能模块
	public static final String ADMIN_FOLDER = "admin/";
	public static final String PRODUCTION_FOLDER = "production/";
	public static final String USER_FOLDER = "user/";
	public static final String COMMON_FOLDER = "common/";
	// Admin
	public static final String LOGIN_PAGE = ADMIN_FOLDER + "login";
	public static final String REGISTER_PAGE = ADMIN_FOLDER + "register";
	public static final String HOME_PAGE = ADMIN_FOLDER + "home";
	public static final String HOME_MENU_PAGE = ADMIN_FOLDER + "home_menu";
	public static final String HOME_DASHBOARD_PAGE = ADMIN_FOLDER + "home_dashboard";
	// Production
	public static final String EDIT_PRODUCTION_PAGE = PRODUCTION_FOLDER + "editProduction";
	public static final String PRODUCTION_MANAGEMENT_PAGE = PRODUCTION_FOLDER + "productionManagement";
	// User
	public static final String USER_MANAGEMENT_PAGE = USER_FOLDER + "userManagement";
	public static final String ROLE_MANAGEMENT_PAGE = USER_FOLDER + "roleManagement";
	// Common
	public static final String SUCCESS_PAGE = COMMON_FOLDER + "success";
	public static final String FAILED_PAGE = COMMON_FOLDER + "failed";
	
	
}
