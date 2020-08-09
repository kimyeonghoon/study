import java.util.HashMap;
import java.util.Random;

public class Blackjack {

	public static void main(String[] args) {
		Random r = new Random();
		// 딜러의 카드
		HashMap<Integer, Integer> dealer = new HashMap<Integer,Integer>();
		// 플레이어의 카드
		HashMap<Integer, Integer> player = new HashMap<Integer,Integer>();
		// 전체 카드 초기화
		int totalCard = 0;
		// 현재 남아 있는 카드 카운트하는 HashMap
		HashMap<Integer, Integer> curCard = new HashMap<Integer, Integer>();
		// 카드 초기화
		for (int i = 1; i < 10; i++) {
			curCard.put(i, 4);
		}
		curCard.put(10, 16);
		// 현재 남아있는 카드 장수
		for (int i = 1; i <= 10; i++) {
			totalCard += curCard.get(i);
		}
		// 게임 시작 - 딜러 카드 2장 받음
		for(int i = 0; i < 2; i++) {
			int count = 0;
			int selectCard = r.nextInt(10) + 1;
			if (curCard.get(selectCard) > 0) {
				dealer.put(selectCard, selectCard);
				curCard.put(selectCard, curCard.get(selectCard) - 1);
				count++;
			} else {
				i--;
			}
		}
		// 플레이어 카드 2장 받음
		for(int i = 0; i < 2; i++) {
			int count = 0;
			int selectCard = r.nextInt(10) + 1;
			if (curCard.get(selectCard) > 0) {
				player.put(selectCard, selectCard);
				curCard.put(selectCard, curCard.get(selectCard) - 1);
				count++;
			} else {
				i--;
			}
		}
		// 현재 남아있는 카드 카운트
		System.out.println("현재 남아 있는 카드 카운트");
		for (int i = 1; i < curCard.size() + 1; i++) {
			System.out.println(i + " - " + curCard.get(i) + "장");
		}
	}

}
