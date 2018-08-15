package com.hm;

import java.util.Map;

public class ConcreteManager extends Manager {

	@Override
	public void constructMenu() {
		
		
		Map<SubMenuType, Map<String, Food>> mainMenu = MenuFactory.getMenuFactory().mainMenu;
		mainMenu.put(SubMenuType.VEG, constructVegMenu());
		mainMenu.put(SubMenuType.NON_VEG, constructNonVegMenu());
		mainMenu.put(SubMenuType.SOFT_DRINKS, constructSoftDrinksMenu());
		
		
		

	}

	@Override
	Map<String, Food> constructVegMenu() {
		
		Map<String, Food> subMenuMap;
		subMenuMap = SubMenuVeg.getMenuFactory().vegMenu;
		
		Food value = new VegKolhapuri("1",250.50);
		
		subMenuMap.put("1", value);
		
		return subMenuMap;
		
	}

	@Override
	Map<String, Food> constructNonVegMenu() {
		
		Map<String, Food> subMenuMap;
		subMenuMap = SubMenuNonVeg.getMenuFactory().nonVegMenu;
		
		Food value = new ChikenTikka("1",500.25);
		
		subMenuMap.put("1", value);
		
		return subMenuMap;
		
	}

	@Override
	Map<String, Food> constructSoftDrinksMenu() {
		
		Map<String, Food> subMenuMap;
		subMenuMap = SubMenuSoftDrinks.getMenuFactory().softDrinksMenu;
		
		Food value = new Lemonade("1",75.25);
		
		subMenuMap.put("1", value);
		
		return subMenuMap;
		
	}

}
