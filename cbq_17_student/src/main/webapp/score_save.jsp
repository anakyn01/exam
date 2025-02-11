<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*"
%>
<%
	DAO dao = new DAO();
	String s_id = request.getParameter("s_id");
	String sbj_code = request.getParameter("sbj_code");
	int mid = Integer.parseInt(request.getParameter("mid"));
	int finals = Integer.parseInt(request.getParameter("finals"));
	int report = Integer.parseInt(request.getParameter("report"));
	int attend = Integer.parseInt(request.getParameter("attend"));
	int etc = Integer.parseInt(request.getParameter("etc"));
	
	int result = dao.saveScore(s_id,sbj_code,mid,finals,report,attend,etc);
	String msg = "개인 성적이 정상적으로 등록 되었습니다.";
	if(result!=1) msg ="등록 오류";
%>
<script>
alert('<%=msg%>');
location.href="index.jsp";
</script>