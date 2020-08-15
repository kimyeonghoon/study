
public class Polymorphism {

	public static void main(String[] args) {
		
		Circle circle = new Circle(5);
		Rectangle rectangle = new Rectangle(4, 5);

		System.out.println("원 : " + circle.getArea());
		System.out.println("직사각형 : " + rectangle.getArea());
		
	}

}
