<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*, dto.*, java.util.*"
%>
<jsp:include page="include/header.jsp"/>
<section>
<h1>투표검수조회</h1>
<table border="1">
<colgroup>
<col/>
</colgroup>
<thead>
<tr>
<th>성명</th>
<th>생년월일</th>
<th>나이</th>
<th>성별</th>
<th>후보번호</th>
<th>투표시간</th>
<th>유권자확인</th>
</tr>
</thead>
<% DAO dao = new DAO(); ArrayList<DTO> dtos = dao.getVoteList();%>
<tbody>
<% for (DTO dto:dtos) { %>
<tr>
<td><%=dto.getV_name() %></td>
<td><%=dto.getV_birth() %></td>
<td><%=dto.getV_age() %>세</td>
<td><%=dto.getV_gender() %></td>
<td><%=dto.getM_no() %></td>
<td><%=dto.getV_time() %></td>
<td><%=dto.getV_confirm() %></td>
</tr>
<% } %>
</tbody>

</table>

</section>

<jsp:include page="include/footer.jsp"/>