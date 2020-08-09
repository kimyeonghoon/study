import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Stocks {

	// 주가를 담아놓는 리스트
	List<HashMap<String, String>> stocks = new ArrayList<HashMap<String, String>>();

	// 주가변동수치를 담아놓는 리스트
	List<HashMap<String, String>> changePrice = new ArrayList<HashMap<String, String>>();

	// 거래내역을 담아놓는 리스트
	List<HashMap<String, String>> transaction = new ArrayList<HashMap<String, String>>();

	// 자본금
	double money;

	// 현재자본금 조회
	public void capital() {
		System.out.println("자본금 : " + money + "원");
	}

	// 초기화
	public void stockInit() {
		// 아시아나 1000
		HashMap<String, String> asiana = new HashMap<String, String>();
		asiana.put("종목명", "아시아나");
		asiana.put("주가", "1000");
		asiana.put("등락률", "0");
		asiana.put("보유수", "0");
		stocks.add(asiana);
		// 삼성 3000
		HashMap<String, String> samsung = new HashMap<String, String>();
		samsung.put("종목명", "삼성");
		samsung.put("주가", "3000");
		samsung.put("등락률", "0");
		samsung.put("보유수", "0");
		stocks.add(samsung);
		// 구디 50
		HashMap<String, String> gudi = new HashMap<String, String>();
		gudi.put("종목명", "구디");
		gudi.put("주가", "50");
		gudi.put("등락률", "0");
		gudi.put("보유수", "0");
		stocks.add(gudi);
		// LG 2900
		HashMap<String, String> lg = new HashMap<String, String>();
		lg.put("종목명", "LG");
		lg.put("주가", "2900");
		lg.put("등락률", "0");
		lg.put("보유수", "0");
		stocks.add(lg);
		// 구글 5000
		HashMap<String, String> google = new HashMap<String, String>();
		google.put("종목명", "구글");
		google.put("주가", "5000");
		google.put("등락률", "0");
		google.put("보유수", "0");
		stocks.add(google);
		// 업비트 100
		HashMap<String, String> upbit = new HashMap<String, String>();
		upbit.put("종목명", "업비트");
		upbit.put("주가", "100");
		upbit.put("등락률", "0");
		upbit.put("보유수", "0");
		stocks.add(upbit);
		// 아마존 3000
		HashMap<String, String> amazon = new HashMap<String, String>();
		amazon.put("종목명", "아마존");
		amazon.put("주가", "3000");
		amazon.put("등락률", "0");
		amazon.put("보유수", "0");
		stocks.add(amazon);
		// 넥슨 500
		HashMap<String, String> nexon = new HashMap<String, String>();
		nexon.put("종목명", "넥슨");
		nexon.put("주가", "1000");
		nexon.put("등락률", "0");
		nexon.put("보유수", "0");
		stocks.add(nexon);
		// 초기 자본금
		money = 500;
	}

	// 다음날 등락률 반영
	public void nextDay() {
		HashMap<String, String> priceAdd = new HashMap<String, String>();
		System.out.println("종목명\t주가\t등락률");
		System.out.println("======================");
		for (int i = 0; i < stocks.size(); i++) {
			double r = Math.round(Math.random() * 10 - 5) / 100.0;
			String oldPrice = stocks.get(i).get("주가");
			double temp = Double.parseDouble(oldPrice);
			long getPrice = Math.round(temp + (r * temp));

			stocks.get(i).put("주가", Long.toString(getPrice));
			stocks.get(i).put("등락률", Double.toString(r));

			System.out.println(
					stocks.get(i).get("종목명") + "\t" + stocks.get(i).get("주가") + "\t" + stocks.get(i).get("등락률") + "%");

			priceAdd.put(stocks.get(i).get("종목명"), stocks.get(i).get("주가"));
		}
		changePrice.add(priceAdd);
		if (changePrice.size() > 5) {
			changePrice.remove(0);
		}
	}

	// 종목별 최근 5일간 수치 보기
	public void recentPrice() {
		System.out.println("종목명\t금일\t1일전\t2일전\t3일전\t4일전");
		System.out.println("=============================================");

		for (int i = 0; i < stocks.size(); i++) {
			System.out.print(stocks.get(i).get("종목명") + "\t");
			for (int j = 0; j < changePrice.size(); j++) {
				System.out.print(changePrice.get(j).get(stocks.get(i).get("종목명")) + "\t");
			}
			System.out.println();
		}
	}

	// 주식 구매 - 아시아나
	public void buyAsiana() {

		double buyPrice = Double.parseDouble(stocks.get(0).get("주가"));
		int curStock = Integer.parseInt(stocks.get(0).get("보유수"));

		if (money > buyPrice) {
			stocks.get(0).put("보유수", Integer.toString(curStock + 1));
			money -= buyPrice * 1.013;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "구매");
			temp.put("종목", "아시아나");
			temp.put("거래가", Double.toString(buyPrice));
			temp.put("수수료", Double.toString((buyPrice) * 0.013));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);

		} else {
			System.out.println("돈이 부족합니다.");
		}
	}

	// 주식 구매 - 삼성
	public void buySamsung() {
		double buyPrice = Double.parseDouble(stocks.get(1).get("주가"));
		int curStock = Integer.parseInt(stocks.get(1).get("보유수"));

		if (money > buyPrice) {
			stocks.get(1).put("보유수", Integer.toString(curStock + 1));
			money -= buyPrice * 1.013;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "구매");
			temp.put("종목", "삼성");
			temp.put("거래가", Double.toString(buyPrice));
			temp.put("수수료", Double.toString((buyPrice) * 0.013));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);
		} else {
			System.out.println("돈이 부족합니다.");
		}
	}

	// 주식 구매 - 구디
	public void buyGudi() {
		double buyPrice = Double.parseDouble(stocks.get(2).get("주가"));
		int curStock = Integer.parseInt(stocks.get(2).get("보유수"));

		if (money > buyPrice) {
			stocks.get(2).put("보유수", Integer.toString(curStock + 1));
			money -= buyPrice * 1.013;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "구매");
			temp.put("종목", "구디");
			temp.put("거래가", Double.toString(buyPrice));
			temp.put("수수료", Double.toString((buyPrice) * 0.013));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);
		} else {
			System.out.println("돈이 부족합니다.");
		}
	}

	// 주식 구매 - LG
	public void buyLG() {
		double buyPrice = Double.parseDouble(stocks.get(3).get("주가"));
		int curStock = Integer.parseInt(stocks.get(3).get("보유수"));

		if (money > buyPrice) {
			stocks.get(3).put("보유수", Integer.toString(curStock + 1));
			money -= buyPrice * 1.013;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "구매");
			temp.put("종목", "LG");
			temp.put("거래가", Double.toString(buyPrice));
			temp.put("수수료", Double.toString((buyPrice) * 0.013));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);
		} else {
			System.out.println("돈이 부족합니다.");
		}
	}

	// 주식 구매 - 구글
	public void buyGoogle() {
		double buyPrice = Double.parseDouble(stocks.get(4).get("주가"));
		int curStock = Integer.parseInt(stocks.get(4).get("보유수"));

		if (money > buyPrice) {
			stocks.get(4).put("보유수", Integer.toString(curStock + 1));
			money -= buyPrice * 1.013;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "구매");
			temp.put("종목", "구글");
			temp.put("거래가", Double.toString(buyPrice));
			temp.put("수수료", Double.toString((buyPrice) * 0.013));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);
		} else {
			System.out.println("돈이 부족합니다.");
		}
	}

	// 주식 구매 - 업비트
	public void buyUpbit() {
		double buyPrice = Double.parseDouble(stocks.get(5).get("주가"));
		int curStock = Integer.parseInt(stocks.get(5).get("보유수"));

		if (money > buyPrice) {
			stocks.get(5).put("보유수", Integer.toString(curStock + 1));
			money -= buyPrice * 1.013;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "구매");
			temp.put("종목", "업비트");
			temp.put("거래가", Double.toString(buyPrice));
			temp.put("수수료", Double.toString((buyPrice) * 0.013));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);
		} else {
			System.out.println("돈이 부족합니다.");
		}
	}

	// 주식 구매 - 아마존
	public void buyAmazon() {
		double buyPrice = Double.parseDouble(stocks.get(6).get("주가"));
		int curStock = Integer.parseInt(stocks.get(6).get("보유수"));

		if (money > buyPrice) {
			stocks.get(6).put("보유수", Integer.toString(curStock + 1));
			money -= buyPrice * 1.013;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "구매");
			temp.put("종목", "아마존");
			temp.put("거래가", Double.toString(buyPrice));
			temp.put("수수료", Double.toString((buyPrice) * 0.013));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);
		} else {
			System.out.println("돈이 부족합니다.");
		}
	}

	// 주식 구매 - 넥슨
	public void buyNexon() {
		double buyPrice = Double.parseDouble(stocks.get(7).get("주가"));
		int curStock = Integer.parseInt(stocks.get(7).get("보유수"));

		if (money > buyPrice) {
			stocks.get(7).put("보유수", Integer.toString(curStock + 1));
			money -= buyPrice * 1.013;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "구매");
			temp.put("종목", "넥슨");
			temp.put("거래가", Double.toString(buyPrice));
			temp.put("수수료", Double.toString((buyPrice) * 0.013));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);
		} else {
			System.out.println("돈이 부족합니다.");
		}
	}

	// 주식 판매 - 아시아나
	public void sellAsiana() {
		double sellPrice = Double.parseDouble(stocks.get(0).get("주가"));
		int curStock = Integer.parseInt(stocks.get(0).get("보유수"));

		if (curStock > 0) {
			stocks.get(0).put("보유수", Integer.toString(curStock - 1));
			money += sellPrice * 1.021;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "판매");
			temp.put("종목", "아시아나");
			temp.put("거래가", Double.toString(sellPrice));
			temp.put("수수료", Double.toString((sellPrice) * 0.021));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);

		} else {
			System.out.println("판매할 주식이 없습니다.");
		}
	}

	// 주식 판매 - 삼성
	public void sellSamsung() {
		double sellPrice = Double.parseDouble(stocks.get(1).get("주가"));
		int curStock = Integer.parseInt(stocks.get(1).get("보유수"));

		if (curStock > 0) {
			stocks.get(1).put("보유수", Integer.toString(curStock - 1));
			money += sellPrice * 1.021;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "판매");
			temp.put("종목", "아시아나");
			temp.put("거래가", Double.toString(sellPrice));
			temp.put("수수료", Double.toString((sellPrice) * 0.021));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);
		} else {
			System.out.println("판매할 주식이 없습니다.");
		}
	}

	// 주식 판매 - 구디
	public void sellGudi() {
		double sellPrice = Double.parseDouble(stocks.get(2).get("주가"));
		int curStock = Integer.parseInt(stocks.get(2).get("보유수"));

		if (curStock > 0) {
			stocks.get(2).put("보유수", Integer.toString(curStock - 1));
			money += sellPrice * 1.021;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "판매");
			temp.put("종목", "구디");
			temp.put("거래가", Double.toString(sellPrice));
			temp.put("수수료", Double.toString((sellPrice) * 0.021));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);
		} else {
			System.out.println("판매할 주식이 없습니다.");
		}

	}

	// 주식 판매 - LG
	public void sellLG() {
		double sellPrice = Double.parseDouble(stocks.get(3).get("주가"));
		int curStock = Integer.parseInt(stocks.get(3).get("보유수"));

		if (curStock > 0) {
			stocks.get(3).put("보유수", Integer.toString(curStock - 1));
			money += sellPrice * 1.021;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "판매");
			temp.put("종목", "LG");
			temp.put("거래가", Double.toString(sellPrice));
			temp.put("수수료", Double.toString((sellPrice) * 0.021));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);
		} else {
			System.out.println("판매할 주식이 없습니다.");
		}
	}

	// 주식 판매 - 구글
	public void sellGoogle() {
		double sellPrice = Double.parseDouble(stocks.get(4).get("주가"));
		int curStock = Integer.parseInt(stocks.get(4).get("보유수"));
		if (curStock > 0) {
			stocks.get(4).put("보유수", Integer.toString(curStock - 1));
			money += sellPrice * 1.021;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "판매");
			temp.put("종목", "구글");
			temp.put("거래가", Double.toString(sellPrice));
			temp.put("수수료", Double.toString((sellPrice) * 0.021));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);
		} else {
			System.out.println("판매할 주식이 없습니다.");
		}

	}

	// 주식 판매 - 업비트
	public void sellUpbit() {
		double sellPrice = Double.parseDouble(stocks.get(5).get("주가"));
		int curStock = Integer.parseInt(stocks.get(5).get("보유수"));
		if (curStock > 0) {
			stocks.get(5).put("보유수", Integer.toString(curStock - 1));
			money += sellPrice * 1.021;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "판매");
			temp.put("종목", "업비트");
			temp.put("거래가", Double.toString(sellPrice));
			temp.put("수수료", Double.toString((sellPrice) * 0.021));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);
		} else {
			System.out.println("판매할 주식이 없습니다.");
		}
	}

	// 주식 판매 - 아마존
	public void sellAmazon() {
		double sellPrice = Double.parseDouble(stocks.get(6).get("주가"));
		int curStock = Integer.parseInt(stocks.get(6).get("보유수"));
		if (curStock > 0) {
			stocks.get(6).put("보유수", Integer.toString(curStock - 1));
			money += sellPrice * 1.021;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "판매");
			temp.put("종목", "아마존");
			temp.put("거래가", Double.toString(sellPrice));
			temp.put("수수료", Double.toString((sellPrice) * 0.021));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);
		} else {
			System.out.println("판매할 주식이 없습니다.");
		}
	}

	// 주식 판매 - 넥슨
	public void sellNexon() {
		double sellPrice = Double.parseDouble(stocks.get(7).get("주가"));
		int curStock = Integer.parseInt(stocks.get(7).get("보유수"));
		if (curStock > 0) {
			stocks.get(7).put("보유수", Integer.toString(curStock - 1));
			money += sellPrice * 1.021;

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("구분", "판매");
			temp.put("종목", "넥슨");
			temp.put("거래가", Double.toString(sellPrice));
			temp.put("수수료", Double.toString((sellPrice) * 0.021));
			temp.put("잔액", Double.toString(money));
			transaction.add(temp);
		} else {
			System.out.println("판매할 주식이 없습니다.");
		}
	}

	// 현재 보유 주식 조회
	public void holdStock() {
		System.out.println("종목명\t보유수");
		System.out.println("============");
		for (int i = 0; i < stocks.size(); i++) {
			System.out.println(stocks.get(i).get("종목명") + "\t" + stocks.get(i).get("보유수") + "주");
		}
	}

	// 거래내역 조회
	public void transaction() {
		System.out.println("구분\t종목\t거래가\t수수료\t잔액");
		System.out.println("============");

		for (int i = 0; i < transaction.size(); i++) {
			System.out.println(transaction.get(i).get("구분") + "\t" + transaction.get(i).get("종목") + "\t"
					+ transaction.get(i).get("거래가") + "\t" + transaction.get(i).get("수수료") + "\t" + transaction.get(i).get("잔액"));
		}
	}

}
