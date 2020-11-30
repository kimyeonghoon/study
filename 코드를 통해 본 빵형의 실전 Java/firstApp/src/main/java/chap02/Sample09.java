package chap02;

public class Sample09 {
	public static void main(String[] args) {
		String a1 = "1234";
		int a2 = Integer.parseInt(a1);
		
		int b1 = 5678;
		String b2 = Integer.toString(b1);
		String b3 = String.valueOf(b1);
		String b4 = "" + b1;
		
		float c1 = 1234.5678f;
		String c2 = Float.toString(c1);
		String c3 = String.valueOf(c1);
		String c4 = "" + c1;
		
		System.out.println("String to Int :: " + a2);
		System.out.println("Int to String :: " + b2);
		System.out.println("Int to String :: " + b3);
		System.out.println("Int to String :: " + b4);
		System.out.println("Float to String :: " + c2);
		System.out.println("Float to String :: " + c3);
		System.out.println("Float to String :: " + c4);
		
	}
}
