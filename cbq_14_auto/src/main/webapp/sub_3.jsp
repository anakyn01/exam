<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*, dto.*, java.util.*"
%>
<%
DAO dao = new DAO();
ArrayList<DTO2> dtos = dao.getContractTotal();
%>
<jsp:include page="include/header.jsp"/>

<section>
<h2>사원별근무일수집계</h2>
<form name="seat">
<table>
<colgroup>
<col width="25%"/>
<col width="25%"/>
<col width="25%"/>
<col width="25%"/>
</colgroup>
<tr>
<th>사원번호</th><th>이름</th><th>부서명</th><th>근무일수</th>
</tr>
<%for(DTO2 dto:dtos){ %>
<tr>
<td><%=dto.empno %></td>
<td><%=dto.empname %></td>
<td><%=dto.deptname %></td>
<td><%=dto.count %></td>
</tr>
<%} %>
</table>
</form>
</section>

<jsp:include page="include/footer.jsp"/>