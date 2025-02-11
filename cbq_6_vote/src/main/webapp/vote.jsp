<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*"
%>
<%
request.setCharacterEncoding("UTF-8");
DAO dao = new DAO();

String v_jumin = request.getParameter("v_jumin");
String v_name = request.getParameter("v_name");
String m_no = request.getParameter("m_no");
String v_time = request.getParameter("v_time");
String v_area = request.getParameter("v_area");
String v_confirm = request.getParameter("v_confirm");
/*java의 서블릿API에서 사용되는 메서드 클라이언트가 보낸 Http요청의 파라미터를 추출하는데 사용된다
1)데이터 추출하기 위함, 2)동적인 데이터 처리, 3)클라이어트와 서버간의 데이터 전달
4) 다양한 오청 유형지원(GET, POST)
*/
int result = dao.doVote(v_jumin, v_name, m_no, v_time, v_area, v_confirm);
//변수 리절트에 매개값을 대입함
//성공 실패 대비
String msg = "투표하기 정보가 정상적으로 등록되었습니다!";
if(result!=1) msg = "투표 오류";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지역구의원 투표관리</title>
</head>
<body>
<script>
alert("<%=msg%>");
location.href="index.jsp";
</script>







</body>
</html>