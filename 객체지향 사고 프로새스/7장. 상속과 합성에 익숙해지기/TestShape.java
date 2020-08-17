
public class TestShape {

	public static void main(String[] args) {

		Circle circle = new Circle();
		Rectangle rectangle = new Rectangle();
		Star star = new Star();
		Triangle triangle = new Triangle();
		/*		
			circle.draw();
			rectangle.draw();
			star.draw();
			triangle.draw();
		*/	
		
		drawMe(circle);
		drawMe(rectangle);
		drawMe(star);
		drawMe(triangle);
	}
	
	static void drawMe(Shape s) {
		s.draw();
	}
	
}
