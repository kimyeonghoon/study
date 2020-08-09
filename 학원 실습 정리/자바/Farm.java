
public class Farm {

	public static void main(String[] args) {
		Farms f = new Farms();
		
		
		// 농지 초기화
		f.landInit();
		System.out.println("농지가 초기화되었습니다. 현재 농지의 크기는 " + f.land + "입니다.");
		
		// 농지 확장 테스트
		f.expansion30Buy(30);
		System.out.println("농지가 확장되었습니다. 현재 농지의 크기는 " + f.land + "입니다.");
		
		// 구매 테스트
		f.riceBuy();
		f.barleyBuy();
		f.pumpkinBuy();
		f.potatoBuy();
		
		// 쌀 정상적으로 구매되었는지 확인
		System.out.println(f.cropsList.get(0).get("판매금액"));
		
		f.sprinkler();
		
		
		for( int i = 0; i < f.cropsList.size(); i++) {
		System.out.println(f.cropsList.get(i).get("성장기간"));
		}
	}

}
