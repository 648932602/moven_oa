package com.moven.service.impl;

import javax.annotation.Resource;

import com.moven.dao.GenericDao;

public class BaseServiceImpl {
	@Resource(name = "genericDao")
	public GenericDao genericDao;
}
