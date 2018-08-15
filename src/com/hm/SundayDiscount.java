package com.hm;

public class SundayDiscount implements DiscountStrategy {

	@Override
	public double calculateDiscount(double bill) {
		
		return bill - ((bill * 10.5)/100);
	}

}
