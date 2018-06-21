package com.sbm.shura.dao;

import java.util.List;

import com.sbm.shura.entity.Menu;

public interface MenuDao extends GenericDao<Menu> {

	Menu add(Menu item) throws Exception;
	
	List<Menu> getMenuList() throws Exception;
	
	
}
