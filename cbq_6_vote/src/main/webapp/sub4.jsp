<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import = "dao.*, dto.*, java.util.*" 
%>
<jsp:include page="include/header.jsp"/>

<section>
<h1>후보자등수</h1>
<table border="1" >
<colgroup>
<col/>
<col/>
<col/>
<col/>
</colgroup>
<thead>
<tr>
<th>후보번호</th>
<th>성명</th>
<th>총투표건수</th>
<th>득표율</th>
</tr>
</thead>
<% DAO dao = new DAO(); ArrayList<DTO> dtos = dao.getRanking();%>
<tbody>
<% for(DTO dto : dtos) { %>
<tr>
<td><%=dto.getM_no()%></td>
<td><%=dto.getM_name()%></td>
<td><%=dto.getCount()%></td>
<td><%=dto.getPer()%> %</td>
</tr>
<%} %>
</tbody>









</table>

</section>

<jsp:include page="include/footer.jsp"/>