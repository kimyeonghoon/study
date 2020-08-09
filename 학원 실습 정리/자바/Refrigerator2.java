import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Refrigerator2 {

	public static void main(String[] args) {

		final String egg = "계란";
		final String milk = "우유";
		final String watermelon = "수박";

		int eggs = 0;
		int milks = 0;
		int watermelons = 0;

		// 유통 기한
		int expirationDateEgg = 3;
		int expirationDateMilk = 5;
		int expirationDateWatermelon = 7;

		// 계란, 우유, 수박 차지하는 공간
		int spaceEgg = 1;
		int spaceMilk = 3;
		int spaceWatermelon = 5;

		// 냉장고의 최대 공간
		int maxSpace = 50;

		// 냉장고 공간 카운트
		int spaceCount = 0;

		// 남은 공간 카운트
		int remainSpaceCount = maxSpace - spaceCount;

		String itemInput;
		String itemCountInput;
		String yesNoInput;
		String dayInput;
		int item = 0;
		int itemCount = 0;
		int yesNo = 0;
		int day = 0;

		Scanner sc = new Scanner(System.in);

		List<HashMap<String, String>> refri = new ArrayList<HashMap<String, String>>();

		boolean nextDayCheck = true;
		boolean addCheck = true;
		boolean yesNoCheck = true;
		while (addCheck) {

			System.out.println("냉장고에 넣을 품목을 선택하세요.\n1. 계란, 2. 우유, 3. 수박");
			itemInput = sc.nextLine();
			item = Integer.parseInt(itemInput);

			System.out.println("냉장고에 넣을 개수를 입력해주세요. 한 번에 5개까지만 넣을 수 있습니다.(1~5)");
			itemCountInput = sc.nextLine();
			itemCount = Integer.parseInt(itemCountInput);

			if (item == 1 || item == 2 || item == 3) {
				System.out.println("폼목 입력 완료!!");
			} else {
				System.out.println("잘못 선택하셨습니다.");
				continue;
			}

			if (itemCount == 1 || itemCount == 2 || itemCount == 3 || itemCount == 4 || itemCount == 5) {
				System.out.println("수량 입력 완료!!");
			} else {
				System.out.println("잘못 선택하셨습니다.");
				continue;
			}

			if (item == 1 && remainSpaceCount > spaceEgg * itemCount) {
				HashMap<String, String> temp = new HashMap<String, String>();
				temp.put("item", egg);
				temp.put("count", itemCountInput);
				temp.put("exp", Integer.toString(expirationDateEgg));
				refri.add(temp);
				spaceCount += spaceEgg * itemCount;

			} else if (item == 2 && remainSpaceCount > spaceMilk * itemCount) {
				HashMap<String, String> temp = new HashMap<String, String>();
				temp.put("item", milk);
				temp.put("count", itemCountInput);
				temp.put("exp", Integer.toString(expirationDateMilk));
				refri.add(temp);
				spaceCount += remainSpaceCount - (spaceMilk * itemCount);
			} else if (item == 3 && remainSpaceCount > spaceWatermelon * itemCount) {
				HashMap<String, String> temp = new HashMap<String, String>();
				temp.put("item", watermelon);
				temp.put("count", itemCountInput);
				temp.put("exp", Integer.toString(expirationDateWatermelon));
				refri.add(temp);
				spaceCount += remainSpaceCount - (spaceWatermelon * itemCount);
			} else {
				System.out.println("냉장고 공간이 부족합니다. 다시 선택화면으로 돌아갑니다.");
				continue;
			}

			// 냉장고에 들어가 있는 물품의 개수를 세기 전 초기화
			eggs = 0;
			milks = 0;
			watermelons = 0;

			for (int i = 0; i < refri.size(); i++) {
				if (refri.get(i).get("item") == egg) {
					eggs += Integer.parseInt(refri.get(i).get("count"));
				}
				if (refri.get(i).get("item") == milk) {
					milks += Integer.parseInt(refri.get(i).get("count"));
				}
				if (refri.get(i).get("item") == watermelon) {
					watermelons += Integer.parseInt(refri.get(i).get("count"));
				}
			}
			System.out.println("[냉장고에 있는 물품 개수] 계란 : " + eggs + "개, 우유 : " + milks + "개, 수박 : " + watermelons + "개");
			System.out.println("[남은 공간] : " + remainSpaceCount);

			System.out.print("[계란의 유통기한] ");
			for (int i = 0; i < refri.size(); i++) {
				if (refri.get(i).get("item") == egg) {
					System.out.print(refri.get(i).get("exp") + "일 남음  : " + refri.get(i).get("count") + "개    ");
				}
			}
			System.out.println();
			System.out.print("[우유의 유통기한] ");
			for (int i = 0; i < refri.size(); i++) {
				if (refri.get(i).get("item") == milk) {
					System.out.print(refri.get(i).get("exp") + "일 남음  : " + refri.get(i).get("count") + "개    ");
				}
			}
			System.out.println();
			System.out.print("[수박의 유통기한] ");
			for (int i = 0; i < refri.size(); i++) {
				if (refri.get(i).get("item") == watermelon) {
					System.out.print(refri.get(i).get("exp") + "일 남음  : " + refri.get(i).get("count") + "개    ");
				}
			}
			System.out.println();
			System.out.println();

			nextDayCheck = true;

			System.out.println("무엇을 하시겠습니까?\n1.물건을 더 넣기 2.다음날로 넘어가기 3. 냉장고 문 닫기");

			while (nextDayCheck) {
				dayInput = sc.nextLine();
				day = Integer.parseInt(dayInput);

				if (day == 1) {
					break;
				} else if (day == 2) {
					String tempItem;
					String tempCount;
					String tempExp;
					int nextExp;
					for (int i = 0; i < refri.size(); i++) {
						tempItem = refri.get(i).get("item");
						tempCount = refri.get(i).get("count");
						tempExp = refri.get(i).get("exp");
						nextExp = Integer.parseInt(tempExp) - 1;
						HashMap<String, String> temp = new HashMap<String, String>();
						temp.put("item", tempItem);
						temp.put("count", tempCount);
						temp.put("exp", Integer.toString(nextExp));
						refri.remove(i);
						if (nextExp > 0) {
							refri.add(temp);
						}
						nextDayCheck = false;
						break;
					}
				} else if (day == 3) {
					System.out.println("냉장고 문을 닫습니다.");
					addCheck = false;
					break;
				} else {
					System.out.println("다시 선택해주세요.");
				}
			}
		}
	}
}