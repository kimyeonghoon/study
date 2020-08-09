package com.gd.smart.controller;

import com.gd.smart.service.TestBean;

public class TestController3 {

	public static void main(String[] args) {
		TestBean tb1 = new TestBean();
		
		//tb1의 주소를 tb2에 넣어둠
		TestBean tb2 = tb1;
		
		tb1.setNo(3);
		
		System.out.println(tb2.getNo());

		tb1 = new TestBean();
		tb1.setNo(2);
		System.out.println(tb2.getNo());
		
		tb2 = new TestBean();
		tb2.setNo(4);
		System.out.println(tb2.getNo());
		
	}

}
