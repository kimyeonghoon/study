package chap04;

public class Sample07 {
	public static void main(String[] args) {
		// 논리곱
		System.out.println(1 == 1 & 2 == 3);
		System.out.println(1 > 2 & 4 < 2);
		System.out.println(1 < 2 & 4 > 2);
		
		// 논리합
		System.out.println(1 == 1 | 2 == 3);
		System.out.println(1 > 2 | 4 < 2);
		System.out.println(1 < 2 | 4 > 2);

		// 베타논리합
		System.out.println(1 == 1 ^ 2 == 3);
		System.out.println(1 > 2 ^ 4 < 2);
		System.out.println(1 < 2 ^ 4 > 2);
		
		// 논리부정
		System.out.println(!(1 == 1));
		System.out.println(!(1 > 1));
	}
}
