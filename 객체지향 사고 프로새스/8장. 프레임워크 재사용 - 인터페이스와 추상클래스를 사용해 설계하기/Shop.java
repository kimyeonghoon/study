package shop;

public abstract class Shop {

	CustList customerList;
	
	public void CalculateSaleTax() {
		System.out.println("Calculate Sales Tax");
	}
	
	public abstract String[] getInventory();
	
	public abstract void buyInventory(String item);
	
}
