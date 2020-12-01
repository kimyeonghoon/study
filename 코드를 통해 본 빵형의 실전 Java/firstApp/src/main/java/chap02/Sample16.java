package chap02;

import java.util.Random;

/**
 * @author ioniere
 *
 */
public class Sample16 {
	/**
	 * @param args
	 * @since 1.0
	 */
	public static void main(String[] args) {
		Random random = new Random();
		int num = random.nextInt(3) + 1;
		System.out.printf("난수 : %d", num);
	}
}
