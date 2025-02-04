<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*"    
%>
<%
DAO dao = new DAO(); String entry_no = dao.getAutoNo();
%>
<jsp:include page="include/header.jsp" />
<script src="js/js.js"></script>
<section>
<form name="form">
<table border="1">
<thead>
	<tr>
		<th>참가번호</th>
		<td>
		<input type="text" name="entry_no" value="<%=entry_no%>"/> 예)0001
		</td>
	</tr>
	<tr>
		<th>성명</th>
		<td>
		<input type="text" name="entry_name"/>
		</td>
	</tr>
	<tr>
		<th>주민등록번호</th>
		<td>
		<input type="text" name="entry_jumin"/>
		 예)9901011000011
		</td>
	</tr>
	<tr>
		<th>참가부문</th>
		<td>
<select name="entry_type">
<option value="1">기악</option>
<option value="2">민요</option>
<option value="3">무용</option>
<option value="4">판소리</option>
</select>
		</td>
	</tr>
<tr>
	<th>지역</th>
	<td>
	<input type="text" name="entry_area"/>
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