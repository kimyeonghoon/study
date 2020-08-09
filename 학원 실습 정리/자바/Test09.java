
public class Test09 {

	public static void main(String[] args) {
		Test09s ts = new Test09s("Hello~!");
		
		System.out.println(ts.hashCode());
		
		System.out.println(ts);
		// . -> ~에 있는
		System.out.println(ts.s);
		// ts에 있는 s를 가져와라
		
		ts.test();
		ts.test();
		ts.test();
		
		
		
		int num1 = 5;
		int num2 = 2;
		
		System.out.println(ts.plus(num1, num2));
		System.out.println(ts.minus(num1, num2));
		System.out.println(ts.multiply(num1, num2));
		System.out.println(ts.division(num1, num2));
		System.out.println(ts.reminder(num1, num2));

	}

}
