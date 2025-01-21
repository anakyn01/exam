<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import ="dao.*,dto.*, java.util.*"
%>
<jsp:include page="include/header.jsp" flush="false" />
<h1>입출고 내역 조회</h1>
<table>
<colgroup>
<col style="width:10%"/>
<col style="width:10%"/>
<col style="width:20%"/>
<col style="width:20%"/>
<col style="width:10%"/>
<col style="width:20%"/>
<col style="width:10%"/>
</colgroup>
<thead>
<tr>
<th>입출고번호</th><th>제품코드</th><th>제품명</th><th>입출고 구분</th><th>수량</th><th>거래처</th><th>거래일자</th>
</tr>
</thead>
<tbody>
<%
request.setCharacterEncoding("UTF-8");
DAO dao = new DAO();

ArrayList<DTO> dtos = dao.getInoutList();

for (int k =0; k < dtos.size(); k++){
%>
<tr>
<td></td>
<td><%=dtos.get(k).getT_no() %></td>
<td><%=dtos.get(k).getP_code() %></td>
<td><%=dtos.get(k).getT_type() %></td>
<td><%=dtos.get(k).getT_cnt() %></td>
<td><%=dtos.get(k).getC_code() %></td>
<td><%=dtos.get(k).getT_date()%></td>
</tr>
<%} %>
</tbody>
</table>

<jsp:include page="include/footer.jsp" flush="false" />