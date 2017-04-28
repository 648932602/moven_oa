package com.moven.service;

import java.util.List;

import com.moven.model.User;

public interface UserService {

	public abstract void add(User user);

	public abstract void getUserById(Integer id);

	public abstract void update(User user);

	public abstract List<User> getUserList();
}