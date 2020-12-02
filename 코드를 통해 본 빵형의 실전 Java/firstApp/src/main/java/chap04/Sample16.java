package chap04;

public class Sample16 {
	public static void main(String[] args) {
		// 삼항연산자
		int number = 6;
		String result = ((number % 2) == 0) ? "even" : "odd";
		System.out.println(result);
	}
}
