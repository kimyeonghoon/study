package chap04;

public class Sample15 {
	public static void main(String[] args) {
		// 복합 대입연산자
		int num1 = 3;
		int num2 = 3;
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		
		num1 = num1 + 3;
		num2 += 3;
		System.out.println("=== + 3");
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);

		num1 = num1 * 3;
		num2 *= 3;
		System.out.println("=== * 3");
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		
		num1 = num1 - 3;
		num2 -= 3;
		System.out.println("=== - 3");
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		
		num1 = num1 / 3;
		num2 /= 3;
		System.out.println("=== / 3");
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);

		num1 = num1 % 3;
		num2 %= 3;
		System.out.println("=== % 3");
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
	}
}
