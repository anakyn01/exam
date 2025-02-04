function goSave(){
	if(form.entry_no.value==''){
		alert('참가번호가 입력되지 않았습니다');
		form.entry_no.focus();
		return;
	}
	if(form.entry_name.value==''){
		alert('성명이 입력되지 않았습니다');
		form.entry_name.focus();
		return;
	}
	if(form.entry_jumin.value==''){
		alert('주민등록번호가 입력되지 않았습니다');
		form.entry_jumin.focus();
		return;
	}
	if(form.entry_area.value==''){
		alert('지역이 입력되지 않았습니다');
		form.entry_area.focus();
		return;
	}
	form.method="post";
	form.action="entry_save.jsp";
	form.submit();	
}
function goReset(){
	alert('정보를 지우고 처음부터 다시 입력합니다');
	form.reset();
	form.entry_no.focus();
}






