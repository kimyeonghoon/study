
public class Test18 {

	public static void main(String[] args) {

		int[] arr = {28, 19, 87, 66, 45, 6, 79, 30, 96, 33};
		int t = 57;
		int res = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			int cha1 = res - t;
			int cha2 = arr[i] - t;
			if(cha1 < 0) {
				cha1 *= -1;
			}
			if(cha2 < 0) {
				cha2 *= -1;
			}
			if(cha1 > cha2) {
				res = arr[i];
			}
			
		}
		System.out.println(res);
	}

}
