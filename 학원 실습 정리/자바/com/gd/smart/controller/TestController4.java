package com.gd.smart.controller;

import java.util.Random;

public class TestController4 {

	public static void main(String[] args) {
		float a = 3.1415f;
		
		// Math.ceil(값) : 올림
		System.out.println(Math.ceil(a));
		
		// Math.floor(값) : 버림
		System.out.println(Math.floor(a));
		
		// Math.round(값) : 반올림
		System.out.println(Math.round(a));

		int b = -17;
		
		// Math.abs(값) : 절대값
		System.out.println(Math.abs(b));
		
		// Math.random() : 0.0 ~ 0.999999999999999까지의 난수 생성(소수점 15개)
		System.out.println(Math.random());
		
		// ex) 1 ~ 10까지의 랜덤숫자 구하기( 공식 - Math.floor(랜덤 * 범위개수) + 시작값 )
		System.out.println( (int) Math.floor(Math.random() * 10) + 1);
		
		// Random 클래스 사용할 경우
		Random r = new Random();
		// nextInt(값) : 0 ~ 값전까지 랜덤값 돌려줌.
		System.out.println(r.nextInt(10) + 1);
		

		
		
		
		
		
	}

}
