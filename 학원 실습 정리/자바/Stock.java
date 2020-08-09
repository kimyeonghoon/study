import java.util.Scanner;

//모의 주식 투자. 초기자본금 500
//기본데이터 - 총 8개의 종목
//하루에 한 번 날이 바뀔 때 등락률 적용(랜덤 -5.00% ~ 5.00%)
//구매시 수수료 0.13%, 판매시 0.21%를 적용.
//해당 종목 상세정보 조회시 최근 5일간 수치를 보여줌.
//거래내역 조회, 현재 보유 주식 조회
//
//
//
//종목명		초기값
//아시아나		1000
//삼성		3000
//구디		50
//LG		2900
//구글		5000
//업비트		100
//아마존		3000
//넥슨		500



public class Stock {

	public static void main(String[] args) {
		
		Stocks st = new Stocks();
		
		st.stockInit();
		
		
		System.out.println("종목명\t주가\t등락률");
		System.out.println("======================");
		for(int i = 0; i < st.stocks.size(); i++) {
			System.out.println(st.stocks.get(i).get("종목명") + "\t" + st.stocks.get(i).get("주가") + "\t" + st.stocks.get(i).get("등락률") + "%");
		}
		
		System.out.println();

		
		
		Scanner sc = new Scanner(System.in);

		
		while (true) {
			boolean endFlag = false;
			System.out.println("구매할 주식을 선택해주세요.");
			System.out.println("1.아시아나 2.삼성 3.구디 4.LG 5.구글 6.업비트 7.아마존 8.넥슨");
			switch (sc.nextLine()) {
			case "1": 
				st.buyAsiana();
				break;
			case "2":
				st.buySamsung();
				break;
			case "3":
				st.buyGudi();
				break;
			case "4":
				st.buyLG();
				break;
			case "5":
				st.buyGoogle();
				break;
			case "6":
				st.buyUpbit();
				break;
			case "7":
				st.buyAmazon();
				break;
			case "8":
				st.buyNexon();
				break;
			default:
				System.out.println("잘못 선택하셨습니다.");
			}
			if (endFlag = true) {
				break;
			}
		}
		
		

		
		st.buyGudi();
		
		st.buyGudi();
		st.buyGudi();
		st.buyGudi();
		st.buyUpbit();
		st.buyUpbit();
		st.buyUpbit();
		st.buyUpbit();
		
		st.nextDay();
		st.sellUpbit();
		st.sellUpbit();

		
		st.recentPrice();
		
		st.holdStock();
		
		st.capital();
		

		
		st.transaction();
		
		st.holdStock();
		
		
	}
	
	
}


