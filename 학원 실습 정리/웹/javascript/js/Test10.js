/**
 * 
 */
function goBack() {
	// history.back() : 이전 페이지로 이동. 일반적으로는 history.back을 많이 씀
	// history.back();
	// history.go(숫자) : 숫자만큼 이동했던 페이지 이동
	history.go(-1);
}

function a() {
	// confirm(값) : 경고창을 통하여 값을 출력하며, 확인, 취소 버튼을 제공한다.
	// 				 버튼을 통하여 결과를 boolean으로 받는다.
	// 옛날 방식
	if(confirm("Hello?")) {
		alert("Yes!");
	} else {
		alert("No~~~~!");
	}
}