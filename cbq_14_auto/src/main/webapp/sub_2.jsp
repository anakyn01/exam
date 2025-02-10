<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="js/js.js"></script>
<jsp:include page="include/header.jsp"/>
<script src="js/js2.js"></script>
<section>
<h2></h2>
<form name="seat">
<table>
<colgroup>
<col width="50%"/>
<col width="50%"/>
</colgroup>
<tr>
<th>사원 번호를 입력 하시오</th>
<td><input name="t_empno"/></td>
</tr>
<tr>
<td colspan="2">
<button onclick="goList()">좌석예약조회</button>
<a href="index.jsp">홈으로</a>
</td>
</tr>









</table>
</form>
</section>

<jsp:include page="include/footer.jsp"/>