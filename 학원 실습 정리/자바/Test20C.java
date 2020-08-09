//자식
public class Test20C extends Test20P {
	int b = 4;
	
	public void c() {
		
		//super -> 부모
		super.p();
		System.out.println("a : " + a);
	}
	
	
	@Override
	public void p() {
		System.out.println("오버라이딩된 메소드");
	}
}
