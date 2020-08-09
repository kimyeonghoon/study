
public class Test05 {

	public static void main(String[] args) {
		int a = 1;
		
		switch(a) {
		case 1 : System.out.println("1입니다.");
				 break;
		case 2 : System.out.println("2입니다.");
		 		 break;
		default : System.out.println("1도 2도 아닙니다.");
		}
		
		int score = 80;
		
		switch(score/5) {
		case 20 : 
		case 19 : System.out.println("A+");
				 break;
		case 18 : System.out.println("A");
		 		 break;
		case 17 : System.out.println("B+");
		 		 break;
		case 16 : System.out.println("B");
		 		 break;
		case 15 : System.out.println("C+");
				 break;
		case 14 : System.out.println("C");
				 break;
		case 13 : System.out.println("D+");
		 		 break;				 
		case 12 : System.out.println("D");
		 		 break;				 
		default : System.out.println("F");
		}
	}

}
