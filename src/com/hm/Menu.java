package com.hm;

import java.util.Map;

public interface Menu {
	
	public void addMenu(SubMenuType subMenuType,Map<String, Food> subMenu);
	public void deleteMenu(SubMenuType subMenuType);
	public void removeAllMenu();
}
