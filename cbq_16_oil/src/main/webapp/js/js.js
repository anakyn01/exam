function goReset(){
		alert('정보를 지우고 처음부터 다시 입력합니다.');
		form.reset();
		form.saleno.focus();
	}
	
	function goSave(){
		if(form.saleno.value==''){
			alert('매출번호가 입력되지 않았습니다!');
			form.saleno.focus();
			return;
		}
		if(form.oildate.value==''){
			alert('주유일자가 입력되지 않았습니다!');
			form.oildate.focus();
			return;
		}
		if(form.oiltype.value==''){
			alert('유종이 선택되지 않았습니다!');
			form.oiltype.focus();
			return;
		}
		if(form.amount.value==''){
			alert('주유량이 입력되지 않았습니다!');
			form.amount.focus();
			return;
		}
		if(form.paytype.value==''){
			alert('결제방법이 입력되지 않았습니다!');
			form.paytype.focus();
			return;
		}
		if(form.paytype.value=='2'){
			if(form.credit1.value==''){
				alert('카드번호가 입력되지 않았습니다!');
				form.credit1.focus();
				return;				
			}
			if(form.credit2.value==''){
				alert('카드번호가 입력되지 않았습니다!');
				form.credit2.focus();
				return;				
			}
			if(form.credit3.value==''){
				alert('카드번호가 입력되지 않았습니다!');
				form.credit3.focus();
				return;				
			}
			if(form.credit4.value==''){
				alert('카드번호가 입력되지 않았습니다!');
				form.credit4.focus();
				return;				
			}
		}
		
		if(form.oilcost.value==''){
			alert('금액이 입력되지 않았습니다!');
			form.oilcost.focus();
			return;
		}
		
		form.method="post";
		form.action="sale_save.jsp";
		form.submit();
	}