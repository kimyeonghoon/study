
public class Test13 {

	public static void main(String[] args) {
		  
		  // 소수 개수
		  int sum = 0;
		  
		  for(int i = 1; i <= 100; i++) {
		  // i % j 결과가 0일 때 count 1 증가하기 위해 변수 선언
			  int count = 0;
		   
		   // i와 j의 값이 같을 때 빠져나옴.
			  for(int j = 1; j <= i; j++) {
				  if(i % j == 0) {
					  count += 1;
				  }
		   }
		   
		   /* count가 2일 때만 1을 더함.(3이상 나올 경우 소수 X)
		    *
		    * i를 1로 나눌 때, 소수 자신의 값으로 나눌 때(나머지가 0이 두 번만 나와야 소수)
		    *
		    */
		   if(count == 2) {
			   sum += 1;
		   	}
		   
		  }
		  System.out.println(sum);
	}

}
