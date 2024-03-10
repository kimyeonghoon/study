#include <stdio.h> // 헤더 파일 선언 

/*
목적: Hello World 출력
기능: 문자열 출력
 
int main(void) {
	
	printf("Hello World\n\n\n");
	
	return 0;
	
}
*/

/*
int main(void) // main 함수 시작 
{
	printf("홍길동\n홍 길 동\n홍  길  동\n"); // 문자열 출력 
	return 0; // 0 반환 
} // main 함수 종료
*/
/*
int main(void) {
	printf("hello world!\n");
	printf("%d \n", 1234); // 서식문자 %d 
	printf("%d %d \n", 10, 20); 
	return 0;
} 
*/
/*
int main(void) {
	printf("My age: %d \n", 20);
	printf("%d is my porint \n", 100);
	printf("Good \nmoring \neverybody\n");
	return 0;
}
*/

/*
본인의 이름, 주소, 그리고 전화번호를 모니터에 출력하는 프로그램을 작성해보시오. 총 3번의 printf함수를 호출해야 합니다.

int main(void) {
	printf("이름: 홍길동\n");
	printf("주소: 서울 강북구 솔매로 49길 60 (미아동)\n");
	printf("전화번호: 02) 944-5000");
	return 0; 
} 
*/

/*
다음의 출력 결과를 보이도록 프로그램을 작성해보자. 단, 출력되는 숫자들은 서식문자 %d를 이용하여 출력해야 함

int main(void){
	printf("제 이름은 홍길동입니다.\n");
	printf("제 나이는 %d살이고요.\n", 20);
	printf("제가 사는 곳의 번지수는 %d-%d입니다.\n", 123, 456);
	return 0;
}
*/ 

/*
다음의 출력 결과를 보이도록 프로그램을 작성해보자. 출력되는 숫자들은 서식문자 %d를 이용하여 출력하도록 하자.
*/
int main(void) {
	printf("%d x %d = %d\n", 4, 5, 20);
	printf("%d x %d = %d\n", 7, 9, 63);
	return 0;
} 
