package com.gd.smart.service;

public class SingletonTest{
	public String msg = "Hello";
	
	private static SingletonTest instance;
	
	public static SingletonTest getInstance() {
		if(instance == null) {
			instance = new SingletonTest(); 
		}
		
		return instance;
		
	}

}
