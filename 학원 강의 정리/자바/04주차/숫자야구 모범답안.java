import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		// 숫자야구 0~9까지
		// 랜덤으로 중복없이 숫자 3개
		// 사용자가 숫자 3개를 입력시 결과를 제공
		// 자리와 값이 일치하면 S(스트라이크)
		// 자리는 틀리나 값이 일치하면 B(볼)
		// 값이 일치하지 않으면 O(아웃)
		// 총 9번안에 3S가 나와야 승리.
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> inList = new ArrayList<Integer>();
		int d = 0;
		for (int j = 0; j < 3; j++) {
			d = (int) Math.floor(Math.random() * 9);
			if (list.contains(d) == true) {
				j--;
				continue;
			}
			list.add(d);
		}

		for (int i = 0; i < 9 ; i++) {
			while(true) {
				inList.clear();
				System.out.println("-------------");
				System.out.println("0~9까지 숫자 3개를 입력해 주세요. 중복없이 띄어쓰기로 구분");
				System.out.println("ex)1 2 3");
				System.out.println("-------------");
				String[] temp = sc.nextLine().split(" ");
				boolean b = true;
				
				for(int j = 0 ; j < temp.length - 1 ; j++) {
					for(int k = j + 1 ; k < temp.length ; k++) {
						if(temp[k].equals(temp[j])) {
							b = false;
							break;
						}
					}
					if(!b) {
						break;
					}
				}
				
				if(b) {
					for(int j = 0 ; j < temp.length ; j++) {
						inList.add(Integer.parseInt(temp[j]));
					}
					break;
				} else {
					System.out.println("중복된 숫자는 입력할 수 없습니다.");
				}
			}
			int s = 0;
			int b = 0;
			int o = 0;
			
			for(int j = 0 ; j < inList.size() ; j++) {
				if(list.indexOf(inList.get(j)) >= 0 
						&& list.indexOf(inList.get(j)) == j) {
					s++;
				} else if(list.indexOf(inList.get(j)) >= 0) {
					b++;
				} else {
					o++;
				}
			}
			
			int[] arr = new int[3];
			
			for(int j = 0 ; j < list.size() ; j++) {
				arr[j] = list.get(j);
			}
			
			int[] inArr = new int[3];
			
			for(int j = 0 ; j < inList.size() ; j++) {
				inArr[j] = inList.get(j);
			}
			
			int s1 = 0;
			int b1 = 0;
			int o1 = 0;
			
			for(int j = 0 ; j < inArr.length ; j++) {
				for(int k = 0 ; k < arr.length ; k++) {
					if(inArr[j] == arr[k] && j == k) {
						s++;
					} else if(inArr[j] == arr[k]) {
						b++;
					}
				}
				
				if(s1 + b1 + o1 < j + 1) {
					o1++;
				}
			}
			
			System.out.println("결과 => S : " + s + ", B : " + b + ", O : " + o );
			
			if(s == 3) {
				break;
			}
		}
	}
}
