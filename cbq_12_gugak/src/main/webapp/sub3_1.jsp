<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*, dto.*"    
%>
<%
DAO dao = new DAO(); 
String entry_no = request.getParameter("entry_no");
DTO dto = dao.getResultList(entry_no);
if(dto.getEntry_no()==null){
%>
<script>
location.href="sub3_2.jsp";
</script>
<%}else{ %>
<jsp:include page="include/header.jsp" />

<section>
<table border="1">
<thead>
	<tr>
		<th>참가번호</th>
		<td>
<%=dto.getEntry_no() %>
		</td>
	</tr>
	<tr>
		<th>성명</th>
		<td>
<%=dto.getEntry_name() %>
		</td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td>
<%=dto.getEntry_jumin() %>
		</td>
	</tr>
	<tr>
		<th>참가부문</th>
		<td>
<%=dto.getEntry_type() %>
		</td>
	</tr>
	<tr>
		<th>지역</th>
		<td>
<%=dto.getEntry_area() %>
		</td>
	</tr>	
	<tr>
		<th>김심사</th>
		<td>
<%=dto.getScore1() %>
		</td>
	</tr>
     <tr>
		<th>이심사</th>
		<td>
<%=dto.getScore2() %>
		</td>
	</tr>
	<tr>
		<th>박심사</th>
		<td>
<%=dto.getScore3() %>
		</td>
	</tr>
	<tr>
		<th>황심사</th>
		<td>
<%=dto.getScore4() %>
		</td>
	</tr>
	<tr>
		<th>조심사</th>
		<td>
<%=dto.getScore5() %>
		</td>
	</tr>
     <tr>
		<th>총점</th>
		<td>
<%=dto.getS_tot() %>
		</td>
	</tr>
	<tr>
		<th>평균</th>
		<td>
<%=dto.getS_ave() %>
		</td>
	</tr>
<tr>
<td colspan="2">
<input type="button" value="돌아가기" onclick="location.href='sub3.jsp'">
</td>
</tr>
</thead>
<tbody>

</tbody>
</table>
</section>

<jsp:include page="include/footer.jsp" />
<%}%>