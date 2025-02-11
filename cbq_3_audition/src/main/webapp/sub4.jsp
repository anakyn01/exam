<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="dao.*,dto.*,java.util.*"
    %>
<%
DAO dao = new DAO();
ArrayList<DTO> dtos = dao.getMentoPointList();
%>
<jsp:include page="include/header.jsp" flush="false"/>

<section>
<h1>멘토점수 조회</h1>
<table>
			<colgroup>
				<col width="15%">
				<col width="15%">
				<col width="15%">
				<col width="25%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<tr>
				<th>채점번호</th>
				<th>참가번호</th>
				<th>참가자명</th>
				<th>생년월일</th>
				<th>점수</th>
				<th>평점</th>
				<th>멘토</th>
			</tr>
<%for(DTO dto:dtos){%>
<tr>
<td><%=dto.getS_no()%></td>
<td><%=dto.getA_id()%></td>
<td><%=dto.getA_name()%></td>
<td><%=dto.getA_birth()%></td>
<td><%=dto.getPoint()%></td>
<td>
<%
int point = Integer.parseInt(dto.getPoint());
if(point>=90){out.print("A");}
else if(point>=80){out.print("B");}
else if(point>=70){out.print("C");}
else if(point>=60){out.print("D");}
else{out.print("F");}
%>
</td>
<td><%=dto.getM_name()%></td>
</tr>
<%}%>
</table>

</section>

<jsp:include page="include/footer.jsp" flush="false"/>