/*제이쿼리 공부하기*/

$(function() {
	let startCheck = false; //출근버튼 한 번만 클릭하도록 체크
	let endCheck = false; //퇴근버튼 한 번만 클릭하도록 체크
	
	//$('#end-btn').prop("disabled", true); //왜 안 될까...^^
	
	
	// 출근 버튼 누르면 현재 시간 입력창에 출력
	$(document).on("click",'#start-btn',function(event){
		event.preventDefault();
		
		alert('오늘도 열심히!');
		console.log("뜨냐");
		
		const form = $("#start-form");
		form.attr("action", "/haroo/attendance/insert");
		form.attr("method", "post");
		form.submit();
		
		
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
//3. 외근시간 버튼 클릭






