package com.hm;

import java.util.HashMap;
import java.util.Map;

public class SubMenuVeg implements SubMenu {

	static Map<String, Food> vegMenu = new HashMap<>();

	static SubMenuVeg subMenuVeg = null;

	public static SubMenuVeg getMenuFactory() {
		if (subMenuVeg == null) {
			synchronized (MenuFactory.class) {
				if (subMenuVeg == null) {
					subMenuVeg = new SubMenuVeg();
				}
			}
		}
		return subMenuVeg;
	}

	@Override
	public void addMenu(String concreteFoodName, Food food) {
		vegMenu.put(concreteFoodName, food);

	}

	@Override
	public void deleteMenu(String concreteFoodName) {
		vegMenu.remove(concreteFoodName);

	}

	@Override
	public void removeAllMenu() {
		vegMenu.clear();

	}

}
