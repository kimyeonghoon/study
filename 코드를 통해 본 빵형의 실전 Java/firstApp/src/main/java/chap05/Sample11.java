package chap05;

import java.util.Arrays;

public class Sample11 {
	public static void main(String[] args) {
		int[] correct = {1, 2, 3, 4, 1, 4, 3, 2, 1, 3};
		
		int[][] answers = {
				{2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
				{4, 5, 1, 2, 3, 4, 1, 1, 2, 2},
				{1, 2, 3, 4, 1, 4, 3, 2, 1, 3},
				{2, 4, 2, 5, 6, 7, 1, 2, 2, 2},
				{2, 3, 4, 5, 2, 1, 2, 3, 5, 4},
		};
		
		// 만점자 찾기
		int no = 0;
		for(int[] answer : answers) {
			no++;
			if(Arrays.equals(correct, answer)) {
				System.out.printf("%d번 학생은 만점자입니다.\n", no);
			} else {
				System.out.printf("%d번 학생은 만점자가 아닙니다.\n", no);
			}
		}
	}
}
