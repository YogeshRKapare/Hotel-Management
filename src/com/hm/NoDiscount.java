package com.hm;

public class NoDiscount implements DiscountStrategy {

	@Override
	public double calculateDiscount(double bill) {
		
		return bill;
	}

}
