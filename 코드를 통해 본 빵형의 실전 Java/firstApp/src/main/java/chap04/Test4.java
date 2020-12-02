package chap04;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		// 정수의 값을 입력받고 입력받은 값이 양의 정수이면 그냥 출력하고 음의 정수이면 양의 정수로 변환하여 출력하세요.
		Scanner sc = new Scanner(System.in);
		
		int in = sc.nextInt();
		
		if(in >= 0) {
			System.out.println("입력한 값 : " + in + ", 출력값 : " + (in));
		} else {
			System.out.println("입력한 값 : " + in + ", 출력값 : " + (in) * -1);
		}
		
	}
}
