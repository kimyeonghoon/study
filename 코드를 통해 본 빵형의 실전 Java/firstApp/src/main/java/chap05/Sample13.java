package chap05;

import java.util.Arrays;

public class Sample13 {
	public static void main(String[] args) {
		String[] han = new String[] {
			"라면", "미역국", "떡볶이", "수제비", "갈비탕", "순대국"	
		};
		System.out.println("정렬 전 : " + Arrays.toString(han));
		
		// 정렬할 배열을 복사합니다.
		String[] han2 = Arrays.copyOf(han, han.length);
		String[] han3 = Arrays.copyOf(han, han.length);
		
		Arrays.sort(han2);
		Arrays.sort(han3, 2, 5);
		
		System.out.println("전체정렬 후 : " + Arrays.toString(han2));
		System.out.println("범위정렬 후 : " + Arrays.toString(han3));
	}
}
