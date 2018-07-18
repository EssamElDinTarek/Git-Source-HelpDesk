package com.sbm.helpdesk.service.dao;

import java.util.List;

import com.sbm.helpdesk.common.exceptions.types.RespositoryException;

public interface GenericDao<T>
{

	/**
	 * persist the object.
	 *
	 * @param t
	 *            the t
	 * @return the t
	 */
	T persist(T t) throws RespositoryException;
	
	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 */
	void delete(long id) throws RespositoryException;

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the t
	 */
	T findById(Object id) throws RespositoryException;

	/**
	 * Update.
	 *
	 * @param t
	 *            the t
	 * @return the t
	 */
	T update(T t) throws RespositoryException;
	
	/**
	 * get all.
	 *
	 * 
	 *             
	 * @return the t
	 */
	List<T> findAll() throws RespositoryException;

}

