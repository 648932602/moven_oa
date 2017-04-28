package com.moven.service;

import java.util.List;

import com.moven.model.Administrator;
import com.moven.model.Menu;

public interface AdminService {

	public abstract Administrator login(Administrator admin);
	
	public abstract List<Menu> getMenuByRoleId(Integer roleId);
	
	public abstract Integer isRegistered(String username);
	
	public abstract void register(Administrator admin);
	
}