package ae.retail.billing;

import java.util.List;

import ae.retail.bean.Item;

public class CalcDiscount {

	public double getNetPayableAmount(List<Item> items, String userType) {
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
				discountPrice += getDiscountOnPercent(nonGroceryBill, 30);
				break;
			case "A":
				discountPrice += getDiscountOnPercent(nonGroceryBill, 10);
				break;
			case "L":
				discountPrice += getDiscountOnPercent(nonGroceryBill, 5);
				break;
			default: //TODO left for future implementation.
			}
		}
		return (totalBill - discountPrice);
	}
	
	private double getDiscountOnPercent(double nonGroceryBill, int percent) {
		return ((nonGroceryBill*percent)/100);
	}

}
