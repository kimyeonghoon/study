import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Rps {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		List list = new ArrayList();
		list.add("가위");
		list.add("바위");
		list.add("보");

		int player = -1;
		int computer = r.nextInt(3);

		while (true) {
			boolean endFlag = false;
			System.out.println("[가위, 바위, 보] 선택");
			switch (sc.nextLine()) {
			case "가위":
				player = 0;
				endFlag = true;
				break;
			case "바위":
				player = 1;
				endFlag = true;
				break;
			case "보":
				player = 2;
				endFlag = true;
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}

			if (computer == player) {
				System.out.println("비겼습니다. 재대결!!");
				System.out.println();
				computer = r.nextInt(3);
				endFlag = false;
			} else if (endFlag) {
				break;
			}

		}
		System.out.println("[유저] " + list.get(player) + " vs " + list.get(computer) + " [컴퓨터]");
		System.out.println();

		if (computer == 0) {
			if (player == 1) {
				System.out.println("졌습니다.");
			} else {
				System.out.println("이겼습니다.");
			}
		} else if (computer == 1) {
			if (player == 0) {
				System.out.println("이겼습니다.");
			} else {
				System.out.println("졌습니다.");
			}
		} else if (computer == 2) {
			if (player == 1) {
				System.out.println("졌습니다.");
			} else {
				System.out.println("이겼습니다.");
			}
		}
	}
}
