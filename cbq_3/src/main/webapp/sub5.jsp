<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="dao.*,dto.*,java.util.*"
    %>
<%
DAO dao = new DAO();
ArrayList<DTO> dtos = dao.getRanking();
%>
<jsp:include page="include/header.jsp" flush="false"/>

<section>
<h1>멘토점수 조회</h1>
<table>
			<colgroup>
				<col width="20%">
				<col width="20%">
				<col width="15%">
				<col width="15%">
				<col width="15%">
				<col width="15%">
			</colgroup>
			<tr>
				<th>참가번호</th>
				<th>참가자명</th>
				<th>성별</th>
				<th>총점</th>
				<th>평균</th>
				<th>등수</th>
			</tr>
<%int k=1; for(DTO dto:dtos){%>
<tr>
<td><%=dto.getA_id()%></td>
<td><%=dto.getA_name()%></td>
<td><%=dto.getA_gender()%></td>
<td><%=dto.getTotal()%></td>
<td><%=dto.getAva()%></td>
<td><%=k%>%></td>
</tr>
<%k++;}%>
</table>

</section>

<jsp:include page="include/footer.jsp" flush="false"/>