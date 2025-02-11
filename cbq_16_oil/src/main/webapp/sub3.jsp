<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="java.io.PrintWriter, gas.*, java.util.ArrayList"    
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
GasDAO gasDAO = new GasDAO();
ArrayList<Money> list = gasDAO.getList2();
for (int i=0; i < list.size(); i++){
%>
<tr>
<td><%=list.get(i).getOildate() %></td>
<td></td>
<td><%=list.get(i).getOiltype() %></td>
<td><%=list.get(i).getOilcost() %></td>
</tr>
<%} %>
</tbody>

</table>
</div>

<jsp:include page="include/footer.jsp" flush="false"/>