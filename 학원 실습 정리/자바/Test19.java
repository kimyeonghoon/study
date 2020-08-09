
public class Test19 {

	public static void main(String[] args) {

		int val = 315;
		
		for(int i = 2; i <= val ; i ++) {
			if(val % i == 0) {
				System.out.print(i + " ");
				val /= i;
				i--;
			}
			
		}
		
	}

}
