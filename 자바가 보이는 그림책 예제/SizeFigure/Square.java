package SizeFigure;

public class Square extends Figure {
	double side;
	double height;
	
	Square(double s) {
		side = height = s;
	}

	Square(double s, double h) {
		side = s;
		height = h;
	}
	
	@Override
	void area() {
		System.out.println("사각형의 면적 : " + (side * height));
	}

	@Override
	void around() {
		System.out.println("사각형의 둘레 : " + (2 * (side + height)));
	}
}
