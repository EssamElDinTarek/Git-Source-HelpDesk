package com.sbm.helpdesk.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.helpdesk.dao.GenericDao;

@Transactional
public class GenericDaoImpl<T> implements GenericDao<T>
{

	/** The entityManager. */
	@PersistenceContext
	protected EntityManager entityManager;

	/** The type. */
	private Class<T> type;

	/**
	 * Instantiates a new generic dao impl.
	 */
	public GenericDaoImpl()
	{
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbm.muras.daos.GenericDao#create(java.lang.Object)
	 */
	@Override
	public T persist(final T t)
	{
		this.entityManager.persist(t);
		//this.entityManager.refresh(t);
		return t;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbm.muras.daos.GenericDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(long id)
	{
		T objBean = this.entityManager.find(type, id);
		if(objBean != null)
			this.entityManager.remove(objBean);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbm.muras.daos.GenericDao#find(java.lang.Object)
	 */
	@Override
	public T findById(final Object id)
	{
		return (T) this.entityManager.find(type, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbm.muras.daos.GenericDao#update(java.lang.Object)
	 */
	@Override
	public T update(final T t)
	{
		return this.entityManager.merge(t);
	}

	

}
