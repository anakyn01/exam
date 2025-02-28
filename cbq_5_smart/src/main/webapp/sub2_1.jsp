<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import = "dao.*, dto.*, java.util.*"
%>
<jsp:include page="include/header.jsp"/>
<script src="js/js.js"></script>
<form name="form">
<section>
<h2>작업지시등록</h2>
<table border=1>
<tr>
	<th>작업지시번호</th>
		<td>
		<input type="text" name="w_workno">
	</td>
</tr>
<tr>
	<th>제품코드</th>
	<td>
		<select name="p_code">
		<% DAO dao = new DAO(); ArrayList<DTO> dtos = dao.getProductCodeList(); %>
		<%for (DTO dto:dtos){ %>
<option value="<%=dto.getP_code()%>">[<%=dto.getP_code()%>]<%=dto.getP_name()%></option>
		<%} %>
		</select>
	</td>
</tr>
<tr>
	<th>수량</th>
		<td>
		<input type="text" name="w_quentity">
	</td>
</tr>
<tr>
	<th>작업시작일</th>
		<td>
		<input type="text" name="w_workdate">
	</td>
</tr>
	<tr>
<td colspan="2">
<input type="button" onclick="goSave()" value="작업지시등록">
<input type="button" onclick="FormReset()" value="다시쓰기">
</td>
	</tr>	
</table>
</section>
</form>

<jsp:include page="include/footer.jsp"/>