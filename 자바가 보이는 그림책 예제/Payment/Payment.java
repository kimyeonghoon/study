package Payment;

public class Payment {

	public static void main(String[] args) {
		Drink coffee = new Drink("커피", 200, 3);
		Drink tea = new Drink("녹차", 150, 2);
		Alcohol wine = new Alcohol("와인", 300, 2, 15.0f);
		
		Drink.printTitle();
		coffee.printData();
		tea.printData();
		System.out.println();
		
		Alcohol.printTitle();
		wine.printData();
		
		int sum = coffee.getTotalPrice() + tea.getTotalPrice() + wine.getTotalPrice();
		
		System.out.println("\n*** 합계금액" + sum + "원 ***");
	}

}
