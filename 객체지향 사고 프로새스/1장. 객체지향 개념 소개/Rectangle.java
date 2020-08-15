
public class Rectangle extends Shape {

	
	double length;
	double width;
	
	public Rectangle(double l, double w) {
		length = l;
		width = w;
	}
	
	@Override
	public double getArea() {
		area = length * width;
		return (area);
	}

}
