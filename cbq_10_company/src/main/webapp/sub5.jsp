<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import = "dao.*, dto.*, java.util.*"
%>
<jsp:include page="include/header.jsp"/>
<section>
<h1>지역별급여조회</h1>
<table border="1">
<thead>
<tr>
<th>지역코드</th>
<th>지역명</th>
<th>총급여</th>
</tr>
</thead>
<% DAO dao = new DAO(); ArrayList<DTO> dtos = dao.getWorkplaceMoneyList(); %>
<tbody>
<%for(DTO dto : dtos){ %>
<tr>
<td><%=dto.getWork_place() %></td>
<td><%=dto.getE_work_place() %></td>
<td><%=dto.getSalary() %></td>
</tr>
<%} %>
</tbody>
</table>
</section>

<jsp:include page="include/footer.jsp"/>