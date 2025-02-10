<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*"
%>
<%
request.setCharacterEncoding("utf-8");
DAO dao = new DAO();
String resvno = request.getParameter("t_resvno");
String empno = request.getParameter("t_empno");
String resvdate = request.getParameter("t_resvdate");
String seatno = request.getParameter("t_seatno");

int count = dao.checkResvno(resvno);

String msg ="좌석예약정보가 등록되었습니다!";
if(count == 1){
	msg = "중복된 예약 번호 입니다";
}else{
	int result = dao.contractSave(resvno, empno, resvdate, seatno);
	if(result != 1) msg = "예약 저장 실패";
}
%>
<script>
alert("<%=msg%>");
if(<%=count%> == 1){
	location.href="sub_1.jsp";
}else{
	location.href="index.jsp";
}
</script>




