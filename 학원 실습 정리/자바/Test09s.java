
public class Test09s {
	public Test09s() {
		System.out.println("기본생성자 호출");
	}
	
	public Test09s(String a) {
		System.out.println("추가생성자 호출");
		s = a;
	}
	
	String s = "Hi";
	
	public void test() {
		System.out.println("첫 메소드 생성!!!");
	}
	
	public int plus(int a, int b) {
		return a + b;
	}
	
	public int minus(int a, int b) {
		return a - b;
	}
	
	public int multiply(int a, int b) {
		return a * b;
	}

	public int division(int a, int b) {
		return a / b;
	}
	
	public int reminder(int a, int b) {
		return a % b;
	}
}
