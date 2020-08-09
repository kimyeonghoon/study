import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Book {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		System.out.println("총 다섯 번 입력 받습니다.");

		for (int i = 0; i <= 5; i++) {
			HashMap<String, String> temp = new HashMap<String, String>();

			// System.out.print("책번호 : ");
			System.out.println((i + 1) + "회 : 책번호, 책이름, 저자, 출판일, 출판사를 입력해주세요. [공백으로 구분]");
			// 책번호
			temp.put("no", sc.next());
			// 책이름
			temp.put("bookName", sc.next());
			// 저자
			temp.put("author", sc.next());
			// 출판일
			temp.put("pubDate", sc.next());
			// 출판사
			temp.put("pubCompany", sc.nextLine());

			list.add(temp);
			System.out.println();
		}

		System.out.println();
		System.out.println();

		boolean typeCheck = true;

		String sortType;
		int sortCastInt = 0;

		while (typeCheck) {
			System.out.println("정렬 타입을 선택해주세요. : 1. 오름차순 2. 내림차순");

			sortType = sc.nextLine();
			sortCastInt = Integer.parseInt(sortType);

			if (sortCastInt == 1 || sortCastInt == 2) {
				typeCheck = false;
			} else {
				System.out.println("숫자를 다시 입력해주세요.");
			}
		}

		int compare1 = 0;
		int compare2 = 0;

		// 오름차순, 내림차순 선택
		if (sortCastInt == 1) {
			// 책 번호로 오름차순 정렬
			for (int i = 0; i < list.size() - 1; i++) {

				for (int j = list.size() - 1; j > i; j--) {
					compare1 = Integer.parseInt(list.get(i).get("no"));
					compare2 = Integer.parseInt(list.get(j).get("no"));

					if (compare1 > compare2) {
						list.add(list.get(i));
						list.remove(i);
					}
				}
			}
		} else if (sortCastInt == 2) {
			// 책번호로 내림차순 정렬
			for (int i = 0; i < list.size() - 1; i++) {

				for (int j = list.size() - 1; j > i; j--) {
					compare1 = Integer.parseInt(list.get(i).get("no"));
					compare2 = Integer.parseInt(list.get(j).get("no"));

					if (compare1 < compare2) {
						list.add(list.get(i));
						list.set(i, list.get(j));
						list.remove(j);
					}
				}
			}
		}

		// 출력
		System.out.println("책번호\t책이름\t저자\t출판일\t출판사");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(
					list.get(i).get("no") + "\t" + list.get(i).get("bookName") + "\t" + list.get(i).get("author") + "\t"
							+ list.get(i).get("pubDate") + "\t" + list.get(i).get("pubCompany"));
		}

	}

}
