
public class Test12 {

	public static void main(String[] args) {
		  // 57에 가장 가까운 수 구하기 - 28, 19, 87, 66, 45, 6, 79, 30, 96, 33
		  
		  int[] numbers = {28,19,87,66,45,6,79,30,96,33};
		  int targetNumber = 57;
		  int cha = 0;
		  int tmp = 0;
		  int nearNum = 0;
		 
		  for(int i = 0; i < numbers.length; i++) {
			  for(int j = 0; j < numbers.length; j++) {
				  if(numbers[i] >= targetNumber) {
					  cha = numbers[i] - targetNumber;
				  } else if(numbers[i] < targetNumber) {
					  cha = targetNumber - numbers[i];
				  }
			  }
		 	  
			  if(tmp == 0 || cha < tmp) {
				  tmp = cha;
				  nearNum = numbers[i];
			  } 
		   
		  }
		  
		  System.out.println(nearNum);
	}

}
