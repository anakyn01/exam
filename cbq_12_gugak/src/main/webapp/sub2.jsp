<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*"    
%>
<%
DAO dao = new DAO(); 
%>
<jsp:include page="include/header.jsp" />
<script src="js/js2.js"></script>
<section>
<form name="form2">
<table border="1">
<thead>
	<tr>
		<th>참가번호</th>
		<td>
		<input type="text" name="entry_no"/> 예)0001
		</td>
	</tr>
	<tr>
		<th>심사위원</th>
		<td>
		<b>심사점수(1~100)</b>
		</td>
	</tr>
	<tr>
		<th>김심사</th>
		<td>
		<input type="text" name="score1"/>점
		</td>
	</tr>
	<tr>
		<th>이심사</th>
		<td>
		<input type="text" name="score2"/>점
		</td>
	</tr>
	<tr>
		<th>박심사</th>
		<td>
		<input type="text" name="score3"/>점
		</td>
	</tr>	
	<tr>
		<th>황심사</th>
		<td>
		<input type="text" name="score4"/>점
		</td>
	</tr>
	<tr>
		<th>조심사</th>
		<td>
		<input type="text" name="score5"/>점
		</td>
	</tr>
<tr>
<td colspan="2">
<input type="button" value="등록" onclick="goSave()">
<input type="button" value="다시쓰기" onclick="goReset()">
</td>
</tr>
</thead>
<tbody>

</tbody>
</table>
</form>
</section>

<jsp:include page="include/footer.jsp" />