import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		
		int startValue = 1;
		int rangeCount = 45;

		
		// ArrayList 생성
		List<Integer> numList = new ArrayList<Integer>();
		
		Random r = new Random();
		
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 6 ; j++) {
				//  1 ~ 45까지의 랜덤숫자 구하기( 공식 - (int)Math.floor(랜덤 * 범위개수) + 시작값, 타입캐스팅하는 이유는 소수점 버리기 위해)
			//int pickNumber = (int)Math.floor(Math.random() * rangeCount) + startValue;
			int pickNumber = r.nextInt(45) + 1;
				
				// 이미 ArrayList에 선택한 값이 존재하는지 확인 후, 존재한다면 다시 뽑기
				if(numList.contains(pickNumber)) {
					j--;
					continue;
				}
				
				
				if(numList.contains(pickNumber)) {
					i--;
				} else {
					numList.add(pickNumber);	
				}
				
//				// 선택한 값 추가
//				numList.add(pickNumber);
				
				// 선택한 값 출력
				System.out.print(pickNumber + " ");
				
			}
			
			// 줄 바꾸기
			System.out.println();
			
			// ArrayList 초기화
			numList.clear();
			
		}
		
	}

}
