package com.hm;

import java.util.HashMap;
import java.util.Map;

public class SubMenuSoftDrinks implements SubMenu {

	static Map<String, Food> softDrinksMenu = new HashMap<>();

	static SubMenuSoftDrinks subMenuSoftDrinks = null;

	public static SubMenuSoftDrinks getMenuFactory() {
		if (subMenuSoftDrinks == null) {
			synchronized (MenuFactory.class) {
				if (subMenuSoftDrinks == null) {
					subMenuSoftDrinks = new SubMenuSoftDrinks();
				}
			}
		}
		return subMenuSoftDrinks;
	}

	@Override
	public void addMenu(String concreteFoodName, Food food) {
		softDrinksMenu.put(concreteFoodName, food);

	}

	@Override
	public void deleteMenu(String concreteFoodName) {
		softDrinksMenu.remove(concreteFoodName);

	}

	@Override
	public void removeAllMenu() {
		softDrinksMenu.clear();

	}

}
