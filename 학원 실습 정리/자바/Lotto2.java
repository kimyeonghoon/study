import java.util.Random;

public class Lotto2 {

	public static void main(String[] args) {

		Random r = new Random();
		
		for(int k = 0 ; k < 5 ; k++) {
			int[] arr = new int[6];
			
			for(int i = 0 ; i < 6 ; i++) {
				boolean check = true;
				int num = r.nextInt(45) + 1;

				for(int j = 0 ; j < i ; j++) {
					if(num == arr[j]) {
						check = false;
						break;
					}
				}
				
				if(check) {
					arr[i] = num;
				} else {
					i--;
				}
				
			}
			
			for(int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
	
		}
	}
}
