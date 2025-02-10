function goSave(){
	if(seat.t_resvno.value==""){
		alert("예약 번호가 입력되지 않았습니다!");
		seat.t_resvno.focus();
		return;
	}
	if(seat.t_empno.value==""){
		alert("사원번호가 입력되지 않았습니다!");
		seat.t_empno.focus();
		return;
	}
	if(seat.t_resvdate.value==""){
		alert("근무일자가 입력되지 않았습니다!");
		seat.t_resvdate.focus();
		return;
	}
	if(seat.t_resvdate.value.length !=8){
		alert("근무일자는  8자 입니다!");
		seat.t_resvdate.focus();
		return;
	}
	if(seat.t_seatno.value==""){
		alert("좌석번호가 입력되지 않았습니다!");
		seat.t_seatno.focus();
		return;
	}
	seat.method="post";
	seat.action="Sub_1_Save.jsp";
	seat.submit();	
}
function goReset(){
	alert("정보를 지우고 처음부터 다시 입력 합니다");
	seat.reset();
	seat.t_resvno.focus();	
}