package chap04;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		// 100점 만점의 학점을 입력받아서 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 60점 이상이면 D, 60점 미만이면 F를 구하는 프로그램을 작성하세요.
		// (입력받는 점수는 0점에서 100점 사이의 값을 넣어야함)
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("0 ~ 100 사이의 점수를 입력하세요 : ");
			int in = sc.nextInt();
			if(in >= 0 && in <= 100) {
				if(in >= 90) {
					System.out.println("A학점");
				} else if(in >= 80) {
					System.out.println("B학점");
				} else if(in >= 70) {
					System.out.println("C학점");
				} else if(in >= 60) {
					System.out.println("D학점");
				} else {
					System.out.println("F학점");
				}
				break;
			} else {
				System.out.println("잘못된 값을 입력하셨습니다.");
			}
		}
	}
}
