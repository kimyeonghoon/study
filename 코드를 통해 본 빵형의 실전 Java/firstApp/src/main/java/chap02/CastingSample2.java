package chap02;

public class CastingSample2 {
	public static void main(String[] args) {
		int a = 65;
		byte b = (byte)a;
		System.out.println(b);
		
		b = (byte)(a + 1);
		System.out.println(b);
		
		a = b;
		System.out.println(a);
		
		b = (byte)a;
		System.out.println(b);
	}
}
