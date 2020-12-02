package chap04;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 개의 값을 입력받아서 큰 수를 출력하세요(띄어쓰기로 숫자 구분)");
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		if(num1 > num2) {
			System.out.println(num1);
		} else if(num1 < num2) {
			System.out.println(num2);
		} else {
			System.out.println("num1과 num2는 같습니다.");
		}
	}
}
