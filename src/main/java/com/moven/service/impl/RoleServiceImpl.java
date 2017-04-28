package com.moven.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moven.configration.DataOperation;
import com.moven.model.Role;
import com.moven.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoleList() {
		return genericDao.getObject(DataOperation.GET_ROLE_LIST, null, List.class);
	}
	
	
}

