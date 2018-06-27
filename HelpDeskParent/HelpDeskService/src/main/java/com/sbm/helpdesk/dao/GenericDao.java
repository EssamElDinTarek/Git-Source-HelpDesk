package com.sbm.helpdesk.dao;

import java.util.List;

public interface GenericDao<T>
{

	/**
	 * persist the object.
	 *
	 * @param t
	 *            the t
	 * @return the t
	 */
	T persist(T t);
	
	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 */
	void delete(long id);

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the t
	 */
	T findById(Object id);

	/**
	 * Update.
	 *
	 * @param t
	 *            the t
	 * @return the t
	 */
	T update(T t);
	
	/**
	 * get all.
	 *
	 * 
	 *             
	 * @return the t
	 */
	List<T> findAll();

}

