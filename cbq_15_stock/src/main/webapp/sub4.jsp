<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import = "dao.*, dto.*, java.util.*"
%>
<%
DAO dao = new DAO(); ArrayList<DTO> dtos = dao.getDeptTotal();
%>
<jsp:include page="include/header.jsp"/>

<section>
<h2></h2>
<table border="1">
<tr>
<th>부서코드</th>
<th>부서명</th>
<th>총매수주식수</th>
<th>총매수주식금액</th>
</tr>
<% for(DTO dto:dtos){ %>
<tr>
<td><%=dto.getDept_code() %></td>
<td><%=dto.getDept_name() %></td>
<td><%=dto.getBuy_number() %></td>
<td><%=dto.getS_total() %></td>
</tr>
<%} %>
</table>
</section>

<jsp:include page="include/footer.jsp"/>