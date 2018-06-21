package com.sbm.helpdesk.dao.impl;

import java.util.List;

import com.sbm.helpdesk.dao.MenuDao;
import com.sbm.helpdesk.entity.Menu;

public class MenuDaoImpl extends GenericDaoImpl<Menu> implements MenuDao {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getMenuList() throws Exception {
		// TODO Auto-generated method stub
		return (List<Menu>)entityManager.createNamedQuery("Menu.findAll").getResultList();
	}
	
	@Override
	public Menu add(Menu item) throws Exception {
		// TODO Auto-generated method stub
		return persist(item);
	}
	

}
