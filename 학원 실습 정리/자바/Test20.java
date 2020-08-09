
public class Test20 {

	public static void main(String[] args) {
		
		// A a1 = new A();
		Test20P tp = new Test20P();
		
		// B b1 = new B();
		Test20C tc = new Test20C();
		
		tp.p();
		
		tc.c(); //c 메소드 호출(부모의 p 메소드 호출)
		tc.p(); // 오버라이딩된 p 메소드 호출
		
		// A a2 = new B(); 
		//부모선언 자식생성
		Test20P tp2 = new Test20C();
		tp2.p(); // 부모의 형태이지만 객체는 자식이기 때문에 자식의 메소드 실행
		
		// B b2 = new A();
		// 자식선언 부모생성 - 성립되지 않기에 에러 발생
		//Test20C tc2 = new Test20P();
		
		
	}

}
