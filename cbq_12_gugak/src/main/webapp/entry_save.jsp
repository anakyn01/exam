<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*, dto.*"
%>
<%
request.setCharacterEncoding("UTF-8");
DAO dao = new DAO();
String entry_no= request.getParameter("entry_no");
String entry_name = request.getParameter("entry_name");
String entry_jumin = request.getParameter("entry_jumin");
String entry_type= request.getParameter("entry_type");
String entry_area= request.getParameter("entry_area");

int result = dao.saveEntry(entry_no,entry_name,entry_jumin,entry_type,entry_area);
String msg = "참가자가 등록 되었습니다";
if(result!=1) msg="등록 오류";
%>
<script>
alert("<%=msg%>");
location.href="index.jsp";
</script>