package Payment;

public class Alcohol extends Drink {

	float alcper;
	
	Alcohol(String n, int p, int c, float a) {
		super(n, p, c);
		alcper = a;
	}
	
	static void printTitle() {
		System.out.println("상품명(도수[%])\t단가\t수량\t금액");
	}
	
	void printData() {
		System.out.println(name + "(" + alcper + ")" + "\t" + price + "\t" + count + "\t" + getTotalPrice());
	}
}
