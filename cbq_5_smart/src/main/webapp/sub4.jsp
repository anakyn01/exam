<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dto.*,dao.*,java.util.*"
%>
<jsp:include page="include/header.jsp"/>

<section>
<h2>작업공정조회</h2>
<table border=1>
<tr>
<th>작업지시번호</th>
<th>제품코드</th>
<th>제품명</th>
<th>준비</th>
<th>인쇄</th>
<th>코팅</th>
<th>최종공정일자</th>
<th>최종공정시간</th>
</tr>
<%
	DAO dao = new DAO();
	ArrayList<DTO> dtos = dao.getProcessList();
%>
<%for(DTO dto : dtos) {%>
<tr>
	<td><%=dto.getW_workno()%></td>
	<td><%=dto.getP_code()%></td>
	<td><%=dto.getP_name()%></td>
	<td><%=dto.getP_p1()%></td>
	<td><%=dto.getP_p2()%></td>
	<td><%=dto.getP_p3()%></td>
	<td><%=dto.getW_lastdate()%></td>
	<td><%=dto.getW_lasttime()%></td>
</tr>
<%} %>
</table>
</section>

<jsp:include page="include/footer.jsp"/>