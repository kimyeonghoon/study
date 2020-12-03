package chap05;

import java.util.Arrays;

public class Sample10 {
	public static void main(String[] args) {
		int[] num1 = {1, 2, 3};
		int[][] num2 = {{1, 2, 3}, {4, 5, 6}, {7} ,{8, 9, 10}, {11, 12, 13}};
		
		System.out.println(num1 + " - 배열 자체는 내용을 확인할 수 없다.");
		System.out.println(Arrays.toString(num1) + " - Arerays.toString()");
		System.out.println(Arrays.toString(num2) + " - 다차원 배열은 출력할 수 없다.");
		System.out.println(Arrays.deepToString(num2));
	}
}
