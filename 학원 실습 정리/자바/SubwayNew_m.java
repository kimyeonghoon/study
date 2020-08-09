import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SubwayNew_m {
	// 승객 목적지를 담아놓는 2차원 배열
	String[] destination = new String[16];
	// 역정보를 담고 있는 맵
	HashMap<Integer, String> station = new HashMap<Integer, String>();
	// 열차 방향 변수
	boolean directionFlag = true;
	// 현재 열차 위치
	int trainLocation = 0;
	// 스캐너
	Scanner sc = new Scanner(System.in);

	// 역정보 추가
	public void station() {
		station.put(0, "장숭백이");
		station.put(1, "연신내");
		station.put(2, "강남");
		station.put(3, "양재");
		station.put(4, "평택");
	}

	// 이동방향
	public void direction() {
		if (directionFlag) {
			trainLocation++;
		} else {
			trainLocation--;
		}
	}

	// 현재 역 정보
	public void stationInfo() {
		station();
		if (directionFlag) {
			System.out.println("[" + station.get(4) + "방면]" + station.get(trainLocation) + "역");
		} else {
			System.out.println("[" + station.get(1) + "방면]" + station.get(trainLocation) + "역");
		}
	}

	// 1호차
	public void train_one() {
		int seatcheck = 0;
		for (int i = 0; i < 3; i++) {
			if (destination[i] == null) {
				seatcheck++;
			} else {
				System.out.println("자리가 없습니다. 다른 차량을 이용해주세요.");
			}
		}
	}
	// 2호차
	public void train_two() {
		int seatcheck = 0;
		for (int i = 4; i < 7; i++) {
			if (destination[i] == null) {
				seatcheck++;
			} else {
				System.out.println("자리가 없습니다. 다른 차량을 이용해주세요.");
			}
		}
	}
	// 3호차
	public void train_three() {
		int seatcheck = 0;
		for (int i = 8; i < 11; i++) {
			if (destination[i] == null) {
				seatcheck++;
			} else {
				System.out.println("자리가 없습니다. 다른 차량을 이용해주세요.");
			}
		}
	}
	// 4호차
	public void train_four() {
		int seatcheck = 0;
		for (int i = 12; i < 15; i++) {
			if (destination[i] == null) {
				seatcheck++;
			} else {
				System.out.println("자리가 없습니다. 다른 차량을 이용해주세요.");
			}
		}
	}
}
