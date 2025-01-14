<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*, dto.*, java.util.*"    
%>
<jsp:include page="include/header.jsp" flush="false"/>
<h1>심사 점수 조회</h1>
<table>
<colgroup>
<col style="width:10%"/>
<col style="width:10%"/>
<col style="width:15%"/>
<col style="width:15%"/>
<col style="width:15%"/>
<col style="width:15%"/>
<col style="width:10%"/>
<col style="width:10%"/>
</colgroup>
<thead>
<tr>
<th>선수번호</th><th>선수명</th><th>심사위원1</th><th>심사위원2</th><th>심사위원3</th><th>심사위원4</th><th>총점</th><th>평균</th>
</tr>
</thead>
<% DAO dao = new DAO(); ArrayList<DTO> dtos = dao.getPointList();%>
<tbody>
<% for (DTO dto : dtos) { %>
<tr>
<td><%=dto.getPlayer_no() %></td>
<td><%=dto.getName() %></td>
<td><%=dto.getPoint_1() %>점</td>
<td><%=dto.getPoint_2() %>점</td>
<td><%=dto.getPoint_3() %>점</td>
<td><%=dto.getPoint_4() %>점</td>
<td><%=dto.getTotal() %></td>
<td><%=dto.getAva() %>점</td>
</tr>
<%} %>
</tbody>








</table>

<jsp:include page="include/footer.jsp" flush="false"/>