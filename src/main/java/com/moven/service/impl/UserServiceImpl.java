package com.moven.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moven.configration.DataOperation;
import com.moven.model.User;
import com.moven.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {
	
	@Override
	public void add(User user){
		genericDao.saveObject(DataOperation.ADD_USER, user);
		System.out.println("User add:" + user.getName());
	}

	@Override
	public void update(User user){
		System.out.println("User update:" + user.getName());
	}
	
	@Override
	public void getUserById(Integer id) {
		User user = genericDao.getObject(DataOperation.GET_USER_BY_ID, id, User.class);
		System.out.println("User add:" + user.getName());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList() {
		return genericDao.getObject(DataOperation.GET_USER_LIST, null, List.class);
	}
	
	
}

