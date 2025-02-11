<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import ="dao.*, dto.*, java.util.*"
%>
<%
DAO dao = new DAO();
ArrayList<DTO> dtos = dao.getStockList();
%>
<jsp:include page="include/header.jsp"/>
<section>
<h2>주식 종목 조회</h2>
<table border="1">
<tr>
<th>종목코드</th>
<th>주식이름</th>
<th>종목시장</th>
<th>업종</th>
<th>상장일</th>
</tr>
<%for(DTO dto:dtos){ %>
<tr>
<td><%=dto.getS_code() %></td>
<td><%=dto.getS_name() %></td>
<td><%=dto.getS_market() %></td>
<td><%=dto.getS_category() %></td>
<td><%=dto.getS_listed_date() %></td>
</tr>
<%} %>
</table>
</section>

<jsp:include page="include/footer.jsp"/>