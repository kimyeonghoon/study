package com.gd.smart.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TestController5 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		// 연
		System.out.println(c.get(Calendar.YEAR));
		// 월
		System.out.println(c.get(Calendar.MONTH) + 1);
		// 일
		System.out.println(c.get(Calendar.DATE));
		// 시(12시간 기준)
		System.out.println(c.get(Calendar.HOUR));
		// 시(24시간 기준)
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
		// 오전(1) 오후(0) - 오전이다 : TRUE(1), 오전이 아니다 : FALSE(0)
		System.out.println(c.get(Calendar.AM));
		// 오전(0) 오후(1)
		System.out.println(c.get(Calendar.AM_PM));
		// 분
		System.out.println(c.get(Calendar.MINUTE));
		// 초
		System.out.println(c.get(Calendar.SECOND));
		// 요일(주 [n]번째 날 : 일요일[1] ~ 토요일[7] )
		System.out.println(c.get(Calendar.DAY_OF_WEEK));

		Scanner sc = new Scanner(System.in);
		// nextLine() : 한줄을 받아오겠다. -> 다음 엔터까지
		System.out.println(sc.nextLine());
		System.out.println("-------------------");
		// nextInt() : 다음 숫자를 받아오겠다.
		System.out.println(sc.nextInt());
		System.out.println("-------------------");
		// next() : 다음 한 단어를 받아오겠다. -> 공백전까지
		System.out.println(sc.next());

		sc.nextLine(); // 남아있는 엔터 취득(누적되어 있는 것을 초기화하는 행위)

		while (true) {
			System.out.println("-------------------");
			System.out.println("메뉴를 선택하여 주세요.");
			System.out.println("1. 등록\t9. 종료");
			System.out.println("-------------------");
			String input = sc.nextLine();

			if (input.equals("9")) {
				System.out.println("종료하였습니다.");
				break;
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}

		// Ctrl + Space : 자동완성
		// syso 입력 후 자동완성 : System.out.println(); 자동입력
		// Ctrl + Alt + 방향키 위아래 : 해당영역을 해당방향으로 복제
		// Alt + 방향키 위아래 : 해당 영역 이동
		// Ctrl + D : 해당 라인 삭제
		// Ctrl + '-' 또는 '=' : 글자 크기 변경
		// Ctrl + / : 단일 주석 처리 또는 해제
		// Ctrl + shift + / : 멀티라인 주석 처리
		// Ctrl + shift + \ : 멀티라인 주석 해제
		// Ctrl + shift + O : 자동임폴트
		// Alt + shift + A : 멀티라인 편집모드 활성화 또는 해제
		// Ctrl + shift + f : 코드 자동 정렬(괄호 부족 또는 괄호가 많을 때는 작동 안함)
		// Ctrl + Pgup 또는 Pgdn : 열려있는 파일들을 이동
		// Ctrl + 좌우 방향키 : 단어 단위로 이동
		
	}

}
