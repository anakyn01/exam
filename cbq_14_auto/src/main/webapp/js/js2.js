function goList(){
	if(seat.t_empno.value==""){
		alert("사원번호가 입력되지 않았습니다!");
		seat.t_empno.focus();
		return;
	}
	seat.method="post";
	seat.action="sub_2_1.jsp";
	seat.submit();	
}
