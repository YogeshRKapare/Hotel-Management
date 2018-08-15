package com.hm;

import java.util.Map;

public abstract class Manager {
	
	public void constructMenu(){
		constructVegMenu();
		constructNonVegMenu();
		constructSoftDrinksMenu();
	}
	
	abstract Map<String, Food> constructVegMenu();
	abstract Map<String, Food> constructNonVegMenu();
	abstract Map<String, Food> constructSoftDrinksMenu();

}
