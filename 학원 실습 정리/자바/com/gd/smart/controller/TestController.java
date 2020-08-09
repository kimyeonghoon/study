package com.gd.smart.controller;

import java.util.ArrayList;
import java.util.List;

//import : 경로정보
import com.gd.smart.service.TestBean;
import com.gd.smart.service.TestService;

public class TestController {

	public static void main(String[] args) {
		TestService ts = new TestService();
		
		ts.test();
		
		TestBean tb = new TestBean();
		
		tb.setNo(3);
		tb.setName("Hi");
		
		 // \t : tab키
		 // \n : enter키
		System.out.println(tb.getNo() + "\t" + tb.getName());
		
		List<Integer> list = new ArrayList<Integer>();
		// add(값) : 리스트에 값을 추가한다.
		list.add(5);
		list.add(6);
		list.add(7);
		// add(인덱스번호, 값) : 리스트의 인덱스번호 이후의 번호드를 1씩 증가한다.
		//                    이후 리스트의 인덱스번호에 값을 넣는다.(끼워넣기)
		list.add(1, 3);
		// get(인덱스번호) : 리스트에서 인덱스번호의 값을 가져온다.
		System.out.println(list.get(0));
		// remove(인덱스번호) : 리스트에서 인덱스번호를 지운다.
		list.remove(0);
		System.out.println(list.get(0));
		// indexOf(값) : 리스트에서 값이 있는 인덱스번호를 취득한다.
		System.out.println(list.indexOf(5));
		// contains(값) : 리스트에서 값이 있는지를 확인. boolean으로 결과를 보여줌
		System.out.println(list.contains(5));
		// set(인덱스번호, 값) : 리스트에서 인덱스번호의 값을 주어진 값으로 변경한다.
		list.set(1, 10);
		System.out.println(list.get(1));
		// clear() : 리스트를 비운다.
		list.clear();
		// isEmpty() : 리스트가 비어있는지 확인.
		System.out.println(list.isEmpty());
		// size() : 리스트의 개수를 출력
		System.out.println(list.size());
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// for(타입 변수명 : 목록형데이터) -> 목록형 데이터의 개수만큼 반복한다. 반복시 변수에 데이터를 변수에 넣어준다.
		for(int data : list) {
			System.out.println(data);
		}
		
		list.clear();
		
		list.add(3);
		list.add(7);
		list.add(5);

		
		// 오름차순 정렬을 구현하시오.

		for(int i = 0 ; i < list.size() - 1 ; i++) {
			int temp;
			for(int j = i + 1 ; j < list.size() ; j++) {
				if(list.get(i) > list.get(j)) {
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
					}
			}
		}
		
		// add, remove 사용
//		for(int i = 0 ; i < list.size() - 1 ; i++) {
//			for(int j = list.size() - 1 ; j > i ; j--) {
//				if(list.get(i) > list.get(j)) {
//					list.add(list.get(i));
//					list.remove(i);
//					}
//			}
//		}
		
//		
//		list.sort(null);
//		list.sort(Comparator.naturalOrder());
//		list.sort(Comparator.reverseOrder());
//		
		
		
		for(int data : list) {
			System.out.println(data);
		}
	}
}
