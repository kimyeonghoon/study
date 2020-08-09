
public class Test03 {

	public static void main(String[] args) {
	int a = 4;
	int b = 2;
	
	System.out.println(a + b);
	System.out.println(a - b);
	System.out.println(a * b);
	System.out.println(a / b);
	System.out.println(a % b);
	
	a = a + 1;
	
	System.out.println(a);

	a += 1;
	
	System.out.println(a);
	
	a++;
	
	System.out.println(a);
	// 한줄 주석
	/* 
	 * 여러 줄 주석
	 */
	System.out.println(++a); // 출력 전 1증가로 8
	
	System.out.println(a++); // 8출력 후 1증가로 9
	
	System.out.println(--a); // 출력 전 1 감소로 8
	
	System.out.println(a--); // 8출력 후 1 감소로 7
	
	// ++a
	a += 1;
	System.out.println(a);
	// a++
	System.out.println(a);
	a += 1;
	// --a
	a -= 1;
	System.out.println(a);
	// a--
	System.out.println(a);
	a -=1;
	
	System.out.println(a > b);
	System.out.println(a < b);
	System.out.println(a >= b);
	System.out.println(a <= b);
	System.out.println(a == b);
	System.out.println(a != b);
		
	int c = 10;
	int d = 20;
	String e = "30";
	
	System.out.println(c + d + e); // 3030
	/*
	 * c + d + e
	 * 숫자 + 숫자 + 문자열
	 * 숫자10 + 숫자20 -> 숫자30
	 * 숫자30 + 문자열30 -> 문자열3030
	 */
	System.out.println(e + d + c); // 302010
	/*
	 * e + d + c
	 * 문자열 + 숫자 + 숫자
	 * 문자열30 + 숫자20 -> 문자열3020
	 * 문자열3030 + 숫자10 -> 문자열302010
	 */
	System.out.println(e + (d + c)); // 3030
	// 숫자계산을 먼저하기 위해()로 묶어준다. ()안쪽이 우선순위를 가진다.
	}

}
