package com.moven.dao;
/**
 * Mybatis命名空间
 */
public interface DomainDao extends GenericDao {
	static final String USER_NAMESPACE = "dao.namespace.User.";
	static final String ROLE_NAMESPACE = "dao.namespace.Role.";
	static final String ADMINISTRATOR_NAMESPACE = "dao.namespace.Administrator.";
	static final String MENU_NAMESPACE = "dao.namespace.Menu.";
	static final String PRODUCTION_NAMESPACE = "dao.namespace.Production.";
}