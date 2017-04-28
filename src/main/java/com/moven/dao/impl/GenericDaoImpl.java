package com.moven.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.moven.configration.DataOperation;
import com.moven.dao.DomainDao;

/**
 * MyBatis数据库操作映射
 */
public class GenericDaoImpl implements DomainDao {

	protected SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@SuppressWarnings("unchecked")
	public <I, O> O getObject(final DataOperation op, final I input, final Class<O> output) {
		String queryName = null;
		switch (op) {
//			UserServiceImpl
			case GET_USER_BY_ID:
				queryName = USER_NAMESPACE + "getUserById";
				break;
			case GET_USER_LIST:
				queryName = USER_NAMESPACE + "getUserList";
				break;
//			AdminServiceImpl
			case LOGIN:
				queryName = ADMINISTRATOR_NAMESPACE + "login";
				break;
			case GET_MENU_BY_ROLE_ID:
				queryName = MENU_NAMESPACE + "getMenuByRoleId";
				break;
			case IS_REGISTERED:
				queryName = ADMINISTRATOR_NAMESPACE + "isRegistered";
				break;
//			ProductionServiceImpl
			case GET_PRODUCTION_LIST:
				queryName = PRODUCTION_NAMESPACE + "getProductionList";
				break;
			case GET_PRODUCTION_BY_ID:
				queryName = PRODUCTION_NAMESPACE + "getProductionById";
				break;
//			RoleServiceImpl
			case GET_ROLE_LIST:
				queryName = ROLE_NAMESPACE + "getRoleList";
				break;
			default:
				break;
		}
		if (output == List.class) {
			return (O) sqlSession.selectList(queryName, input);
		} else {
			return (O) sqlSession.selectOne(queryName, input);
		}
	}

	public <I> void saveObject(DataOperation op, I input) {
		switch (op) {
//			UserServiceImpl
			case ADD_USER:
				sqlSession.insert(USER_NAMESPACE + "addUser", input);
				break;
//			AdminControllerImpl
			case REGISTER:
				sqlSession.insert(ADMINISTRATOR_NAMESPACE + "register", input);
				break;
//			ProductionServiceImpl
			case ADD_PRODUCTION:
				sqlSession.insert(PRODUCTION_NAMESPACE + "addProduction", input);
				break;
			default:
				break;
		}
	}

	public <I> void updateObject(DataOperation op, I input) {
		switch (op) {
//		ProductionServiceImpl
			case UPDATE_PRODUCTION:
				sqlSession.update(PRODUCTION_NAMESPACE + "updateProduction", input);
				break;
			case DELETE_PRODUCTION:
				sqlSession.update(PRODUCTION_NAMESPACE + "deleteProduction", input);
				break;
			default:
				break;
		}
	}

	public <I> void deleteObject(DataOperation op, I input) {
		switch (op) {
//			case DELETE_EXPIRED_USER_SESSION:
//				sqlSession.delete(ADMIN_USER_SESSION_NAMESPACE + "deleteExpiredUserSession", input);
//				break;
			default:
				break;
		}
	}
	
}
