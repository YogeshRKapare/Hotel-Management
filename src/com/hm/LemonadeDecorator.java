package com.hm;

public class LemonadeDecorator extends Food{
	
	Food lemonade;
	
	public LemonadeDecorator(Food lemonade) {
		this.lemonade = lemonade;
	}
		
	

	public String getFoodName() {
		// TODO Auto-generated method stub
		return lemonade.getFoodName();
	}
	

	public double getPrice() {
		// TODO Auto-generated method stub
		return lemonade.getPrice();
	}
}
