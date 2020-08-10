package SizeFigure;

public class Circle extends Figure {

	final double pi = 3.14;
	double radius;
	
	Circle(double r) {
		radius = r;
	}
	
	@Override
	void area() {
		System.out.println("원의 면적" + (radius * radius * pi));
	}

	@Override
	void around() {
		System.out.println("원의 둘레" + (2 * radius * pi));
	}
}
