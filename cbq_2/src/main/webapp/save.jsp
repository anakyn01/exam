<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*"
%>
<%
DAO dao=new DAO();
String p_seno = request.getParameter("p_seno");
String p_no = request.getParameter("p_no");
String i_code = request.getParameter("i_code");
String p_date = request.getParameter("p_date");

int result = dao.sub2(p_seno, p_no, i_code, p_date);
String msg = "등록됨";
if (result !=1) msg = "등록 실패!";
%>
<script>
    alert('<%=msg%>');
    location.href="index.jsp";
</script>