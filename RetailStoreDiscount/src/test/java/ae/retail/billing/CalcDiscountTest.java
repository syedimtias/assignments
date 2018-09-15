/**
 * 
 */
package ae.retail.billing;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ae.retail.bean.Item;

/**
 * @author syedi
 *
 */
public class CalcDiscountTest {
	
	static List<Item> items= null;
	static CalcDiscount cDisc = null;
	
	@BeforeAll
	public static void beforeClass() {
		System.out.println("Before Class");
		cDisc = new CalcDiscount();
		items = new ArrayList<Item>();
		items.add(new Item("1", false, 100.0));
		items.add(new Item("2", true, 100.0));
		//Other constructor setting coverage
		Item item = new Item();
		item.setItemCode("3");
		item.setGrocery(false);
		item.setPrice(250.0);
		items.add(item);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("Before");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {
		System.out.println("After");
	}
	
	@AfterAll
	public static void afterClass() {
		System.out.println("After Class");
	}

	/**
	 * Test method for {@link ae.junit.test.Calculator#add(int, int)}.
	 */
	@Test
	public void testGetDiscountedPriceE() {
		assertEquals(testGetDiscountedPrice(items, "E"), cDisc.getDiscountedPrice(items, "E"), "Success");
		System.out.println("Test E : " + testGetDiscountedPrice(items, "E"));
		
	}
	
	@Test
	public void testGetDiscountedPriceA() {
		assertEquals(testGetDiscountedPrice(items, "A"), cDisc.getDiscountedPrice(items, "A"), "Success");
		System.out.println("Test A : " +testGetDiscountedPrice(items, "A"));
	}
	
	@Test
	public void testGetDiscountedPriceL() {
		assertEquals(testGetDiscountedPrice(items, "L"), cDisc.getDiscountedPrice(items, "L"), "Success");
		System.out.println("Test L : " +testGetDiscountedPrice(items, "L"));
	}

	@Test
	public void testGetDiscountedPriceDefault() {
		assertEquals(testGetDiscountedPrice(items, ""), cDisc.getDiscountedPrice(items, ""), "Success");
		System.out.println("Test Default : " +testGetDiscountedPrice(items, ""));
	}
	
	@Test
	public void testGetDiscountedPriceNull() {
		assertEquals(testGetDiscountedPrice(items, null), cDisc.getDiscountedPrice(items, null), "Success");
		System.out.println("Test null : " +testGetDiscountedPrice(items, null));
	}
	
	
	private double testGetDiscountedPrice(List<Item> items, String userType) {
		double totalBill = 0;
		double nonGroceryBill = 0;
		double discountPrice = 0;
		
		//Extract total bill amount and nonGrocery items bill separately
		for(Item item: items) {
			totalBill += item.getPrice();
			if(!item.isGrocery()) {
				nonGroceryBill += item.getPrice();
			}
		}
		// $5 discount on every 100 spent.
		discountPrice = (((int)totalBill/100) * 5);
		if(userType != null) {
			switch(userType) {
			
			case "E":
				discountPrice += testGetDiscountOnPercent(nonGroceryBill, 30);
				break;
			case "A":
				discountPrice += testGetDiscountOnPercent(nonGroceryBill, 10);
				break;
			case "L":
				discountPrice += testGetDiscountOnPercent(nonGroceryBill, 5);
				break;
			default: //TODO left for future implementation.
			}
		}
		return (totalBill - discountPrice);
	}
	
	private double testGetDiscountOnPercent(double nonGroceryBill, int percent) {
		return ((nonGroceryBill*percent)/100);
	}
}
