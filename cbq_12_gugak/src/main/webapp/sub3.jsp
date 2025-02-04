<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*"    
%>
<%
DAO dao = new DAO(); 
%>
<jsp:include page="include/header.jsp" />
<script src="js/js3.js"></script>
<section>
<form name="">
<table border="1">
<thead>
<tr>
<th>참가번호를 입력하시오</th>
<td>
<input type="text" name="entry_no">예)0001
</td> 
</tr>
<tr>
<td colspan="2">
<input type="button" onclick="goSearch()" value="결과조회">
<input type="button" onclick="location.href='index.jsp'" value="홈으로">
</td> 
</tr>
</thead>
<tbody>

</tbody>
</table>
</form>
</section>

<jsp:include page="include/footer.jsp" />