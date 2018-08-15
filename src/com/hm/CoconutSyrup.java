package com.hm;

public class CoconutSyrup extends LemonadeDecorator{
	
	
		
	public CoconutSyrup(Food lemonade) {
		super(lemonade);		
	}
	
	@Override
	public double getPrice() {
		
		return super.getPrice() + 100;
	}
	
	@Override
	public String getFoodName() {
		
		return super.getFoodName()+  "--coconut lemonade--";
	}

	
	
	
}
