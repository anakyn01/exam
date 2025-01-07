<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="dao.*,dto.*,java.util.*"
    %>

<%
DAO dao = new DAO();
ArrayList<DTO> dtos = dao.getArtistList();
%>

<jsp:include page="include/header.jsp" flush="false"/>

<section>
<form name="form">
<table>
<colgroup>
<col width="15%"/>
<col width="15%"/>
<col width="25%"/>
<col width="10%"/>
<col width="10%"/>
<col width="25%"/>
</colgroup>
<tr>
				<th>참가번호</th>
				<th>참가자명</th>
				<th>생년월일</th>
				<th>성별</th>
				<th>특기</th>
				<th>소속사</th>
			</tr>
			<%for(DTO dto : dtos) {%>
			<tr>
				<td><%=dto.getA_id()%></td>
				<td><%=dto.getA_name()%></td>
				<td><%=dto.getA_birth()%></td>
				<td><%=dto.getA_gender()%></td>
				<td><%=dto.getTalent()%></td>
				<td><%=dto.getAgency()%></td>
			</tr>
			<%}%>
</table>

</form>

</section>

<jsp:include page="include/footer.jsp" flush="false"/>