/*
 * 제이쿼리는 무엇인가 왜 나를 못살게 하나
 * 코딩은 나랑 맞긴 하나 진짜 킹받네~~~~~~~~~!
 * 해결이 되면 와 이러고, 안 되면 난 진짜 안 되는 놈이라고 우울감에 빠지게 하고 아주..못된 녀석이구나 이 새끼
 * 다른 사람들한테 민페 안 끼치고 싶단 말이야........정답을 알려줘..요놈아..
 * */




//로딩되면 목록이 출력되게 하기
$(document).ready(function() {
	
});








$(function() {
	let startCheck = false; //출근버튼 한 번만 클릭하도록 체크
	let endCheck = false; //퇴근버튼 한 번만 클릭하도록 체크
	
	$('#end-btn').prop("disabled", true); //왜 안 될까...^^
	
	// 출근 버튼 누르면 현재 시간 입력창에 출력
	$(document).on("click",'#start-btn',function(){
		
		//alert('오늘도 열심히!');
		confirm("출근");
		
		if (startCheck) { //체크 되어 있으면 실행X
			return check;
		} else {
			startCheck = true;
			//alert('오늘도 열심히!');
		}
		
	}); //start
	
	// 퇴근 버튼 누르면 현재 시간 입력창에 출력
	$('#end-btn').click(function(event){
		alert('수고하셨습니다.');
		confirm("퇴근");
		
		if (endCheck) { //체크 되어 있으면 콘솔 빈값으로 만들기
			startCheck = false;
			endCheck = false;
		} else {
			endCheck = true;
			
		}
	}); //end
	
	
}); //end system?


//1. 출근시간 버튼 클릭
//2. 퇴근시간 버튼 클릭






