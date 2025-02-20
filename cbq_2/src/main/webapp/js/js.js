function goReset(){
    alert('정보를 지우고 처음부터 다시 입력합니다');
    form.reset();
    form.p_seno.focus();
}
function goSave(){
    if(form.p_seno.value==''){
        alert("입력되지 않았습니다");
		form.p_seno.focus();
        return;
    }
    form.method="post";
    form.action="save.jsp";
    form.submit();
}