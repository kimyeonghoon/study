
public class Test11 {

	public static void main(String[] args) {

		 /* 팩토리얼 문제
		   * 1! + 2! + 3! + 4! + 5! + 6! + 7! + 8! + 9! + 10! = ?
		   *
		   * 1! = 1
		   * 2! = 2
		   * 3! = 6
		   * 4! = 24
		   * 5! = 120
		   * 6! = 720
		   * 7! = 5040
		   * 8! = 40320
		   * 9! = 362880
		   * 10! = 3628800
		   *
		   */
		  
		  int sum = 0;
		  int result = 0;
		  
		  for (int i = 0 ; i < 11 ; i++) {
		   
		   // result의 값이 1보다 작을 경우 i 값을 더함, 아닐 경우 i 값을 곱함.
			  if(result < 1) {
				  result = result + i;
			  } else {
				  result = result * i;
			  }
			  
			  sum = sum + result;
			  
		  }
		  
		  System.out.println(sum);
		
	}

}
