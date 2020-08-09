
public class Test04 {

	public static void main(String[] args) {
		int a = 8;
		
		//else if(a > 5)가 만족했기 때문에 이후 것은 실행 안함. 
		if(a > 10) {
			System.out.println("a가 10보다 크다.");
		} else if(a > 5) {
		    System.out.println("a가 5보다 크다.");
		} else {
			System.out.println("a가 10보다 크지 않다.");
		}
		
		
		int point = 65;
	    if (point >= 90) {
	    	System.out.println("A");
	    } else if (point >= 80) {
	    	System.out.println("B");
	    } else if (point >= 70) {
	    	System.out.println("C");
	    } else if (point >= 60) {
	    	System.out.println("D");
    	} else {
    		System.out.println("F");
    	}
    
	    
		float point2 = 4.12f;
	    if (point2 == 4.5) {
	    	System.out.println("A+");
	    } else if (point2 >= 4.0) {
	    	System.out.println("A");
	    } else if (point2 >= 3.5) {
	    	System.out.println("B+");
	    } else if (point2 >= 3.0) {
	    	System.out.println("B");
	    } else if (point2 >= 2.5) {
	    	System.out.println("C+");
	    } else if (point2 >= 2.0) {
	    	System.out.println("C");
	    } else if (point2 >= 1.5) {
	    	System.out.println("D+");
	    } else if (point2 >= 1.0) {
	    	System.out.println("D");
    	} else {
    		System.out.println("F");
    	}
	}
}
