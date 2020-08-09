import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Subways {
	Scanner sc = new Scanner(System.in);

	HashMap<String, Integer> stationNumber = new HashMap<String, Integer>();
	HashMap<Integer, String> stationName = new HashMap<Integer, String>();
	HashMap<String, Integer> trainPassenger = new HashMap<String, Integer>();
	List<HashMap<String, String>> passenger = new ArrayList<HashMap<String, String>>();
	HashMap<String, String> temp;

	int trainLocation;
	boolean reverse = false;
	String trainFor;

	// temp 변수 초기화
	public void tempMap() {
		temp = new HashMap<String, String>();
	}

	// 현재 역
	public void currentStation() {
		System.out.println("<" + trainFor() + ">\n[" + trainLocation + "]" + stationNum(trainLocation));
	}

	// 열차 진행 방향
	public String trainFor() {
		if (reverse) {
			trainFor = "장승백이방면";
		} else {
			trainFor = "평택방면";
		}
		return trainFor;
	}

	// 역의 이름으로 역번호 호출
	public int station(String stationName) {
		stationNumber.put("장승백이", 100);
		stationNumber.put("연신내", 101);
		stationNumber.put("강남", 102);
		stationNumber.put("양재", 103);
		stationNumber.put("평택", 104);
		return stationNumber.get(stationName);
	}

	// 역의 번호로 역의 이름 호출
	public String stationNum(int stationNum) {
		stationName.put(100, "장승백이");
		stationName.put(101, "연신내");
		stationName.put(102, "강남");
		stationName.put(103, "양재");
		stationName.put(104, "평택");
		return stationName.get(stationNum);
	}

	// 열차 위치 초기화(시작역 설정)
	public void trainStartStation() {
		trainLocation = station("장승백이");
	}

	// 마지막 역
	public int lastStation() {
		return station("평택");
	}

	public int firstStation() {
		return station("장승백이");
	}

	// 차량별 승객 수 최초(초기화)
	public void trainInit() {
		trainPassenger.put("1호차", 0);
		trainPassenger.put("2호차", 0);
		trainPassenger.put("3호차", 0);
		trainPassenger.put("4호차", 0);
	}

	// 차량별 승객 수(현재)
	public void trainNow() {
		int oneCur = 0;
		int twoCur = 0;
		int threeCur = 0;
		int fourCur = 0;

		for (int i = 0; i < passenger.size(); i++) {
			if (passenger.get(i).get("호차") == "1") {
				oneCur++;
			}
			if (passenger.get(i).get("호차") == "2") {
				twoCur++;
			}
			if (passenger.get(i).get("호차") == "3") {
				threeCur++;
			}
			if (passenger.get(i).get("호차") == "4") {
				fourCur++;
			}
		}

		System.out.print("1호차\t" + oneCur + "명 ");
		for (int i = 0; i < passenger.size(); i++) {
			if (passenger.get(i).get("호차") == "1")
				System.out.print(" : " + passenger.get(i).get("도착역") + " ");
			}
		System.out.println();
		
		System.out.print("2호차\t" + oneCur + "명");
		for (int i = 0; i < passenger.size(); i++) {
			if (passenger.get(i).get("호차") == "2")
				System.out.print(" : " + passenger.get(i).get("도착역") + " ");
			}
		System.out.println();
		
		System.out.print("3호차\t" + oneCur + "명");
		for (int i = 0; i < passenger.size(); i++) {
			if (passenger.get(i).get("호차") == "3")
				System.out.print(" : " + passenger.get(i).get("도착역") + " ");
			}
		System.out.println();
		
		System.out.print("4호차\t" + oneCur + "명");
		for (int i = 0; i < passenger.size(); i++) {
			if (passenger.get(i).get("호차") == "4")
				System.out.print(" : " + passenger.get(i).get("도착역") + " ");
			}
		System.out.println();
	}

	// 장승백이역
	public void js() {
		System.out.println("목적지를 선택해주세요.\n1.연신내 2.강남 3.양재 4.평택");
		switch (sc.nextLine()) {
		case "1":
			System.out.println("목적지는 연신내역입니다.");
			System.out.println();
			temp.put("도착역", "연신내");
			temp.put("거리", "1");
			seatSelect();
			break;
		case "2":
			System.out.println("목적지는 강남역입니다.");
			System.out.println();
			temp.put("도착역", "강남");
			temp.put("거리", "2");
			seatSelect();
			break;
		case "3":
			System.out.println("목적지는 양재역입니다.");
			System.out.println();
			temp.put("도착역", "양재");
			temp.put("거리", "3");
			seatSelect();
			break;
		case "4":
			System.out.println("목적지는 평택역입니다.");
			System.out.println();
			temp.put("도착역", "평택");
			temp.put("거리", "3");
			seatSelect();
			break;
		default:
			System.out.println("잘못 선택하셨습니다.");
		}
	}

	// 연신내역
	public void ys() {
		if (trainFor().equals("평택방면")) {
			System.out.println("목적지를 선택해주세요.\n1.강남 2.양재 3.평택");
			switch (sc.nextLine()) {
			case "1":
				System.out.println("목적지는 강남역입니다.");
				System.out.println();
				temp.put("도착역", "강남");
				temp.put("거리", "1");
				seatSelect();
				break;
			case "2":
				System.out.println("목적지는 양재역입니다.");
				System.out.println();
				temp.put("도착역", "양재");
				temp.put("거리", "2");
				seatSelect();
				break;
			case "3":
				System.out.println("목적지는 평택역입니다.");
				System.out.println();
				temp.put("도착역", "평택");
				temp.put("거리", "3");
				seatSelect();
				break;
			default:
				System.out.println("잘못 선택하셨습니다.");
			}
		} else if (trainFor().equals("장승백이방면")) {
			System.out.println("목적지는 장승백이역입니다.");
			System.out.println();
			temp.put("도착역", "장승백이");
			temp.put("거리", "1");
			seatSelect();
		}
	}

	// 강남역
	public void gn() {
		if (trainFor().equals("평택방면")) {
			System.out.println("목적지를 선택해주세요.\n1.양재 2.평택");
			switch (sc.nextLine()) {
			case "1":
				System.out.println("목적지는 양재역입니다.");
				System.out.println();
				temp.put("도착역", "양재");
				temp.put("거리", "1");
				seatSelect();
				break;
			case "2":
				System.out.println("목적지는 평택역입니다.");
				System.out.println();
				temp.put("도착역", "평택");
				temp.put("거리", "2");
				seatSelect();
				break;
			default:
				System.out.println("잘못 선택하셨습니다.");
			}
		} else if (trainFor().equals("장승백이방면")) {
			System.out.println("목적지를 선택해주세요.\n1.장승백이 2.연신내");
			switch (sc.nextLine()) {
			case "1":
				System.out.println("목적지는 장승백이역입니다.");
				System.out.println();
				temp.put("도착역", "장승백이");
				temp.put("거리", "2");
				seatSelect();
				break;
			case "2":
				System.out.println("목적지는 연신내역입니다.");
				System.out.println();
				temp.put("도착역", "연신내");
				temp.put("거리", "1");
				seatSelect();
				break;
			default:
				System.out.println("잘못 선택하셨습니다.");
			}
		}
	}

	// 양재역
	public void yj() {
		if (trainFor().equals("평택방면")) {
			System.out.println("목적지는 평택역입니다.");
			temp.put("도착역", "평택");
			temp.put("거리", "1");
			seatSelect();
		} else if (trainFor().equals("장승백이방면")) {
			System.out.println("목적지를 선택해주세요.\n1.장승백이 2.연신내 3.강남");
			System.out.println();
			switch (sc.nextLine()) {
			case "1":
				System.out.println("목적지는 장승백이역입니다.");
				temp.put("도착역", "장승백이");
				temp.put("거리", "3");
				seatSelect();
				break;
			case "2":
				System.out.println("목적지는 연신내역입니다.");
				System.out.println();
				temp.put("도착역", "연신내");
				temp.put("거리", "2");
				seatSelect();
				break;
			case "3":
				System.out.println("목적지는 강남역입니다.");
				System.out.println();
				temp.put("도착역", "강남");
				temp.put("거리", "1");
				seatSelect();
				break;
			default:
				System.out.println("잘못 선택하셨습니다.");
			}
		}
	}

	// 평택역
	public void pt() {
		System.out.println("목적지를 선택해주세요.\n1.장승백이 2.연신내 3.강남 4.양재");
		switch (sc.nextLine()) {
		case "1":
			System.out.println("목적지는 장승백이역입니다.");
			System.out.println();
			temp.put("도착역", "장승백이");
			temp.put("거리", "4");
			seatSelect();
			break;
		case "2":
			System.out.println("목적지는 연신내역입니다.");
			System.out.println();
			temp.put("도착역", "연신내");
			temp.put("거리", "3");
			seatSelect();
			break;
		case "3":
			System.out.println("목적지는 강남역입니다.");
			System.out.println();
			temp.put("도착역", "강남");
			temp.put("거리", "2");
			seatSelect();
			break;
		case "4":
			System.out.println("목적지는 양재역입니다.");
			System.out.println();
			temp.put("도착역", "양재");
			temp.put("거리", "1");
			seatSelect();
			break;
		default:
			System.out.println("잘못 선택하셨습니다.");
		}
	}

	// 목적지 선택
	public void destination() {
		if (trainLocation == 100) {
			temp.put("출발역", "장승백이");
			js();
		} else if (trainLocation == 101) {
			temp.put("출발역", "연신내");
			ys();
		} else if (trainLocation == 102) {
			temp.put("출발역", "강남");
			gn();
		} else if (trainLocation == 103) {
			temp.put("출발역", "양재");
			yj();
		} else if (trainLocation == 104) {
			temp.put("출발역", "평택");
			pt();
		}
	}

	//

	// 다음역으로 이동
	public void nextStation() {
		for (int i = 0; i < passenger.size(); i++) {
			int distance = Integer.parseInt(passenger.get(i).get("거리"));
			int nextStation = distance - 1;
			passenger.get(i).put(("거리"), Integer.toString(nextStation));
			if (nextStation <= 0) {
				passenger.remove(i);
			}
		}
		if (lastStation() == trainLocation) {
			reverse = true;
		} else if (firstStation() == trainLocation) {
			reverse = false;
		}

		if (trainFor() == "평택방면") {
			trainLocation = trainLocation + 1;
		} else if (trainFor() == "장승백이방면") {
			trainLocation = trainLocation - 1;
		}

	}

	// 승객 정보
	public void passengerInfo() {
		for (int i = 0; i < passenger.size(); i++) {
			System.out.println("승객 : " + passenger.get(i).get("출발역") + " -> " + passenger.get(i).get("도착역"));
		}
	}

	// 호차 선택
	public void seatSelect() {
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;

		for (int i = 0; i < passenger.size(); i++) {
			if (passenger.get(i).get("호차") == "1") {
				one++;
			}
			if (passenger.get(i).get("호차") == "2") {
				two++;
			}
			if (passenger.get(i).get("호차") == "3") {
				three++;
			}
			if (passenger.get(i).get("호차") == "4") {
				four++;
			}
		}

		System.out.println("탑승할 호차를 선택해주세요.[숫자]\n1.1호차 2.2호차 3.3호차 4.4호차");
		switch (sc.nextLine()) {
		case "1":
			if (one < 4) {
				System.out.println("1호차에 승차합니다.");
				temp.put("호차", "1");
				passenger.add(temp);
			} else {
				System.out.println("1호차에 탑승하실 수 없습니다.");
			}
			break;
		case "2":
			if (two < 4) {
				System.out.println("2호차에 승차합니다.");
				temp.put("호차", "2");
				passenger.add(temp);
			} else {
				System.out.println("2호차에 탑승하실 수 없습니다.");
			}
			break;
		case "3":
			if (three < 4) {
				System.out.println("3호차에 승차합니다.");
				temp.put("호차", "3");
				passenger.add(temp);
			} else {
				System.out.println("3호차에 탑승하실 수 없습니다.");
			}
			break;
		case "4":
			if (four < 4) {
				System.out.println("4호차에 승차합니다.");
				temp.put("호차", "4");
				passenger.add(temp);
			} else {
				System.out.println("4호차에 탑승하실 수 없습니다.");
			}
			break;
		default:
			System.out.println("잘못 선택하셨습니다.");
		}

	}

}