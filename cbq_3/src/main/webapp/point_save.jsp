<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*"
%>
<%
DAO dao = new DAO();

int serial_no = dao.getMaxNo();
String a_id = request.getParameter("artist");
String point_1 = request.getParameter("point_1");
String point_2 = request.getParameter("point_2");
String point_3 = request.getParameter("point_3");

int result = dao.PointSave(serial_no, a_id, point_1, point_2, point_3);
String msg = "멘토 점수가 정상적으로 등록 되었습니다";

if(result!=3) msg = "등록 오류";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>참가자 점수 등록</title>
<script type="text/javascript">
   alert('<%=msg%>');
   location.href="sub4.jsp";
</script>
</head>
<body>

</body>
</html>