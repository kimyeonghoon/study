
public class Test17 {

	public static void main(String[] args) {
		
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			int fact = 1;
			
			for(int j = 2; j <= i; j++) {
				fact *= j;
			}
			
			sum += fact;
			
		}
		System.out.println(sum);
	}

}
