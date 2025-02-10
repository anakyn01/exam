<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="js/js.js"></script>
<jsp:include page="include/header.jsp"/>

<section>
<h2></h2>
<form name="seat">
<table>
<colgroup>
<col width="30%"/>
<col width="70%"/>
</colgroup>
<tr>
	<th>근무좌석예약</th>
	<td><input name="t_resvno"/>예)20210001</td>
</tr>
<tr>
	<th>사원번호</th>
	<td><input name="t_empno"/>예)1001</td>
</tr>
<tr>
	<th>근무일자</th>
	<td><input name="t_resvdate"/>예)20211231</td>
</tr>
<tr>
	<th>좌석번호</th>
	<td><input name="t_seatno"/>예)S001 ~ S009</td>
</tr>
<tr>
<td colspan="2">
<button onclick="goSave()">등록</button>
<button onclick="goReset()">다시쓰기</button>
</td>
</tr>
</table>
</form>
</section>

<jsp:include page="include/footer.jsp"/>