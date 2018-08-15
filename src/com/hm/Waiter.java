package com.hm;

import java.util.ArrayList;
import java.util.List;

public class Waiter implements Order{
	
	List<Food> order;
	
	DiscountStrategy discountStrategy;
	
	public Waiter(DiscountStrategy discountStrategy) {
		order = new ArrayList<>();
		this.discountStrategy = discountStrategy;
	}

	@Override
	public void takeOrder(Food food) {
		
		order.add(food);
	}

	@Override
	public double presentBill() {
		
		double finalBill = 0;
		
		for(Food food : order){
			
			System.out.println("Food Item "+food.getFoodName() + "--Price : "+food.getPrice());
			
			finalBill = finalBill + food.getPrice();
		}
		
		return discountStrategy.calculateDiscount(finalBill);
		
	}

}
