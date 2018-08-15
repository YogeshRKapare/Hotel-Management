package com.hm;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelManagement {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSingletonMenuFactory() {
		MenuFactory menuFactory1 = MenuFactory.getMenuFactory();
		MenuFactory menuFactory2 = MenuFactory.getMenuFactory();
		
		Assert.assertEquals(menuFactory1, menuFactory2);
		
	}
	
	@Test
	public void testSingletonVegMenuFactory() {
		SubMenuVeg subMenuVeg1 = SubMenuVeg.getMenuFactory();
		SubMenuVeg subMenuVeg2 = SubMenuVeg.getMenuFactory();
		
		Assert.assertEquals(subMenuVeg1, subMenuVeg2);
		
	}
	
	@Test
	public void testSingletonNonVegMenuFactory() {
		SubMenuNonVeg subMenuNonVeg1 = SubMenuNonVeg.getMenuFactory();
		SubMenuNonVeg subMenuNonVeg2 = SubMenuNonVeg.getMenuFactory();
		
		Assert.assertEquals(subMenuNonVeg1, subMenuNonVeg2);
		
	}
	
	@Test
	public void testSingletonSoftDrinksFactory() {
		SubMenuSoftDrinks subMenuSoft1 = SubMenuSoftDrinks.getMenuFactory();
		SubMenuSoftDrinks subMenuSoft2 = SubMenuSoftDrinks.getMenuFactory();
		
		Assert.assertEquals(subMenuSoft1, subMenuSoft2);
		
	}
	
	@Test
	public void testconstructMainMenu(){
		
		ConcreteManager concreteManager = new ConcreteManager();
		concreteManager.constructMenu();
		Assert.assertEquals(3, MenuFactory.getMenuFactory().mainMenu.size());
	}
	
	@Test
	public void testconstructVegMenu(){
		ConcreteManager concreteManager = new ConcreteManager();
		concreteManager.constructMenu();
		Assert.assertEquals(1, SubMenuVeg.getMenuFactory().vegMenu.size());
	}
	
	@Test
	public void testconstructNonMenu(){
		ConcreteManager concreteManager = new ConcreteManager();
		concreteManager.constructMenu();
		Assert.assertEquals(1, SubMenuNonVeg.getMenuFactory().nonVegMenu.size());
	}
	
	@Test
	public void testconstructSoftDrinksMenu(){
		ConcreteManager concreteManager = new ConcreteManager();
		concreteManager.constructMenu();
		Assert.assertEquals(1, SubMenuSoftDrinks.getMenuFactory().softDrinksMenu.size());
	}
	
	@Test
	public void testtakeOrder(){
		Waiter waiter = new Waiter(new NoDiscount());
		waiter.takeOrder(SubMenuVeg.getMenuFactory().vegMenu.get("1"));
		waiter.takeOrder(SubMenuNonVeg.getMenuFactory().nonVegMenu.get("1"));
		waiter.takeOrder(SubMenuSoftDrinks.getMenuFactory().softDrinksMenu.get("1"));
		Assert.assertEquals(3, waiter.order.size());
	}
	
	
	@Test
	public void testpresentBill(){
		
		Waiter waiter = new Waiter(new NoDiscount());
		waiter.takeOrder(SubMenuVeg.getMenuFactory().vegMenu.get("1"));
		waiter.takeOrder(SubMenuNonVeg.getMenuFactory().nonVegMenu.get("1"));
		waiter.takeOrder(SubMenuSoftDrinks.getMenuFactory().softDrinksMenu.get("1"));
		Assert.assertEquals(3, waiter.order.size());
		
		double finalBill = waiter.presentBill();
		Assert.assertEquals(826, finalBill,0);
	}
	
	@Test
	public void testdiscountedBill(){
		
		Waiter waiter = new Waiter(new SundayDiscount());
		waiter.takeOrder(SubMenuVeg.getMenuFactory().vegMenu.get("1"));
		waiter.takeOrder(SubMenuNonVeg.getMenuFactory().nonVegMenu.get("1"));
		waiter.takeOrder(SubMenuSoftDrinks.getMenuFactory().softDrinksMenu.get("1"));
		Assert.assertEquals(3, waiter.order.size());
		
		double finalBill = waiter.presentBill();
		Assert.assertEquals(739.27, finalBill,0);
	}
	
	@Test
	public void testCoconutLemonadepresentBill(){
		SubMenuVeg.getMenuFactory().removeAllMenu();
		SubMenuNonVeg.getMenuFactory().removeAllMenu();
		SubMenuSoftDrinks.getMenuFactory().removeAllMenu();
		
		Waiter waiter = new Waiter(new NoDiscount());

		Food food = new Lemonade("1", 50);
		
		food = new CoconutSyrup(food);
		
		SubMenuSoftDrinks.getMenuFactory().softDrinksMenu.put("1",food );
		waiter.takeOrder(food);
		
		
		double finalBill = waiter.presentBill();
		Assert.assertEquals(150, finalBill,0);
	}

}
