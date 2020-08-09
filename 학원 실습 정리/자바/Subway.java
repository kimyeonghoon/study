import java.util.Scanner;

public class Subway {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Subways sw = new Subways();

		// 승객 및 열차 초기화
		sw.trainInit();
		sw.trainStartStation();

		while (true) {
			sw.currentStation();
			System.out.println();
			System.out.println("메뉴 선택\n1.열차탑승 2.현재탑승객정보 3.다음역으로이동 4.종료");
			boolean endFlag = false;

			switch (sc.nextLine()) {
			case "1":
				sw.tempMap();
				sw.destination();
				break;
			case "2": 
				System.out.println("[현재 탑승객 정보]");
				sw.trainNow();
				break;
			case "3":
				sw.nextStation();
				break;
			case "4":
				endFlag = true;
				break;
			default:
				System.out.println("잘못 선택하셨습니다.");
			}
			System.out.println();
			System.out.println();
			if (endFlag) {
				System.out.println("종료합니다.");
				break;
			}

		}
	}
}