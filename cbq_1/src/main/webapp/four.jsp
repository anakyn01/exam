<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import ="dao.*,dto.*, java.util.*"    
%>
<jsp:include page="include/header.jsp" flush="false" />
<h1>입출고 내역 조회</h1>
<table>
<colgroup>
<col style="width:20%"/>
<col style="width:30%"/>
<col style="width:20%"/>
<col style="width:30%"/>
</colgroup>
<thead>
<tr>
<th>제품코드</th><th>제품명</th><th>출고수량</th><th>출고매출이익</th>
</tr>
</thead>

<tbody>
<%
request.setCharacterEncoding("UTF-8");
DAO dao = new DAO();
ArrayList<DTO> dtos = dao.getSalesList();
for (int k =0; k < dtos.size(); k++){
%>
<tr>
<td><%=dtos.get(k).getP_code() %></td>
<td><%=dtos.get(k).getP_name() %></td>
<td><%=dtos.get(k).getT_cnt() %></td>
<td><%=dtos.get(k).getResult() %></td>
</tr>
<%} %>
</tbody>
</table>
<jsp:include page="include/footer.jsp" flush="false" />