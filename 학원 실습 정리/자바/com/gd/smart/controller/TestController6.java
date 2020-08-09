package com.gd.smart.controller;

import com.gd.smart.service.TestService6;

public class TestController6 {

	public static void main(String[] args) {
		try {
			String s = "12";
			int a = Integer.parseInt(s);
			// throw : 뒤에 오는 객체에 해당하는 예외를 강제발생
			throw new ArrayIndexOutOfBoundsException();
		} catch (NumberFormatException ne) {
			ne.printStackTrace();
		} catch (Exception e) {
			// printStackTrace()
			// java에서 발생한 예외에 대한 내용을 출력하기를 요청[자바]
			e.printStackTrace();

			// e.toString()
			// 예외 발생 내용을 문자열로 취득[사용자]

			System.out.println(e.toString());

		}

		System.out.println("종료됨");

		TestService6 ts = new TestService6();

		// throws로 정의된 메소드 사용 시 예외처리 필요.
		// 문제가 발생할 수도 있기 때문
		try {
			ts.test();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
