function FormReset(){
	alert("정보를 지우고 처음부터 다시 입력합니다");
	form.reset();
	from.w_workno.focus();
}

function goSave(){
	if(form.w_workno.value==''){
		alert("작업지시번호가 입력되지 않았습니다!");
		form.w_workno.focus();
		return;
	}
	if(form.p_p1.value==''){
		alert("재료준비 항목이 선택되지 않았습니다!");
		return;
	}
	if(form.p_p2.value==''){
		alert("인쇄공정 항목이 선택되지 않았습니다!");
		return;
	}
	if(form.p_p3.value==''){
		alert("코팅공정 항목이 선택되지 않았습니다!");
		return;
	}
	if(form.w_lastdate.value==''){
		alert("최종작업일자가 입력되지 않았습니다!");
		form.w_lastdate.focus();
		return;
	}
	if(form.w_lasttime.value==''){
		alert("최종작업일자가 입력되지 않았습니다!");
		form.w_lasttime.focus();
		return;
	}
	form.method="post";
	form.action="process_save.jsp";
	form.submit();
}
function goUpdate(){
	if(form.w_workno.value==''){
		alert("작업지시번호가 입력되지 않았습니다!");
		form.w_workno.focus();
		return;
	}
	if(form.p_p1.value==''){
		alert("재료준비 항목이 선택되지 않았습니다!");
		return;
	}
	if(form.p_p2.value==''){
		alert("인쇄공정 항목이 선택되지 않았습니다!");
		return;
	}
	if(form.p_p3.value==''){
		alert("코팅공정 항목이 선택되지 않았습니다!");
		return;
	}
	if(form.w_lastdate.value==''){
		alert("최종작업일자가 입력되지 않았습니다!");
		form.w_lastdate.focus();
		return;
	}
	if(form.w_lasttime.value==''){
		alert("최종작업일자가 입력되지 않았습니다!");
		form.w_lasttime.focus();
		return;
	}
	form.method="post";
	form.action="process_update.jsp";
	form.submit();
}