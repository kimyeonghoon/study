import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Baseball2 {

	public static void main(String[] args) {

		int[] computerNumber = new int[3];
		List<Integer> userNumber = new ArrayList<Integer>();
		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		computerNumber[0] = r.nextInt(10);
		
		for (int i = 0; i < computerNumber.length - 1; i++) {
			
			for (int j = i + 1; j < computerNumber.length; j++) {
				int number = r.nextInt(10);
				if (computerNumber[i] == computerNumber[j]) {
					i--;
				} else {
					computerNumber[j] = number;
				}
			}
		}
		
		for(int i = 0; i < computerNumber.length; i++) {
			System.out.print(computerNumber[i] + " ");
		}

	}

}
