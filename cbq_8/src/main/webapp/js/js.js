	function goReset(){
		alert('정보를 지우고 처음부터 다시 입력합니다.');
		form.reset();
		form.player_no.focus();
	}
	
	function goSave(){
		if(form.player_no.value==''){
			alert('선수번호가 입력되지 않았습니다.');
			form.player_no.focus();
			return;
		}
		if(form.point_1.value==''){
			alert('심사위원1 점수가 입력되지 않았습니다.');
			form.point_1.focus();
			return;
		}
		if(form.point_2.value==''){
			alert('심사위원2 점수가 입력되지 않았습니다.');
			form.point_2.focus();
			return;
		}
		if(form.point_3.value==''){
			alert('심사위원3 점수가 입력되지 않았습니다.');
			form.point_3.focus();
			return;
		}
		if(form.point_4.value==''){
			alert('심사위원4 점수가 입력되지 않았습니다.');
			form.point_4.focus();
			return;
		}
		
		form.method="post";
		form.action="point_save.jsp";
		form.submit();
	}
	
	function goUpdate(){
		if(form.player_no.value==''){
			alert('선수번호가 입력되지 않았습니다.');
			form.player_no.focus();
			return;
		}
		if(form.point_1.value==''){
			alert('심사위원1 점수가 입력되지 않았습니다.');
			form.point_1.focus();
			return;
		}
		if(form.point_2.value==''){
			alert('심사위원2 점수가 입력되지 않았습니다.');
			form.point_2.focus();
			return;
		}
		if(form.point_3.value==''){
			alert('심사위원3 점수가 입력되지 않았습니다.');
			form.point_3.focus();
			return;
		}
		if(form.point_4.value==''){
			alert('심사위원4 점수가 입력되지 않았습니다.');
			form.point_4.focus();
			return;
		}
		
		form.method="post";
		form.action="point_update.jsp";
		form.submit();
	}