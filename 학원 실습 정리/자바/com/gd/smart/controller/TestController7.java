package com.gd.smart.controller;

import com.gd.smart.service.SingletonTest;
import com.gd.smart.service.TestService7;

public class TestController7 {

	public static void main(String[] args) {
		TestService7.msg = "Hi";
		System.out.println(TestService7.msg);
		
		TestService7.test();
		
		//static final 변수는 변경 불가.
		//TestService7.STR = "AAA";
		
		System.out.println(TestService7.STR);
		
		SingletonTest st = SingletonTest.getInstance();
		
		System.out.println(st.msg);
	}

}
