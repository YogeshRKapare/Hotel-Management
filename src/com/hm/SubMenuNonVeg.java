package com.hm;

import java.util.HashMap;
import java.util.Map;

public class SubMenuNonVeg implements SubMenu {

	static Map<String, Food> nonVegMenu = new HashMap<>();

	static SubMenuNonVeg subMenuNonVeg = null;

	public static SubMenuNonVeg getMenuFactory() {
		if (subMenuNonVeg == null) {
			synchronized (MenuFactory.class) {
				if (subMenuNonVeg == null) {
					subMenuNonVeg = new SubMenuNonVeg();
				}
			}
		}
		return subMenuNonVeg;
	}

	@Override
	public void addMenu(String concreteFoodName, Food food) {
		nonVegMenu.put(concreteFoodName, food);

	}

	@Override
	public void deleteMenu(String concreteFoodName) {
		nonVegMenu.remove(concreteFoodName);

	}

	@Override
	public void removeAllMenu() {
		nonVegMenu.clear();

	}

}
