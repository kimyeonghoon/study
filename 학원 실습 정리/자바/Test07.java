
public class Test07 {

	public static void main(String[] args) {
		for(int i = 0 ; i <= 4 ; i++) {
			for(int j = 0 ; j <= 4; j++) {
				System.out.println("i : " + i + ", j : " + j);
			}
		}


		int a = 0;
		for(int i = 2 ; i < 10 ; i++) {
			for(int j = 1 ; j < 10 ; j++) {
			a = i * j;	
				System.out.println(i + " * " + j + " = " + a);
			}
		}
	
	
		/*
		 *   *****
		 *   *****
		 *   *****
		 *   *****
		 *   *****
		 */
		
		for(int i = 0 ; i <= 4 ; i++) {
			for(int j = 0 ; j <= 4; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	
		
		/*
		 *   *
		 *   **
		 *   ***
		 *   ****
		 *   *****
		 */
		
		
		for(int i = 0 ; i <= 4 ; i++) {
			for(int j = 0 ; j <= i ; j++) {
				System.out.print("*");		
			}
			System.out.println();
		}

		
		/*
		 *   *****
		 *   ****
		 *   ***
		 *   **
		 *   *
		 */
		
		
		for(int i = 0 ; i <= 4 ; i++) {
			for(int j = i ; j <= 4 ; j++) {
				System.out.print("*");		
			}
			System.out.println();
		}
		
		
	    /*
	     *  	*
	     	   **
	     	  ***
	     	 ****
	     	*****
	     */
		
		for(int i = 0 ; i <= 4 ; i++) {
			// 공백
			for(int j = 0 ; j < 4 - i ; j++) {
				System.out.print("□");
			}
			// 별
			for(int j = 0 ; j <= i ; j++) {
				System.out.print("*");
			}
			// 줄바꿈
			System.out.println();
		}		
		
		for(int i = 0 ; i <= 4 ; i++) {
			for(int j = 0 ; j <= 4 ; j++) {
				if(j < 4 - i) {
					System.out.print("□");	
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}	
			
		
		
		
		/*
		  
		 *****
		 ****
		 ***
		 **
		 * 
		 
		 */
		
		
		for(int i = 0 ; i <= 4 ; i++) {
			for(int j = 0 ; j <= i - 1 ; j++) {
				System.out.print(" ");
			}
			for(int k = i ; k <= 4 ; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*
		     	*
		       ***
		      *****
		     *******
		    *********
		 
		 */
		
		for(int i = 0 ; i <= 4 ; i++) {
			for(int j = 0 ; j < 4 - i ; j++) {
				System.out.print(" ");
			}
			for(int j = 0 ; j <= i ; j++) {
				System.out.print("*");
			}
			for(int j = 0 ; j <= i - 1 ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*
		 		*********
		 		 *******
		 		  *****	
		 		   ***
		 			*
		 */
		
		for(int i = 0 ; i <= 4 ; i++) {
			for(int j = 0 ; j <= i  ; j++) {
				System.out.print(" ");		
			}

			for(int j = i ; j <= 4  ; j++) {
				System.out.print("*");		
			}
			for(int j = i; j <= 3 ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		/*
     		*
	       ***
	      *****
	     *******
	    *********
		 *******
		  *****	
		   ***
			*
		*/
		
		for(int i = 0 ; i <= 4 ; i++) {
			for(int j = 0 ; j < 4 - i ; j++) {
				System.out.print(" ");
			}
			
			for(int j = 0 ; j <= i ; j++) {
				System.out.print("*");
			}
			
			for(int j = 0 ; j <= i - 1 ; j++) {
				System.out.print("*");	
			}			
			
			System.out.println();
		}

		for(int i = 0 ; i <= 3 ; i++) {
			for(int j = 0 ; j <= i  ; j++) {
				System.out.print(" ");		
			}

			for(int j = i ; j <= 3 ; j++) {
				System.out.print("*");		
			}
			
			for(int j = i; j <= 2 ; j++) {
				System.out.print("*");
				
			}
			System.out.println();
		}
		
		
		for(int i = 0 ; i <= 4 ; i++) {
			for(int j = 0 ; j <= 4 ; j++) {
				if(j < 4 - i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			for(int j = 0 ; j <= 9 ; j++) {
				if(j <= i - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			
			
			System.out.println();
		}
		

		// j < 4 -1, j > 4 + i, j < i - 4, j >= 13 - i
		for (int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				if(j < 4 - i || j > 4 + i || j < i - 4 || j >= 13 - i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
		int size = 7;
		int center = size / 2;
//		int s = -1 + (size % 2);
		for (int i = 0 ; i < size ; i++) {
			for(int j = 0 ; j < size ; j++) {
				//if(j < center + s - i || j > center + i || j < i - center || j >= size + center - i) {
				if(j < center - i || j > center + i || j < i - center || j >= size + center - i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
	
	}
}


