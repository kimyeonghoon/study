import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Book4 {
	Scanner sc = new Scanner(System.in);

	public void insertBook(List<HashMap<String, String>> list) {

		HashMap<String, String> book = new HashMap<String, String>();
		System.out.println("책번호를 입력해 주세요.");
		book.put("no", sc.nextLine());
		System.out.println("책제목를 입력해 주세요.");
		book.put("title", sc.nextLine());
		System.out.println("저자를 입력해 주세요.");
		book.put("writer", sc.nextLine());
		System.out.println("출판사를 입력해 주세요.");
		book.put("co", sc.nextLine());
		System.out.println("출간일를 입력해 주세요.");
		book.put("dt", sc.nextLine());

		list.add(book);
		System.out.println("등록되었습니다.");

	}

	public void orderList(List<HashMap<String, String>> list) {
		System.out.println("정렬순서를 입력해 주세요.");
		System.out.println("1. 오름차순 2. 내림차순");
		switch (sc.nextLine()) {
		case "1":
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (Integer.parseInt(list.get(i).get("no")) > Integer.parseInt(list.get(j).get("no"))) {
						HashMap<String, String> temp = list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}
				}
			}
			break;
		case "2":
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (Integer.parseInt(list.get(i).get("no")) < Integer.parseInt(list.get(j).get("no"))) {
						HashMap<String, String> temp = list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}
				}
			}
			break;
		default:
			System.out.println("잘못 입력하였습니다.");
		}
	}

	public void printList(List<HashMap<String, String>> list) {
		System.out.println("번호\t제목\t저자\t출판사\t출판일");
		System.out.println("-------------------------");
		for (HashMap<String, String> book : list) {
			System.out.println(book.get("no") + "\t" + book.get("title") + "\t" + book.get("writer") + "\t"
					+ book.get("co") + "\t" + book.get("dt"));
		}
	}

}
