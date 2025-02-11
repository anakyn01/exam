<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*,dto.*, java.util.*"    
%>
<%
DAO dao = new DAO(); ArrayList<DTO> dtos = dao.getDateSales();
%>
<jsp:include page="include/header.jsp" flush="false"/>

<div class="text-center">
<h1>일 매출통계</h1>
<table>
<colgroup>
<col/><col/><col/><col/>
</colgroup>
<thead>
<tr>
<th>주유일자</th><th>유종</th><th>건수</th><th>금액</th>
</tr>
</thead>
<tbody>
<%
for (DTO dto : dtos) {
%>
<tr>
<td><%=dto.getOildate() %></td>
<td><%=dto.getOilname() %></td>
<td><%=dto.getCount() %>건</td>
<td><%=dto.getOilcost() %></td>
</tr>
<%} %>
</tbody>

</table>
</div>

<jsp:include page="include/footer.jsp" flush="false"/>