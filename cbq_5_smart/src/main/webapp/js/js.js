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
	if(form.w_quentity.value==''){
		alert("수량이 입력되지 않았습니다!");
		form.w_quentity.focus();
		return;
	}
	if(form.w_workdate.value==''){
		alert("작업시작일이 입력되지 않았습니다!");
		form.w_quentity.focus();
		return;
	}
	form.method="post";
	form.action="work_save.jsp";
	form.submit();
}