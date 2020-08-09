import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Aquarium_method {

	Scanner sc = new Scanner(System.in);
	// 금붕어 정보
	HashMap<String, String> goldFish = new HashMap<String, String>();
	// 잉어 정보
	HashMap<String, String> carp = new HashMap<String, String>();
	// 구피 정보
	HashMap<String, String> guppy = new HashMap<String, String>();
	// 일차
	int days = 0;
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

	// 물고기 정보 입력
	public void fishInit() {
		goldFish.put("이름", "금붕어");
		goldFish.put("구매가", "100");
		goldFish.put("판매가", "150");
		goldFish.put("성장일", "3");
		carp.put("이름", "잉어");
		carp.put("구매가", "500");
		carp.put("판매가", "1000");
		carp.put("성장일", "7");
		guppy.put("이름", "구피");
		guppy.put("구매가", "200");
		guppy.put("판매가", "350");
		guppy.put("성장일", "5");
	}

	// 구매 화면
	public void buyFish() {
		while (true) {
			boolean endFlag = false;
			System.out.println("----------------------------------");
			System.out.println("항목을 선택하세요 - 1.금붕어(100원) 2.잉어(500원) 3.구피(200원) 4.처음으로 돌아가기");
			System.out.println("----------------------------------");
			switch (sc.nextLine()) {
			case "1":
				buyGoldFish();
				endFlag = true;
				break;
			case "2":
				buyCarp();
				endFlag = true;
				break;
			case "3":
				buyGuppy();
				endFlag = true;
				break;
			case "4":
				endFlag = true;
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
			if (endFlag) {
				break;
			}
		}
	}

	// 금붕어 샀을 때 동작
	public void buyGoldFish() {
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
	}

	// 잉어 샀을 때 동작
	public void buyCarp() {
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
	}

	// 구피 샀을 때 동작
	public void buyGuppy() {
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
	}

	// 판매 화면
	public void sellFish() {
		while (true) {
			boolean endFlag = false;
			System.out.println("----------------------------------");
			System.out.println("항목을 선택하세요 - 1.금붕어(150원) 2.잉어(1000원) 3.구피(350원)  4.처음으로 돌아가기");
			System.out.println("----------------------------------");
			switch (sc.nextLine()) {
			case "1":
				sellGoldFish();
				endFlag = true;
				break;
			case "2":
				sellCarp();
				endFlag = true;
				break;
			case "3":
				sellGuppy();
				endFlag = true;
				break;
			case "4":
				endFlag = true;
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
			if (endFlag) {
				break;
			}
		}
	}

	// 금붕어 팔 때 동작
	public void sellGoldFish() {
		for (int i = 0; i < fishbowl.size(); i++) {
			boolean temp = true;
			if (fishbowl.get(i).get("이름").equals("금붕어") && fishbowl.get(i).get("성장일").equals("0") && temp) {
				fishbowl.remove(i);
				money += Integer.parseInt(goldFish.get("판매가"));
				temp = false;
			} else {
				System.out.println("금붕어를 팔 수 없습니다.");
				break;
			}
			if (temp == false) {
				break;
			}
		}
	}

	// 잉어 팔 때 동작
	public void sellCarp() {
		for (int i = 0; i < fishbowl.size(); i++) {
			boolean temp = true;
			if (fishbowl.get(i).get("이름").equals("잉어") && fishbowl.get(i).get("성장일").equals("0") && temp) {
				fishbowl.remove(i);
				money += Integer.parseInt(carp.get("판매가"));
				temp = false;
			} else {
				System.out.println("잉어를 팔 수 없습니다.");
				break;
			}
			if (temp == false) {
				break;
			}
		}
	}

	// 구피 팔 때 동작
	public void sellGuppy() {
		for (int i = 0; i < fishbowl.size(); i++) {
			boolean temp = true;
			if (fishbowl.get(i).get("이름").equals("구피") && fishbowl.get(i).get("성장일").equals("0") && temp) {
				fishbowl.remove(i);
				money += Integer.parseInt(guppy.get("판매가"));
				temp = false;
			} else {
				System.out.println("구피를 팔 수 없습니다.");
				break;
			}
			if (temp == false) {
				break;
			}
		}
	}

	// 먹이 샀을 때 동작
	public void buyFood() {
		if (money - buyFood > 0) {
			foodCount++;
			money -= buyFood;
		} else {
			System.out.println("돈이 부족합니다.");
		}
	}

	// 먹이 줬을 때 동작
	public void feed() {
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
	}

	// 어항 샀을 때 동작
	public void addFishbowl() {
		if (money - addFishbowl > 0) {
			maxFishbowl++;
			money -= addFishbowl;
		} else {
			System.out.println("어항을 살 수 없습니다.");
		}
	}

	// 하루가 지났을 때 동작
	public void nextDay() {
		days++;
		for (int i = 0; i < fishbowl.size(); i++) {
			int temp = Integer.parseInt(fishbowl.get(i).get("사망예정일")) - 1;
			if (temp == 0) {
				fishbowl.remove(i);
				i--;
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
	}

	// 현재 어항 상태 보기
	public void currFish() {
		for (int i = 0; i < fishbowl.size(); i++) {
			if (fishbowl.get(i).get("사망예정일").equals("-1")) {
				System.out.println(fishbowl.get(i).get("이름") + " - 완전 성장 " + fishbowl.get(i).get("성장일") + "일 남음");
			} else {
				System.out.println(fishbowl.get(i).get("이름") + " - 수명 " + fishbowl.get(i).get("사망예정일") + "일 남음");
			}
		}
	}

	// 성어 체크
	public int adultFish() {
		int adult = 0;
		for (int i = 0; i < fishbowl.size(); i++) {
			if (fishbowl.get(i).get("성장일").contains("0")) {
				adult++;
			}
		}
		return adult;
	}
}
