package com.hm;

public interface SubMenu {

	public void addMenu(String concreteFoodName, Food food);

	public void deleteMenu(String concreteFoodName);

	public void removeAllMenu();
}
