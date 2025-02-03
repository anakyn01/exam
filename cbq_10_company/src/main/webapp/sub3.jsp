<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import = "dao.*, dto.*, java.util.*"
%>
<jsp:include page="include/header.jsp"/>
<section>
<h1>사원급여조회</h1>
<table border="1">
<thead>
<tr>
<th>사원번호</th><th>사원명</th><th>부서</th><th>직위</th><th>근무지</th><th>실적</th><th>급여</th>
</tr>
</thead>
<% DAO dao = new DAO(); ArrayList<DTO> dtos = dao.getMoneyList(); %>
<tbody>
<%for(DTO dto : dtos){ %>
<tr>
<td><%=dto.getE_no() %></td>
<td><%=dto.getE_name() %></td>
<td><%=dto.getE_depart() %></td>
<td><%=dto.getE_level() %></td>
<td><%=dto.getE_work_place() %></td>
<td><%=dto.getPerformance() %></td>
<td><%=dto.getSalary() %></td>
</tr>
<%} %>
</tbody>
</table>
</section>

<jsp:include page="include/footer.jsp"/>