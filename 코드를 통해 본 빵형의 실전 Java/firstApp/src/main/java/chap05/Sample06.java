package chap05;

import java.util.Arrays;

public class Sample06 {
	public static void main(String[] args) {
		String names = "빵형|상도|타노스|인호|학건";
		String[] arr = names.split("\\|");
		System.out.println("|" + Arrays.toString(arr));
		
		String names1 = "빵형&상도&타노스&인호&학건";
		String[] arr1 = names1.split("\\&");
		System.out.println("&" + Arrays.toString(arr));
		
	}
}
