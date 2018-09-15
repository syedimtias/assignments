package ae.retail.bean;

public class Item {
	
	private String itemCode;
	private boolean grocery;
	private double price;
	
	public Item() {
		
	}
	
	public Item(String itemCode, boolean grocery, double price) {
		this.itemCode = itemCode;
		this.grocery = grocery;
		this.price = price;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public boolean isGrocery() {
		return grocery;
	}
	public void setGrocery(boolean grocery) {
		this.grocery = grocery;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

	
	

}
