<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="include/header.jsp"/>
<script src="js/js2.js"></script>
<form name="form">
<section>
<h2>작업공정등록</h2>
<table border=1>
	<tr>
		<th>작업지시번호</th>
		<td>
		<input type="text" name="w_workno">
		<span>예)20220001</span>
		</td>
	</tr>
	<tr>
		<th>재료준비</th>
		<td>
		<input type="radio" name="p_p1" value="Y">완료
		<input type="radio" name="p_p1" value="N">작업중
		</td>
	</tr>
	<tr>
		<th>인쇄공정</th>
		<td>
		<input type="radio" name="p_p2" value="Y">완료
		<input type="radio" name="p_p2" value="N">작업중
		</td>
	</tr>
	<tr>
		<th>코팅공정</th>
		<td>
		<input type="radio" name="p_p3" value="Y">완료
		<input type="radio" name="p_p3" value="N">작업중
		</td>
	</tr>
	<tr>
		<th>최종작업일자</th>
		<td>
			<input type="text" name="w_lastdate">
			<span>예)20220101</span>
		</td>
	</tr>
	<tr>
		<th>최종작업시간</th>
		<td>
<input type="text" name="w_lasttime">
<span>예)1300</span>
		</td>
	</tr>
	<tr>
<td colspan="2">
<input type="button" onclick="goSave()" value="공정등록">
<input type="button" onclick="goUpdate()" value="공정수정">
<input type="button" onclick="FormReset()" value="다시쓰기">
</td>
	</tr>	
</table>
</section>
</form>
<jsp:include page="include/footer.jsp"/>