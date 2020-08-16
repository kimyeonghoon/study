/**
 * 이 클래스는 cabbie(택시 기사) 한 명을 규정해  cab(택시) 한 대를 할당한다.
 */
public class Cabbie {

	// 회사 이름을 여기에 둔다.
	private static String companyName = "Blue Cab Company";
	
	// 택시 기사의 이름
	private String name;
	
	// 차 한 대를 기사에게 할당한다.
	private Cab myCab;
	
	// Cabbie에 대한 기본 생성자
	public Cabbie() {
		name = null;
		myCab = null;
		
	}
	
	// 이름을 가지고 Cabbie를 초기화해 쓸 수 있게 한 생성자
	public Cabbie(String iName, String serialNumber) {
		name = iName;
		myCab = new Cab(serialNumber);
	}
	
	// 택시 기사의 이름을 설정한다.
	public void setName(String iName) {
		name = iName;
	}
	
	// 택시 기사의 이름을 알아낸다.
	public String getName() {
		return name;
	}
	
	// 회사의 이름을 알아낸다.
	public String getCompanyName() {
		return companyName;
	}
	
	public void giveDestination() {
		
	}
	
	private void turnRight() {
		
	}
	
	private void turnLeft() {
		
	}
}
