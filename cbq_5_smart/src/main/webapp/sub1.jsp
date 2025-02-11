<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*, dto.*, java.util.*"
%>
<jsp:include page="include/header.jsp"/>
<%
DAO dao = new DAO();
ArrayList<DTO> dtos = dao.getProductList();
%>
<section>
<h2>제품조회</h2>
<table border=1>
<tr>
<th>제품코드</th>
<th>제품명</th>
<th>제품규격</th>
<th>제품구분</th>
<th>제품단가</th>
</tr>
<%for(DTO dto : dtos){ %>
<tr>
<td><%=dto.getP_code() %></td>
<td><%=dto.getP_name() %></td>
<td><%=dto.getP_size() %></td>
<td><%=dto.getP_type() %></td>
<td>\<%=dto.getP_price() %></td>
</tr>
<%} %>
</table>
</section>

<jsp:include page="include/footer.jsp"/>