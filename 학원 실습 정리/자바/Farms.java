import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Farms {
	
	int land = 0;
	
	// 농지 초기화
	public int landInit() {
		land = 20;
		return land;
	}
	
	// 농지 추가
	public void addLand() {
		
	}
	

	// 작물정보가 담겨있는 리스트
	List<HashMap<String, String>> cropsList = new ArrayList<HashMap<String, String>>();
	
	// 농장에 심은 작물 리스트
	List<HashMap<String, String>> crops = new ArrayList<HashMap<String, String>>();
	
	// 작물 구매
	public void cropBuy() {
		
	}

	// 감자
	public void potato() {
		HashMap<String, String> temp = new HashMap<String, String>();
		temp.put("작물명", "감자");
		temp.put("구매금액", "100");
		temp.put("성장기간", "5");
		temp.put("판매금액", "150");
		cropsList.add(temp);
	}

	// 호박
	public void pumpkin() {
		HashMap<String, String> temp = new HashMap<String, String>();
		temp.put("작물명", "호박");
		temp.put("구매금액", "300");
		temp.put("성장기간", "8");
		temp.put("판매금액", "450");
		cropsList.add(temp);
	}

	// 보리
	public void barley() {
		HashMap<String, String> temp = new HashMap<String, String>();
		temp.put("작물명", "보리");
		temp.put("구매금액", "500");
		temp.put("성장기간", "10");
		temp.put("판매금액", "720");
		cropsList.add(temp);
	}

	// 쌀
	public void rice() {
		HashMap<String, String> temp = new HashMap<String, String>();
		temp.put("작물명", "쌀");
		temp.put("구매금액", "1000");
		temp.put("성장기간", "20");
		temp.put("판매금액", "2250");
		cropsList.add(temp);
	}

	// 아이템정보가 담겨있는 리스트
	List<HashMap<String, String>> itemList = new ArrayList<HashMap<String, String>>();

	// 농지 확장
	public int expansion30Buy(int add) {
		land += add;
		return land;
	}

	// 스프링쿨러 구매
	public void sprinkler() {
		for(int i = 0; i < cropsList.size() ; i++) {
			int temp = Integer.parseInt(cropsList.get(i).get("성장기간"));
			temp -= 2;
			cropsList.get(i).put("성장기간", Integer.toString(temp));
		}
	}

}
