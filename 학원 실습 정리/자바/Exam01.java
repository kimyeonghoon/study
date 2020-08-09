
public class Exam01 {

	public static void main(String[] args) {
		int a = 5;
		int b = 7;
		int c = 3;
		//여기에 코드 작성
		int tmp = a;
		if (a > b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		if (a > c) {
			tmp = a;
			a = c;
			c = tmp;
		}
		if (b > c) {
			tmp = b;
			b = c;
			c = tmp;
		}		
		
		//출력은 손대지 말 것
		System.out.println(a); // 3
		System.out.println(b); // 5
		System.out.println(c); // 7

	}

}
