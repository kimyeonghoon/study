import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		List<Integer> comList = new ArrayList<Integer>();
		List<Integer> userList = new ArrayList<Integer>();
		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		// 랜덤한 수 입력 받음(0 ~ 9)
		for (int i = 0; i < 3; i++) {
			int number = r.nextInt(10);
			if (comList.contains(number)) {
				i--;
			} else {
				comList.add(number);
			}
		}

		// 볼 카운트 변수
		int strike = 0;
		int ball = 0;
		int out = 0;

		// 회
		for (int i = 1; i <= 9; i++) {
			System.out.println("[ " + i + "회 ]");

			// 1~3구(유저의 값 입력 받음)
			for (int j = 0; j < comList.size(); j++) {
				System.out.print((j + 1) + "구 - 숫자 입력(0~9) : ");
				String input = sc.nextLine();
				if (userList.contains(Integer.parseInt(input))) {
					i--;
					System.out.println("중복된 숫자입니다. 다시 입력해주세요.");
				} else {
					userList.add(Integer.parseInt(input));
				}
			}

//			// 확인용
//			System.out.print("[컴퓨터가 선택한 숫자] ");
//
//			for (int data : comList) {
//				System.out.print(data + " ");
//			}
//			System.out.println();
//			System.out.print("[유저가 선택한 숫자] ");
//
//			for (int data : userList) {
//				System.out.print(data + " ");
//			}
//			System.out.println();
//			System.out.println();

			// 컴퓨터의 값과 유저가 입력한 값 비교
			for (int j = 0; j < comList.size(); j++) {

				// 값과 위치가 정확하게 위치할 경우, 스트라이크 처리 후 증감값으로 이동
				if (comList.get(j) == userList.get(j)) {
					strike++;
					continue;
				}

				// 값을 비교했을 때 일차하는 게 있다면 볼 카운트
				for (int k = 0; k < userList.size(); k++) {
					if (comList.get(j) == userList.get(k)) {
						ball++;
					}
				}
			}

			// 아웃카운트
			out = Math.abs((strike + ball) - 3);
			
//			if((strike + ball) == 3) {
//				out = (strike + ball) - 3;
//			} else {
//				out = 3 - (strike + ball);
//			}
			

			System.out.println(i + "회 결과 : " + strike + "스트라이크, " + ball + "볼, " + out + "아웃");

			// 3스트라이크일 경우 조건문을 강제로 빠져나감(i)
			if (strike == 3) {
				System.out.println("승리하셨습니다.");
				System.out.println();
				break;
			}

			System.out.println();
			System.out.println();

			// 값 초기화
			userList.clear();
			strike = 0;
			ball = 0;
			out = 0;
		}

		System.out.print("야구 게임 끝!!! 컴퓨터가 선택한 숫자는 ");

		for (int data : comList) {
			System.out.print(data + " ");
		}

		System.out.println("입니다.");
	}
}
