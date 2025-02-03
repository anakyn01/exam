<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import = "dao.*, dto.*, java.util.*"
%>
<jsp:include page="include/header.jsp"/>
<section>
<h1>부서별 급여조회</h1>
<table border="1">
<thead>
<tr>
<th>부서코드</th>
<th>부서명</th>
<th>총 급여</th>
</tr>
</thead>
<% DAO dao = new DAO(); ArrayList<DTO> dtos = dao.getDepartMoneyList(); %>
<tbody>
<%for(DTO dto : dtos){ %>
<tr>
<td><%=dto.getDepart_code() %></td>
<td><%=dto.getE_depart()%></td>
<td><%=dto.getSalary() %></td>
</tr>
<%} %>
</tbody>
</table>
</section>

<jsp:include page="include/footer.jsp"/>