
public class Exam02 {

	public static void main(String[] args) {
		// 개미수열 10줄 출력
		/*
		1																			
		1	1																		
		1	2																		
		1	1	2	1																
		1	2	2	1	1	1														
		1	1	2	2	1	3														
		1	2	2	2	1	1	3	1												
		1	1	2	3	1	2	3	1	1	1										
		1	2	2	1	3	1	1	1	2	1	3	1	1	3						
		1	1	2	2	1	1	3	1	1	3	2	1	1	1	3	1	1	2	3	1
		
		규칙 : 이전 숫자들의 해장 숫자 + 개수들을 나열
		*/
		
		String ant = "1";
		System.out.println(ant);
		
		for(int i = 2; i <= 10; i++) {
			String[] ta = ant.split(",");
			ant ="";
			String temp = ta[0];
			int cnt = 0;
			
			for(int j = 0; j <ta.length; j++) {
				if(temp.equals(ta[j])) {
					cnt++;
				} else {
					ant += "," + temp + "," + cnt; // ,숫자,개수
					temp = ta[j];
					cnt = 1;
				}
			}
			ant += "," + temp + "," + cnt;
			ant = ant.substring(1);
			System.out.println(ant);
		}
	}
}

