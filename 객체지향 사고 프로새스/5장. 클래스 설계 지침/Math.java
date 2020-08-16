
public class Math {
 
	// 전역 범위

	/*
	 * int temp = 0;
	 * 
	 * public int swap(int a, int b) {
	 * 
	 * temp = a; a = b; b = temp;
	 * 
	 * return temp;
	 * 
	 * }
	 */
	
	// 지역범위로 좁힘
	public int swap(int a, int b) {
		
		int temp = 0;
		
		temp = a;
		a = b;
		b = temp;
		
		return temp;
	}
	
}
