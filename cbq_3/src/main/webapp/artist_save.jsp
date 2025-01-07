<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*, dto.*" %>    
<%
request.setCharacterEncoding("UTF-8");
DAO dao = new DAO();

String a_no = request.getParameter("a_no");
String a_name = request.getParameter("a_name");
String year = request.getParameter("t_year");
String month = request.getParameter("t_month");
if(month.length()==1) month="0"+month;
String date = request.getParameter("t_date");
if(date.length()==1) date="0"+date;
String a_birth = year + month + date;
String gender = request.getParameter("gender");
String talent = request.getParameter("talent");
String agency = request.getParameter("agency");

int result = dao.ArtistSave(a_no,a_name,a_birth,gender,talent,agency);
String msg = "참가신청이 정상적으로 등록 되었습니다";
if(result!=1) msg = "등록 오류";
%>
<script type="text/javascript">
alert('<%=msg%>');
location.href="sub2.jsp";
</script>







