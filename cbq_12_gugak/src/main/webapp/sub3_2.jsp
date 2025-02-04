<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*"    
%>
<%
DAO dao = new DAO(); 
%>
<jsp:include page="include/header.jsp" />

<section>
<form name="">
<h1>경연점수가 존재하지 않습니다</h1>
<table border="1">
<thead>
<tr>
<th>
<input type="button" onclick="location.href='sub3.jsp'" value="돌아가기"/>
</th>
</tr>
</thead>
<tbody>

</tbody>
</table>
</form>
</section>

<jsp:include page="include/footer.jsp" />