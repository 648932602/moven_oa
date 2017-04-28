package com.moven.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.moven.configration.JSONConfig;
import com.moven.configration.PageConfig;
import com.moven.service.AdminService;
import com.moven.service.ProductionService;
import com.moven.service.RoleService;
import com.moven.service.UserService;

public class BaseController implements PageConfig, JSONConfig {
	@Autowired
	protected UserService userService;
	@Autowired
	protected AdminService adminService;
	@Autowired
	protected ProductionService productionService;
	@Autowired
	protected RoleService roleService;
}
