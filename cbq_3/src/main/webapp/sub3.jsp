<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="dao.*,dto.*,java.util.*"
    %>
<%
DAO dao = new DAO();
ArrayList<DTO> aList = dao.getNoPointArtist();
%>

<jsp:include page="include/header.jsp" flush="false"/>

<section>
<h1>멘토점수 등록</h1>
<form name="point">
<table>
<colgroup>
<col width="20%"/>
<col width="80%"/>
</colgroup>
<tr>
<th>참가번호</th>
<td>
<select name="artist">
<option value="">==참가자선택==</option>
<%for(DTO dto : aList){ %>
<option value="<%=dto.getA_id()%>">[<%=dto.getA_id()%>]<%=dto.getA_name() %></option>%>
<%}%> 
</select>
</td>
</tr>
<tr>
	<th>함멘토 점수</th>
	<td><input type="text" name="point_1"></td>
</tr>
<tr>
	<th>박멘토 점수</th>
	<td><input type="text" name="point_2"></td>
</tr>
<tr>
	<th>박멘토 점수</th>
	<td><input type="text" name="point_3"></td>
</tr>
<tr>
	<td class="btn" colspan="2">
		<input type="button" onclick="goSave()" value="점수등록">
		<input type="button" onclick="goReset()" value="다시쓰기">
	</td>
</tr>
</table>

</form>

</section>

<jsp:include page="include/footer.jsp" flush="false"/>