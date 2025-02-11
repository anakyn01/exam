function CodeInsert(){
	if(form.s_name.value !=''){
		form.s_code.value = form.s_name.value;
	}
}
function goReset(){
	alert('정보를 지우고 처음부터 다시 입력합니다.');
	form.reset();
	form.buy_date.focus();
}
function goSave(){
	if(form.buy_date.value==''){
		alert('매수일자가 입력되지 않았습니다!');
		form.buy_date.focus();
		return;
	}
	if(form.s_name.value==''){
	alert('종목명이 선택되지 않았습니다!');
	form.s_name.focus();
	return;
}
		if(form.s_code.value==''){
			alert('종목코드가 입력되지 않았습니다!');
			form.s_code.focus();
			return;
		}
		if(form.buy_number.value==''){
			alert('매수수량이 입력되지 않았습니다!');
			form.buy_number.focus();
			return;
		}
		if(form.buy_price.value==''){
			alert('매수가격이 입력되지 않았습니다!');
			form.buy_price.focus();
			return;
		}
		if(form.dept_code.value==''){
			alert('부서코드가 선택되지 않았습니다!');
			form.dept_code.focus();
			return;
		}

	form.method="post";
	form.action="stock_save.jsp"
	form.submit();
}