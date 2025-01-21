<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import ="dao.*, dto.*, java.util.*"
%>
<jsp:include page="include/header.jsp" flush="false" />
<h1>입출고 내역 조회</h1>
<table>
<colgroup>
<col style="width:10%"/>
<col style="width:20%"/>
<col style="width:10%"/>
<col style="width:20%"/>
<col style="width:20%"/>
</colgroup>
<thead>
<tr>
<th>제품코드</th><th>제품명</th><th>사이즈</th><th>매입단가</th><th>출고단가</th>
</tr>
</thead>
<tbody>
<%
request.setCharacterEncoding("UTF-8");
DAO dao = new DAO();

ArrayList<DTO> dtos = dao.getProductList();

for (int k =0; k < dtos.size(); k++){
%>
<tr>
<td><%=dtos.get(k).getP_code() %></td>
<td><%=dtos.get(k).getP_name() %></td>
<td><%=dtos.get(k).getP_size() %></td>
<td>￦<%=dtos.get(k).getP_incost()%></td>
<td>￦<%=dtos.get(k).getP_outcost() %></td>
</tr>
<%} %>
</tbody>
</table>

<jsp:include page="include/footer.jsp" flush="false" />