package com.moven.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moven.configration.DataOperation;
import com.moven.model.Administrator;
import com.moven.model.Menu;
import com.moven.service.AdminService;


@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl implements AdminService {

	@Override
	public Administrator login(Administrator admin) {
		return genericDao.getObject(DataOperation.LOGIN, admin, Administrator.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getMenuByRoleId(Integer roleId) {
		return genericDao.getObject(DataOperation.GET_MENU_BY_ROLE_ID, roleId, List.class);
	}

	@Override
	public Integer isRegistered(String username) {
		return genericDao.getObject(DataOperation.IS_REGISTERED, username, Integer.class);
	}

	@Override
	public void register(Administrator admin) {
		genericDao.saveObject(DataOperation.REGISTER, admin);;
	}
}

