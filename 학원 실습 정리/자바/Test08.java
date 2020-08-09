
public class Test08 {

	public static void main(String[] args) {
		//		   0  1  2  3
		int[] a = {2, 4, 6, 8};
		
		System.out.println(a[1]);
		
		
		int[] testarr = new int[20];
		
		System.out.println(a[0]);
		
		System.out.println(a.length);
		
		for(int i = 0 ; i < a.length ; i++) {
			System.out.println(a[i]);
		}
		
		// 오름차순 정렬 실습
		int[] arr = {5, 7, 3};
				
		
//		// 작업(if *3)
//		int tmp = 0;
//		if (arr[0] > arr[1]) {
//			tmp = arr[0];
//			arr[0] = arr[1];
//			arr[1] = tmp;			
//		}
//		if (arr[0] > arr[2]) {
//			tmp = arr[0];
//			arr[0] = arr[2];
//			arr[2] = tmp;			
//		}
//		if (arr[1] > arr[2]) {
//			tmp = arr[1];
//			arr[1] = arr[2];
//			arr[2] = tmp;			
//		}
//		
		
		// 작업(for * 2, if * 1)
		int tmp = 0;
	
		for(int i = 0 ; i < arr.length - 1 ; i++) {
			for(int j = i + 1 ; j < arr.length ; j++) {
				if(arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
				
			}
		
		}
			
		
		// 출력  3, 5, 7 순서대로
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
		
		
	}

}
