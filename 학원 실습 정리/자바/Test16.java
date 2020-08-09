
public class Test16 {

	public static void main(String[] args) {
		//소수 카운트
		int so = 0;
		
		for(int i = 2; i <= 100; i++) {
			//검증 카운트
			int check = 0;
			
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					check++;
					break;
				}
				
				
			}
			if(check == 0) {
				System.out.print(i + " ");
				so++;
			}
			
		}
		System.out.println(so);
	}

}
