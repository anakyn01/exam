function goReset(){
		alert('정보를 지우고 처음부터 다시 입력합니다.');
		form.reset();
		form.s_id.focus();
	}
	
	function goScoreSave(){
		if(form.s_id.value==''){
			alert('학번이 입력되지 않았습니다.');
			form.s_id.focus();
			return;
		}
		if(form.sbj_code.value==''){
			alert('수강코드가 입력되지 않았습니다.');
			form.sbj_code.focus();
			return;
		}
		if(form.mid.value==''){
			alert('중간 30% (0~100)점수가 입력되지 않았습니다.');
			form.mid.focus();
			return;
		}
		if(form.mid.value>100){
			alert('중간 30% (0~100)점수가 올바르지 않습니다.');
			form.mid.value='';
			form.mid.focus();
			return;
		}
		if(form.finals.value==''){
			alert('기말 30% (0~100)점수가 입력되지 않았습니다.');
			form.finals.focus();
			return;
		}
		if(form.finals.value>100){
			alert('기말 30% (0~100)점수가 올바르지 않습니다.');
			form.finals.value='';
			form.finals.focus();
			return;
		}
		if(form.report.value==''){
			alert('레포트 20% (0~100)점수가 입력되지 않았습니다.');
			form.report.focus();
			return;
		}
		if(form.report.value>100){
			alert('레포트 20% (0~100)점수가 올바르지 않습니다.');
			form.report.value='';
			form.report.focus();
			return;
		}
		if(form.attend.value==''){
			alert('출석 10% (0~100)점수가 입력되지 않았습니다.');
			form.attend.focus();
			return;
		}
		if(form.attend.value>100){
			alert('출석 10% (0~100)점수가 올바르지 않습니다.');
			form.attend.value='';
			form.attend.focus();
			return;
		}
		if(form.etc.value==''){
			alert('기타 10% (0~100)점수가 입력되지 않았습니다.');
			form.etc.focus();
			return;
		}
		if(form.etc.value>100){
			alert('기타 10% (0~100)점수가 올바르지 않습니다.');
			form.etc.value='';
			form.etc.focus();
			return;
		}
		
		form.method="post";
		form.action="score_save.jsp";
		form.submit();
	}