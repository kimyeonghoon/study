package chap02;

public class Sample14 {
	public static void main(String[] args) {
		final float PI;
		PI = 3.14f;
		
		int radius = 10;
		float area = radius * radius * PI;
		
		System.out.printf("원의 넓이 : %f", area);
	}
}
