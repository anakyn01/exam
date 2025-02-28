<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*, dto.*, java.util.*"
%>
<jsp:include page="include/header.jsp"/>
<section>
<h2>작업지시조회</h2>
<table border=1>
<tr>
<th>작업지시번호</th>
<th>제품코드</th>
<th>제품명</th>
<th>제품규격</th>
<th>제품구분</th>
<th>수량</th>
<th>작업시작일</th>
</tr>
<% DAO dao = new DAO(); ArrayList<DTO> dtos = dao.getWorkList(); %>
<% for (DTO dto : dtos){ %>
<tr>
<td><%=dto.getW_workno() %></td>
<td><%=dto.getP_code() %></td>
<td><%=dto.getP_name() %></td>
<td><%=dto.getP_size() %></td>
<td><%=dto.getP_type() %></td>
<td><%=dto.getW_quentity() %></td>
<td><%=dto.getW_workdate() %></td>
</tr>
<% } %>
</table>
</section>

<jsp:include page="include/footer.jsp"/>