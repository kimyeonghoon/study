import java.util.Scanner;

public class Ele {
	public static void main(String[] args) {
		// 최대 탑승 인원
		int maxRide = 4;
		// 현재 탑승 인원
		int ride = 0;
		// 엘레베이터 이동방향 체크(true - up, false - down)
		boolean upDown = true;
		// 현재 엘레베이터 층
		int currentEle = 1;
		// 사용자 입력 받기
		Scanner sc = new Scanner(System.in);
		// 승객이 원하는 층수 체크
		int one = 0;
		int two = 0;
		int three = 0;
		// 프로그램 시작
		while (true) {
			boolean endFlag = false;
			System.out.println("----------------------------------");
			// 2층일 경우 엘레베이터가 올라가는지 내려가는지 표시
			if (upDown && currentEle == 2) {
				System.out.print("[△]");
			} else if (upDown == false && currentEle == 2) {
				System.out.print("[▼]");
			}
			// 정보 표시
			System.out.println("[현재 층 - " + currentEle + "층 / 탑승인원 - " + ride + "명  / 목적지 - 1층(" + one + "), 2층(" + two
					+ "), 3층(" + three + ")]");
			System.out.println();
			// 항목 선택
			System.out.println("항목을 선택하세요  - 1.탑승하기   2.다음층으로 이동   3.프로그램 종료");
			System.out.println("----------------------------------");
			switch (sc.nextLine()) {
			// 1. 탑승하기 선택
			case "1":
				while (true) {
					boolean endFlag2 = false;
					// 탑승이 가능하다면 몇층 갈껀지 체크(현재 엘레베이터가 멈춰있는 층은 선택 불가)
					if (maxRide > ride) {
						System.out.println("몇층으로 가시겠습니까? [현재층 - " + currentEle + "층]\n1.1층\n2.2층\n3.3층");
						switch (sc.nextLine()) {
						// 1-1. 1층 선택
						case "1":
							// 1층이 아닌 다른 버튼 눌렀을 때 / 1층 버튼을 눌렀을 때
							if (currentEle != 1) {
								ride++;
								one++;
								System.out.println("선택한 층은 1층입니다.");
								endFlag2 = true;
							} else {
								System.out.println("현재층은 " + currentEle + "층 입니다. 다시 선택해주세요.");
							}
							break;
						// 1-2. 2층 선택
						case "2":
							if (currentEle != 2) {
								// 2층이 아닌 다른 버튼 눌렀을 때 / 2층 버튼을 눌렀을 때
								ride++;
								two++;
								System.out.println("선택한 층은 2층입니다.");
								endFlag2 = true;
							} else {
								System.out.println("현재층은 " + currentEle + "층 입니다. 다시 선택해주세요.");
							}
							break;
						// 1-3. 3층 선택
						case "3":
							if (currentEle != 3) {
								// 3층이 아닌 다른 버튼 눌렀을 때 / 3층 버튼을 눌렀을 때
								ride++;
								three++;
								System.out.println("선택한 층은 3층입니다.");
								endFlag2 = true;
							} else {
								System.out.println("현재층은 " + currentEle + "층 입니다. 다시 선택해주세요.");
							}
							break;
						default:
							System.out.println("잘못 입력하셨습니다. 다시 선택해주세요.");
						}
					} else { // 인원 초과시 탑승 불가능
						System.out.println("[인원 초과]탑승이 불가능합니다.");
						System.out.println();
						break;
					}
					if (endFlag2) { // 탑승이 완료되면 층선택에서 빠져 나옴
						System.out.println("탑승하였습니다");
						System.out.println();
						break;
					}
				}
				break;
			// 2. 다음 층으로 이동 선택
			case "2":
				System.out.println("다음층으로 이동합니다.");
				if (currentEle == 3 && upDown) {
					upDown = false;
				} else if (currentEle == 1 && upDown == false) {
					upDown = true;
				}
				if (upDown && currentEle <= 2) {
					currentEle++;
				} else if (upDown == false && currentEle >= 1) {
					currentEle--;
				}
				if (currentEle == 1) {
					ride -= one;
					one = 0;
				} else if (currentEle == 2) {
					ride -= two;
					two = 0;
				} else {
					ride -= three;
					three = 0;
				}
				break;
			// 3. 프로그램 종료
			case "3":
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