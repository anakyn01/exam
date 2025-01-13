<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import = "dao.*, dto.*, java.util.*"    
%>
<jsp:include page="include/header.jsp"/>

<section>
<h1>후보조회</h1>
<table border="1">
<colgroup>
<col/>
<col/>
<col/>
<col/>
<col/>
<col/>
<col/>
</colgroup>
<thead>
<tr>
<th>후보번호</th>
<th>성명</th>
<th>소속정당</th>
<th>학력</th>
<th>주민번호</th>
<th>지역구</th>
<th>대표전화</th>
</tr>
</thead>
<% DAO dao = new DAO();//객체생성
ArrayList<DTO> dtos = dao.getMemberList();
%>
<tbody>
<% for (DTO dto : dtos){%>
<tr>
<td><%=dto.getM_no() %></td>
<td><%=dto.getM_name() %></td>
<td><%=dto.getP_name() %></td>
<td><%=dto.getP_school() %></td>
<td><%=dto.getM_jumin() %></td>
<td><%=dto.getM_city() %></td>
<td><%=dto.getP_tel1() %> - <%=dto.getP_tel2() %> - <%=dto.getP_tel3() %></td>
</tr>
<%} %>
</tbody>
</table>

</section>

<jsp:include page="include/footer.jsp"/>