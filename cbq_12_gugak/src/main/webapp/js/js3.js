function goSearch(){
if(entry.entry_no.value==''){
	alert('참가번호가 입력되지 않았습니다!');
	entry.entry_no.focus();
	return;
}
	form2.method="post";
	form2.action="sub3_1.jsp";
	form2.submit();	
}







