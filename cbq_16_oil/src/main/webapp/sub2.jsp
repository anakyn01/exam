<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*, dto.*, java.util.*"
%>
<%
DAO dao = new DAO(); ArrayList<DTO> dtos = dao.getSalesList();
String total = dao.getTotalCost();
%>
<jsp:include page="include/header.jsp" flush="false"/>

<div class="text-center">
<h1>전체매출조회</h1>
<table>
<colgroup>
<col/><col/><col/><col/><col/><col/><col/><col/><col/><col/>
</colgroup>
<thead>
<tr>
<th>순서</th><th>매출번호</th><th>주유일자</th><th>유종</th><th>주유량</th><th>결제방법</th><th>고객번호</th><th>카드번호</th><th>금액</th>
</tr>
</thead>
<tbody>
<%
for(DTO dto: dtos){
%>
<tr>
<td><%=dto.getSaleno() %></td>
<td><%=dto.getOildate() %></td>
<td><%=dto.getOilname() %></td>
<td><%=dto.getAmount() %></td>
<td><%=dto.getPaytype() %></td>
<td><%=dto.getCustname() %></td>
<td><%=dto.getCustno() %></td>
<td><%=dto.getCusttel1()%>-<%=dto.getCusttel2()%>-<%=dto.getCusttel3()%></td>
<td><%=dto.getCreditcart() %></td>
<td><%=dto.getOilcost() %></td>
</tr>
<%}%>
<tr>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td>매출총액</td>
	<td class="td_right">\<%=total%></td>
</tr>
</tbody>

</table>
</div>

<jsp:include page="include/footer.jsp" flush="false"/>