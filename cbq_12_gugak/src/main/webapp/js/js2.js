function goSave(){
	if(form2.entry_no.value==''){
		alert('참가번호가 입력되지 않았습니다');
		form2.entry_no.focus();
		return;
	}
	if(form2.score1.value==''){
		alert('심사위원 점수가 입력되지 않았습니다');
		form2.score1.focus();
		return;
	}
	if(form2.score2.value==''){
		alert('심사위원 점수가 입력되지 않았습니다');
		form.score2.focus();
		return;
	}
	if(form2.score3.value==''){
		alert('심사위원 점수가 입력되지 않았습니다');
		form.score3.focus();
		return;
	}
	if(form2.score4.value==''){
		alert('심사위원 점수가 입력되지 않았습니다');
		form.score4.focus();
		return;
	}
    if(form2.score5.value==''){
		alert('심사위원 점수가 입력되지 않았습니다');
		form.score5.focus();
		return;
	}
	form2.method="post";
	form2.action="score_save.jsp";
	form2.submit();	
}
function goReset(){
	alert('정보를 지우고 처음부터 다시 입력합니다');
	form2.reset();
	form2.entry_no.focus();
}






