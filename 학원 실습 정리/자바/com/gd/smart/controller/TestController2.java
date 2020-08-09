package com.gd.smart.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestController2 {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		// put(키, 값) : map에 해당 데이터를 추가한다.
		map.put("1","가나다");
		map.put("2","라마바");
		map.put("3","사아자");
		// get(키) : 키에 해당하는 값을 돌려준다.
		System.out.println(map.get("3"));
		// remove(키) : 키에 해당하는 내용을 제거한다.
		map.remove("1");
		System.out.println(map.get("1"));
		// 굳이 replace는 안씀. put 사용
		map.put("2", "ABC");
		System.out.println(map.get("2"));
		// cantainsKey(값), containsValue(값) : 값에 해당하는 키나 값이 있으면 boolean으로 제공
		System.out.println(map.containsKey("1"));
		System.out.println(map.containsValue("사아자"));
		
		Set<String> keySet = map.keySet();
		// 배열
		//String[] keysArr = (String[])keySet.toArray();
		Iterator<String> keys = keySet.iterator();
		// hasNect() : 다음에 값이 있는지 확인
		while(keys.hasNext()) {
			// next() : 다음으로 이동하며, 다음값을 돌려준다.
			System.out.println(map.get(keys.next()));
		}
		
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		for(int i = 10 ; i > 0 ; i--) {
			HashMap<String, String> temp = new HashMap<String, String>();
			
			temp.put("no", Integer.toString(i));
			temp.put("title", "Test" + Integer.toString(i));
			
			list.add(temp);
			
		}
		
		for(int i = 0 ; i < list.size(); i ++) {
			System.out.println(list.get(i).get("no") + "\t" + list.get(i).get("title"));
		}
		
		
	}

}
