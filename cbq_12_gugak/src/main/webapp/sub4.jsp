<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*, dto.*, java.util.*"    
%>
<%
DAO dao = new DAO(); ArrayList<DTO> dtos = dao.getRanking();
%>
<jsp:include page="include/header.jsp" />

<section>
<form name="">
<h1>최종등수조회</h1>
<table border="1">
<thead>
<tr>
<th>참가번호</th><th>성명</th><th>생년월일</th><th>참가부문</th>
<th>지역</th><th>총점</th><th>평균</th><th>등수</th>
</tr>
</thead>
<tbody>
<%for(DTO dto : dtos){ %>
<tr>
<td><%=dto.getEntry_no() %></td>
<td><%=dto.getEntry_name() %></td>
<td><%=dto.getEntry_jumin() %></td>
<td><%=dto.getEntry_type() %></td>
<td><%=dto.getEntry_area() %></td>
<td><%=dto.getS_tot() %></td>
<td><%=dto.getS_ave() %></td>
<td><%=dto.getRank()%></td>
</tr>
<%} %>
</tbody>
</table>
</form>
</section>

<jsp:include page="include/footer.jsp" />