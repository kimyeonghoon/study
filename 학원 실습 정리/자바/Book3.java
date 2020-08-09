import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Book3 {

	public static void main(String[] args) {
		// 리스트 생성
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		Scanner sc = new Scanner(System.in);
		Book4 s = new Book4();

		// 메뉴 출력
		while (true) {
			System.out.println("메뉴를 입력해주세요.");
			System.out.println("1.등록  2.정렬  3.출력  4.종료");
			boolean endFlag = false;

			switch (sc.nextLine()) {
			// 등록
			case "1":
				s.insertBook(list);
				break;
			// 정렬
			case "2":
				s.orderList(list);
				break;
			// 출력
			case "3":
				s.printList(list);
				break;
			// 종료
			case "4":
				endFlag = true;
				break;
			default:
				System.out.println("잘못 입력 하셨습니다.");
			}
			if (endFlag) {
				System.out.println("종료합니다.");
				break;
			}
		}
	}
}
