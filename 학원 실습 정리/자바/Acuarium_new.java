import java.util.Scanner;

public class Acuarium_new {

	public static void main(String[] args) {
		Aquarium_method am = new Aquarium_method(); 
		// 유저 입력 받기
		Scanner sc = new Scanner(System.in);
		am.fishInit();
		
		// 첫화면
		while (true) {
			boolean endFlag = false;
			System.out.println("----------------------------------");
			System.out.println("[" + am.days + "일차]\t소지금 - " + am.money + "\t물고기 수 - " + am.fishbowl.size() + "(성어 " + am.adultFish() + ")" + "\t남은 어항 수 - " + (am.maxFishbowl - am.fishbowl.size()) + "\t먹이 개수 - " + am.foodCount); 
			System.out.println();
			System.out.println("항목을 선택하세요 - 1.구매 2.판매 3.어항보기 4.어항사기 5.먹이사기 6.먹이주기 7.다음날로넘기기 8.종료");
			System.out.println("----------------------------------");
			switch (sc.nextLine()) {
			case "1": 
				am.buyFish();
				break;
			case "2": 
				am.sellFish();
				break;
			case "3": am.currFish();
				break;
			case "4": 
				am.addFishbowl();
				break;
			case "5": 
				am.buyFood();
				break;
			case "6": 
				am.feed();
				break;
			case "7":
				System.out.println("다음날로 넘아갑니다.");
				am.nextDay();
				break;
			case "8":
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
