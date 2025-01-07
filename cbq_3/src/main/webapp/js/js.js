function goReset(){
alert("정보를 지우고 처음 부터 다시 입력합니다");
artist.reset();
artist.a_no.focus();
return;
}
function goSave(){
	if(artist.a_no.value==''){
		alert("참가번호가 입력되지 않았습니다");
		artist.a_no.focus();
		return;
	}
	if(artist.a_name.value==''){
		alert("참가자명이 입력되지 않았습니다");
		artist.a_name.focus();
		return;
	}
	if(artist.t_year.value==''){
		alert("생년월일이 입력되지 않았습니다");
		artist.t_year.focus();
		return;
	}
	if(artist.t_month.value==''){
		alert("생년월일이 입력되지 않았습니다");
		artist.t_month.focus();
		return;
	}
	if(artist.t_date.value==''){
		alert("생년월일이 입력되지 않았습니다");
		artist.t_date.focus();
		return;
	}
	if(artist.gender.value==''){
		alert("성별이 선택되지 않았습니다");
		artist.t_date.focus();
		return;
	}
	if(artist.talent.value==''){
		alert("특기가 선택되지 않았습니다");
		artist.talent.focus();
		return;
	}
	if(artist.agency.value==''){
		alert("특기가 선택되지 않았습니다");
		artist.agency.focus();
		return;
	}
	artist.method="post";
	artist.action="../artist_save.jsp";
	artist.submit();	
}