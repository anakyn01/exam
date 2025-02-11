<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import = "dao.*, dto.*, java.util.*"
%>
<%
DAO dao = new DAO(); ArrayList<DTO> dtos = dao.getBuyList();
%>
<jsp:include page="include/header.jsp"/>

<section>
<h2></h2>
<table border="1">
<tr>
<th>매수일자</th>
<th>종목번호</th>
<th>종목명</th>
<th>매수수량</th>
<th>매수가격</th>
<th>부서명</th>
</tr>
<% for(DTO dto:dtos){ %>
<tr>
<td><%=dto.getBuy_date() %></td>
<td><%=dto.getS_code() %></td>
<td><%=dto.getS_name() %></td>
<td><%=dto.getBuy_number() %></td>
<td>\<%=dto.getBuy_price() %></td>
<td><%=dto.getDept_name() %></td>
</tr>
<%} %>
</table>
</section>

<jsp:include page="include/footer.jsp"/>