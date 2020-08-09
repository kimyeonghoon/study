import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Refrigerators {
	List<HashMap<String, String>> ref;
	
	public Refrigerators(List<HashMap<String, String>> ref) {
		this.ref = ref;
	}
	
	public void insertRef() {
		System.out.println("적재할 항목을 선택하여주세요.[현재 : " + checkRefSize() + "칸]");
		System.out.println("1.계란(1) 2.우유(3) 3.수박(5) 4.취소");
		
		Scanner sc = new Scanner(System.in);
		
		switch(sc.nextLine()) {
		case "1" : 
			if(50 >= checkRefSize() + 1) {
				HashMap<String, String> item = new HashMap<String, String>();
				item.put("name", "계란");
				item.put("size", "1");
				item.put("day", "3");
				
				ref.add(item);
			}
			break;
		case "2" :
			if(50 >= checkRefSize() + 3) {
				HashMap<String, String> item = new HashMap<String, String>();
				item.put("name", "우유");
				item.put("size", "3");
				item.put("day", "5");
				
				ref.add(item);
			}
			break;
		case "3" :
			if(50 >= checkRefSize() + 5) {
				HashMap<String, String> item = new HashMap<String, String>();
				item.put("name", "수박");
				item.put("size", "5");
				item.put("day", "7");
				
				ref.add(item);
			}
			break;
		case "4" :
			break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	// checkRefSize() : 냉장고 품목 누적 사이즈 구하는 메소드
	public int checkRefSize() {
		int size = 0;
		
		for(HashMap<String, String> item : ref) {
			size += Integer.parseInt(item.get("size"));
		} // size누적 for End
		
		return size;
	} // checkRefSize End
	
	public void printRef() {
		System.out.println("품목\t크기\t남은유통기한");
		for(HashMap<String, String> item : ref) {
			System.out.println(item.get("name") 
							+ "\t" + item.get("size") 
							+ "\t" + item.get("day"));
		}
	}
	
	public void nextDay() {
		for(int i = 0 ; i < ref.size() ; i++) {
			int  day = Integer.parseInt(ref.get(i).get("day")) - 1;
			
			if(day == 0) {
				ref.remove(i);
				i--;
			} else {
				ref.get(i).put("day", Integer.toString(day));
			}
		}
	}
}