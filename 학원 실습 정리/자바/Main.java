import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		String reverseA = Integer.toString(A % 10) + Integer.toString((A / 10) % 10) + Integer.toString(A / 100);
		String reverseB = Integer.toString(B % 10) + Integer.toString((B / 10) % 10) + Integer.toString(B / 100);
		
		if(Integer.parseInt(reverseA) > Integer.parseInt(reverseB)) {
			System.out.println(Integer.parseInt(reverseA));
		} else {
			System.out.println(Integer.parseInt(reverseB));
		}
	}		
}