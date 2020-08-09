import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;

		boolean check = true;
		String diceType = "";

		while (check) {
			System.out.println("[주사위의 타입을 선택해주세요.(1이상) ex)정육면체 - 6] ");
			diceType = sc.next();

			if (Integer.parseInt(diceType) > 0) {
				check = false;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}

		// 엔터 초기화
		sc.nextLine();

		System.out.println("[주사위의 개수를 선택해주세요. ex)3개 - 3] ");

		int diceCount = sc.nextInt();

		for (int i = 0; i < diceCount; i++) {
			int value = (int) Math.floor(Math.random() * Integer.parseInt(diceType)) + 1;
			list.add(value);
		}

		System.out.println();
		System.out.println("주사위를 굴립니다.");
		System.out.print("주사위의 값 : ");

		for (int data : list) {
			System.out.print(data + " ");
			sum += data;
		}
		System.out.println();
		System.out.println("합산한 값은 " + sum + "입니다.");

	}

}
