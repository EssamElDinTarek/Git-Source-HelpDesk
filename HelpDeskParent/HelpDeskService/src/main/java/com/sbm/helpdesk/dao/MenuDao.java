package com.sbm.helpdesk.dao;

import java.util.List;

import com.sbm.helpdesk.entity.Menu;

public interface MenuDao extends GenericDao<Menu> {

	Menu add(Menu item) throws Exception;
	
	List<Menu> getMenuList() throws Exception;
	
	
}
