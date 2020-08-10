package Prime;

public class Prime {

	public static void main(String[] args) {
		// 소수를 찾을 범위
		int max = 100;
		
		// 소수인지 아닌지 판단하는 배열
		boolean[] a = new boolean[max];
		
		// 배열 초기화
		for(int i = 0; i < max; i++) {
			a[i] = true;
		}
		
		// 소수인지 아닌지를 판단
		for(int i = 2; i < max; i++) {
			if(a[i-1]) {
				for(int j = 2; i*j <= max; j++) {
					a[i * j - 1] = false;
				}
			}
		}
		
		// 결과 표시
		for(int i = 1; i < max; i++) {
			// a[i]가 true인 값만 출력
			if(a[i]) {
				System.out.print((i + 1) + " ");
			}
		}
	}
}
