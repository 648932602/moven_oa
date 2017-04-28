package com.moven.dao;

import com.moven.configration.DataOperation;

/**
 * 数据库基本操作接口
 */
public interface GenericDao {
	
	/**
	 * 向数据库添加信息
	 * @param base 基本属性类
	 */
	<I> void saveObject(final DataOperation op, final I input);

	/**
	 * 通过ID，删除数据库中的信息
	 * @param base 基本属性类
	 */
	<I> void deleteObject(final DataOperation op, final I input);

	/**
	 * 通过ID，对数据库中的的信息进行修改
	 * @param base 基本属性类
	 */
	<I> void updateObject(final DataOperation op, final I input);

	/**
	 * 通过ID，查找数据库中的相关信息
	 * @param base 基本属性类
	 * @return 查找到的相关信息
	 */
	<I, O> O getObject(final DataOperation op, final I input, final Class<O> output);
}