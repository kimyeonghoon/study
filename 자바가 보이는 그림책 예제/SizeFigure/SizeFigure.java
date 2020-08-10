package SizeFigure;

public class SizeFigure {

	public static void main(String[] args) {
		Figure fig1 = new Square(2.5);
		Figure fig2 = new Square(2.3, 3.7);
		Figure fig3 = new Circle(3.6);
		
		fig1.measure();
		fig2.measure();
		fig3.measure();
	}

}
