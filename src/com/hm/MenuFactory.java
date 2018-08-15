package com.hm;

import java.util.HashMap;
import java.util.Map;

public class MenuFactory implements Menu{
	
	static MenuFactory menuFactory = null;
	
	public static MenuFactory getMenuFactory(){
		if(menuFactory == null){
			synchronized (MenuFactory.class) {
				if(menuFactory == null){
					menuFactory = new MenuFactory();
				}
			}
		}
		return menuFactory;
	}
	
	static Map<SubMenuType, Map<String, Food>> mainMenu  = new HashMap<>();
	
	@Override
	public void addMenu(SubMenuType subMenuType,Map<String, Food> subMenu) {
		mainMenu.put(subMenuType, subMenu);
		
	}
	
	@Override
	public void deleteMenu(SubMenuType subMenuType) {
		mainMenu.remove(subMenuType);
		
	}
	
	@Override
	public void removeAllMenu() {
		mainMenu.clear();
		
	}

}
