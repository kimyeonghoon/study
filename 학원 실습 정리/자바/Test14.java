
public class Test14 {

	public static void main(String[] args) {

		int targetNumber = 315;
        int arrNum = 0;
        int[] numberLists = new int[10];
        
        for(int i = 2; i < 315; i++) {
            while(targetNumber % i == 0) {
                targetNumber = targetNumber / i;
                numberLists[arrNum] = i;
                arrNum++;
            }

        }
        
        
        // 브레이크 쓸 경우
        for(int i = 0; i < numberLists.length; i++) {
        	if(numberLists[i] == 0) {
        		break;
        	}
        	System.out.print(numberLists[i] + " ");
        }
        

        
        //  브레이크 안쓸 경우.        
//        for(int i = 0; i < numberLists.length; i++) {
//            if(numberLists[i] != 0) {
//            	
//            System.out.println(numberLists[i]);
//            }
//        }
	}

}
