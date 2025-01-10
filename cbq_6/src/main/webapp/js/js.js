function Reset(){
alert('정보를 지우고 처음부터 다시 입력합니다');
form.reset();
form.v_jumin.focus();
}
function goVote(){
	if(form.v_jumin.value==''){
		alert('주민번호가 입력되지 않았습니다');
		form.v_jumin.focus();
		return;
	}
	if(form.v_name.value==''){
		alert('성명이 입력되지 않았습니다');
		form.v_name.focus();
		return;
	}
	if(form.m_no.value==''){
		alert('후보번호를 선택하세요');
		form.m_no.focus();
		return;
	}
	if(form.v_time.value==''){
		alert('투표시간이 입력되지 않았습니다');
		form.v_time.focus();
		return;
	}
	if(form.v_area.value==''){
		alert('투표장소가 입력되지 않았습니다');
		form.v_area.focus();
		return;
	}
	if(form.v_confirm.value==''){
		alert('투표시간이 입력되지 않았습니다');
		form.v_confirm.focus();
		return;
	}
	form.method="post";
	form.action="vote.jsp";
	form.submit();	
}