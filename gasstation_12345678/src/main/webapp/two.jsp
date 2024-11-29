<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="java.io.PrintWriter, gas.*, java.util.ArrayList"
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
GasDAO gasDAO = new GasDAO();
ArrayList<Money> list = gasDAO.getList2();
for (int i=0; i < list.size(); i++){
%>
<tr>
<td><%=list.get(i).getSalebno() %></td>
<td><%=list.get(i).getSaleno() %></td>
<td><%=list.get(i).getOildate() %></td>
<td><%=list.get(i).getOiltype() %></td>
<td><%=list.get(i).getAmount() %></td>
<td><%=list.get(i).getPaytype() %></td>
<td><%=list.get(i).getCustno() %></td>
<td><%=list.get(i).getCreditcard() %></td>
<td><%=list.get(i).getOilcost() %></td>
</tr>
<%} %>
</tbody>

</table>
</div>

<jsp:include page="include/footer.jsp" flush="false"/>