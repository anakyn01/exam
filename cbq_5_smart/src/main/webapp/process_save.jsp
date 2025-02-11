<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import = "dao.*"
%>
<%
DAO dao = new DAO();

String w_workno = request.getParameter("w_workno");
String p_p1 = request.getParameter("p_p1");
String p_p2 = request.getParameter("p_p2");
String p_p3 = request.getParameter("p_p3");
String w_lastdate = request.getParameter("w_lastdate");
String w_lasttime = request.getParameter("w_lasttime");

int result = dao.saveWorkProcess(w_workno, p_p1, p_p2, p_p3, w_lastdate, w_lasttime);
String msg ="작업공정입력이 정상적으로 등록되었습니다";

if(result!=1) msg="등록 오류";
%>
<script>
alert('<%=msg%>');
location.href='sub4.jsp';
</script>