
public class Test06 {

	public static void main(String[] args) {
		int a = 1;
		
		while(a < 10) {
			System.out.println(a);
			
			a++;
		}
		
		do {
			System.out.println(a);
			
			a++;
		} while(a < 10);
		
		for(int i = 1 ; i < 10 ; i++) {
			if(i % 2 == 1) {
			System.out.println(i);
			}
		}
		
		for(int i = 1 ; i < 10 ; i += 2) {
			System.out.println(i);
		}
		
		// 2 * 1 = 2
		// 2 * i = 2 * i
		// "2 X "+ i + " = " + 2 * i
		// 문자열 + 숫자 + 문자열 + 숫자 => 문자열
		for(int i = 1 ; i < 10 ; i++) {
			System.out.println("2 * "+ i + " = " + 2 * i);
		}
		
		// a = a + 1; a += 1; 
		
		int total = 0;		//1+2+~+100
		for(int i = 1 ; i <= 100 ; i++) {
			total += i; // total = total + i
		}

		System.out.println(total);
	
	
//		int b = 1;
//		int c = 1;
//		int d = 0;
//		
//		for(int i = 1 ; i < 20 ; i++) {
//			System.out.println(d);
//			
//			d = b + c;
//			b = c;
//			c = d;
//		}
		
		
		int b = 0;
		int c = 1;
		int d = b + c;
		
		for(int i = 1 ; i < 21 ; i++) {
			System.out.println(d);
			
			d = b + c;
			b = c;
			c = d;
		}
		


	}

}
