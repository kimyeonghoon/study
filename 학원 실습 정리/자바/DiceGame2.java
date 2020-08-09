import java.util.Random;
import java.util.Scanner;

public class DiceGame2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int dice = 0;
		int size = 0;
		System.out.println("굴릴 주사위를 입력해주세요.(4~100면체)");

		dice = sc.nextInt();

		System.out.println("굴릴 주사위의 개수를 입력해주세요.");

		size = sc.nextInt();

		for (int i = 0; i < size; i++) {
			System.out.print(r.nextInt(dice) + 1 + " ");
		}
	}
}
