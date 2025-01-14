<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*, dto.*, java.util.*"
%>
<jsp:include page="include/header.jsp" flush="false"/>
<h1>참가자 조회</h1>
<table>
<colgroup>
<col style="width:10%"/>
<col style="width:15%"/>
<col style="width:20%"/>
<col style="width:20%"/>
<col style="width:15%"/>
<col style="width:20%"/>
</colgroup>
<thead>
<tr>
<th>선수번호</th><th>선수명</th><th>국적</th><th>생년월일</th><th>성별</th><th>기술난이도</th>
</tr>
</thead>
<% DAO dao = new DAO(); ArrayList<DTO> dtos = dao.getPlayerList(); %>
<tbody>
<% for(DTO dto : dtos) { %>
<tr>
<td><%=dto.getPlayer_no() %></td>
<td><%=dto.getName() %></td>
<td><%=dto.getNation_name() %></td>
<td><%=dto.getBirth() %></td>
<td><%=dto.getGender() %></td>
<td><%=dto.getSkill_name() %></td>
</tr>
<%} %>
</tbody>
</table>

<jsp:include page="include/footer.jsp" flush="false"/>