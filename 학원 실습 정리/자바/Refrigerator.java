import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Refrigerator {

	public static void main(String[] args) {
		List<HashMap<String, String>> ref
			= new ArrayList<HashMap<String, String>>();
		
		Scanner sc = new Scanner(System.in);
		Refrigerators s = new Refrigerators(ref);
		
		while(true) {
			System.out.println("냉장고에서 하실 행위를 선택하여 주십시오.");
			System.out.println("1.적재 2.적재내역조회 3.날짜보내기 4.종료");
			boolean endFlag = false;
			
			switch(sc.nextLine()) {
			case "1" : s.insertRef();
				break;
			case "2" : s.printRef();
				break;
			case "3" : s.nextDay();
				break;
			case "4" : endFlag = true;
				break;
			default : System.out.println("잘못 입력하였습니다.");
			}
			if(endFlag) {
				System.out.println("종료합니다.");
				break;
			}
		}
	}

}




