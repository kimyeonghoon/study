package Sort;

public class Sort {

	public static void main(String[] args) {
		int a[] = {210, 19, 72, 129, 34};
		
		// 배열 속 데이터 확인
		System.out.println("데이터 표시");
		
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		
		// 정렬 시작
		for(int i = 0; i < a.length; i++) {
			int temp;
			for(int j = i + 1; j < a.length - 1; j++) {
				if(a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		
		// 정렬 결과 출력
		System.out.println("정렬 후");
		
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
