import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Aquarium {
	public static void main(String[] args) {
		Aquarium_method am = new Aquarium_method(); 
		// 기본어항 4개
		// 물고기는 해당일자가 지나야 판매 가능
		// 먹이 줄 경우 해당일자가 1일씩 줄어듦
		// 완전 성장 후 3일 경과 시 사망
		// 초기 자금 300원
		// 먹이는 하루에 1번만 줄 수 있음. 전체 어항 적용.
		// (어항 하나당 1마리)
		//
		// 물고기명 | 구매 | 판매 | 성장
		// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		// 금붕어 | 100 | 150 | 3
		// 잉어 | 500 | 1000 | 7
		// 구피 | 200 | 350 | 5
		//
		// 어항 추가 비용 : 10,000원
		// 먹이 : 개당 200원
		// 유저 입력 받기
		Scanner sc = new Scanner(System.in);
		// 소지금
		int money = 300;
		// 현재 어항 개수
		int maxFishbowl = 4;
		// 어항 가격
		int addFishbowl = 10000;
		// 먹이 줄 수 있는 횟수
		int food = 1;
		// 먹이 재고
		int foodCount = 0;
		// 먹이 가격
		int buyFood = 200;
		// 어항 현황
		List<HashMap<String, String>> fishbowl = new ArrayList<HashMap<String, String>>();
		// 금붕어 정보
		HashMap<String, String> goldFish = new HashMap<String, String>();
		goldFish.put("이름", "금붕어");
		goldFish.put("구매가", "100");
		goldFish.put("판매가", "150");
		goldFish.put("성장일", "3");
		// 잉어 정보
		HashMap<String, String> carp = new HashMap<String, String>();
		carp.put("이름", "잉어");
		carp.put("구매가", "500");
		carp.put("판매가", "1000");
		carp.put("성장일", "7");
		// 구피 정보
		HashMap<String, String> guppy = new HashMap<String, String>();
		carp.put("이름", "구피");
		carp.put("구매가", "200");
		carp.put("판매가", "350");
		carp.put("성장일", "5");

		// 금붕어 샀을 때 동작
		if (money - (Integer.parseInt((goldFish.get("구매가")))) >= 0 && ((maxFishbowl - fishbowl.size()) > 0)) {
			HashMap<String, String> buyGoldFish = new HashMap<String, String>();
			buyGoldFish.put("이름", "금붕어");
			buyGoldFish.put("성장일", "3");
			buyGoldFish.put("사망예정일", "-1");
			fishbowl.add(buyGoldFish);
			money -= Integer.parseInt(goldFish.get("구매가"));
		} else {
			System.out.println("구매 하실 수 없습니다.");
		}
		// 금붕어 팔 때 동작(사망예정일이 빠른 순 - List에서 첫번째로 걸리는 금붕어)
		for (int i = 0; i < fishbowl.size(); i++) {
			int temp = 0;
			if (fishbowl.get(i).get("이름").equals("금붕어") && temp == 0) {
				fishbowl.remove(i);
				money += Integer.parseInt(goldFish.get("판매가"));
				temp++;
			}
		}
		// 잉어 샀을 때 동작
		if (money - (Integer.parseInt((carp.get("구매가")))) >= 0 && ((maxFishbowl - fishbowl.size()) > 0)) {
			HashMap<String, String> buyCarp = new HashMap<String, String>();
			buyCarp.put("이름", "잉어");
			buyCarp.put("성장일", "7");
			buyCarp.put("사망예정일", "-1");
			fishbowl.add(buyCarp);
			money -= Integer.parseInt(carp.get("구매가"));
		} else {
			System.out.println("구매 하실 수 없습니다.");
		}
		// 잉어 팔 때 동작(사망예정일이 빠른 순 - List에서 첫번째로 걸리는 금붕어)
		for (int i = 0; i < fishbowl.size(); i++) {
			int temp = 0;
			if (fishbowl.get(i).get("이름").equals("잉어") && temp == 0) {
				fishbowl.remove(i);
				money += Integer.parseInt(carp.get("판매가"));
				temp++;
			}
		}
		// 구피 샀을 때 동작
		if (money - (Integer.parseInt((guppy.get("구매가")))) >= 0 && ((maxFishbowl - fishbowl.size()) > 0)) {
			HashMap<String, String> buyGuppy = new HashMap<String, String>();
			buyGuppy.put("이름", "구피");
			buyGuppy.put("성장일", "5");
			buyGuppy.put("사망예정일", "-1");
			fishbowl.add(buyGuppy);
			money -= Integer.parseInt(guppy.get("구매가"));
		} else {
			System.out.println("구매 하실 수 없습니다.");
		}
		// 구피 팔 때 동작(사망예정일이 빠른 순 - List에서 첫번째로 걸리는 금붕어)
		for (int i = 0; i < fishbowl.size(); i++) {
			int temp = 0;
			if (fishbowl.get(i).get("이름").equals("구피") && temp == 0) {
				fishbowl.remove(i);
				money += Integer.parseInt(guppy.get("판매가"));
				temp++;
			}
		}
		// 먹이 샀을 때 동작
		if (money - buyFood > 0) {
			foodCount++;
			money -= buyFood;
		} else {
			System.out.println("돈이 부족합니다.");
		}
		// 먹이 줬을 때 동작
		if (foodCount > 0 && food > 0) {
			foodCount--;
			for (int i = 0; i < fishbowl.size(); i++) {
				if (Integer.parseInt(fishbowl.get(i).get("성장일")) > 0) {
					int temp = Integer.parseInt(fishbowl.get(i).get("성장일")) - 1;
					fishbowl.get(i).put("성장일", Integer.toString(temp));
				}
			}
		} else {
			System.out.println("먹이를 줄 수 없습니다.");
		}
		// 어항 샀을 때 동작
		if (money - addFishbowl > 0) {
			maxFishbowl++;
			money -= addFishbowl;
		} else {
			System.out.println("어항을 살 수 없습니다.");
		}
		// 하루가 지났을 때 동작
		for (int i = 0; i < fishbowl.size(); i++) {
			int temp = Integer.parseInt(fishbowl.get(i).get("사망예정일")) - 1;
			if (temp == 0) {
				fishbowl.remove(i);
			} else {
				if (fishbowl.get(i).get("사망예정일").equals("-1")) {
					int temp2 = Integer.parseInt(fishbowl.get(i).get("성장일")) - 1;
					fishbowl.get(i).put("성장일", Integer.toString(temp2));
					if (fishbowl.get(i).get("성장일").equals("0")) {
						fishbowl.get(i).put("사망예정일", "3");
					}
				} else {
					fishbowl.get(i).put("사망예정일", Integer.toString(temp));
				}
			}
		}
		// 첫화면
		System.out.println("----------------------------------");
		System.out.println("항목을 선택하세요 - 1.구매 2.판매 3.어항보기 4.어항사기 5.먹이주기  6.다음날로넘기기 7.종료");
		System.out.println("----------------------------------");
		while (true) {
			boolean endFlag = false;
			switch (sc.nextLine()) {
			case "1": am.buyFish();
				break;
			case "2": am.sellFish();
				break;
			case "3":
				break;
			case "4": am.addFishbowl();
				break;
			case "5": am.feed();
				break;
			case "6": am.nextDay();
				break;
			case "7":
				endFlag = true;
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
			if (endFlag) {
				System.out.println("종료합니다.");
				break;
			}
		}
	}
}