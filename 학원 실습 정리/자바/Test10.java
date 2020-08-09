
public class Test10 {
	int a = 6;

	public static void main(String[] args) {
		int a = 7;
		String b = "123";
		
		System.out.println((float) a);
		
		System.out.println(Integer.toString(a) + 8);
		
		System.out.println(Integer.parseInt(b) + 1);
		
		String s = "Hello World!!";
		
		// 문자열.replace(찾을값, 바꿀값) : 모두바꿈
		System.out.println(s.replace("l", "k"));
		System.out.println(s.replaceAll("l", "k"));
		System.out.println(s.replaceAll("l", ""));
		// 문자열.replace(찾을값, 바꿀값) : 첫번째만 바꿈
		System.out.println(s.replaceFirst("l", "k"));
		System.out.println(s.replaceFirst("l", ""));
		// 문자열.indexOf(찾을값) : 값의 위치를 찾아준다. 찾는 값이 없을 경우 -1
		System.out.println(s.indexOf("1"));
		// 문자열.indexOf(찾을값, 시작위치) : 시작위치부터 값의 위치를 찾아준다.
		System.out.println(s.indexOf("l", 4));
		// indexOf : 오름차순(앞에서 뒤로) / lastIndexOf : 내림차순(뒤에서 앞으로)
		System.out.println(s.lastIndexOf("1"));
		System.out.println(s.lastIndexOf("l", 4));
		// 문자열.substring(위치) : 위치 이상의 문자열을 자른다.
		// 문자열.substring(위치1, 위치2) : 위치1 이상(포함)부터 위치2 미만(포함X)까지의 문자를 자른다.
		System.out.println(s.substring(2));
		System.out.println(s.substring(7, 10));
		// 문자열.length() : 문자열의 길이
		System.out.println(s.length());
		// 대문자화, 소문자화
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		
		String s2 = "가나다,라마바,사아자";
		// 문자열.split(구분자) : 구분자로 문자를 자르고 배열로 만듬
		String[] arr = s2.split(",");
		
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
		
		

	}

}
