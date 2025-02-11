<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dto.*,dao.*,java.util.*"
%>
<%
DAO dao = new DAO(); ArrayList<DTO> dtos = dao.getAllScore();
%>
<jsp:include page="include/header.jsp"/>
<section>
<h2></h2>
<table border="1">
<colgroup>
				<col width="10%">
				<col width="7%">
				<col width="7%">
				<col width="*">
				<col width="9%">
				<col width="7%">
				<col width="5%">
				<col width="5%">
				<col width="5%">
				<col width="5%">
				<col width="5%">
				<col width="7%">
				<col width="7%">
			</colgroup>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>성별</th>
				<th>과목명[코드]</th>
				<th>전공유무</th>
				<th>교수</th>
				<th>중간</th>
				<th>기말</th>
				<th>레포트</th>
				<th>출석</th>
				<th>기타</th>
				<th>총점</th>
				<th>등급</th>
			</tr>
<% for(DTO dto : dtos){ %>
<tr>
				<td><%=dto.getS_id()%></td>
				<td><%=dto.getS_name()%></td>
				<td><%=dto.getJumin()%></td>
				<td><%=dto.getSbj_name()%>[<%=dto.getSbj_code()%>]</td>
				<td><%=dto.getClassf()%></td>
				<td><%=dto.getP_name()%></td>
				<td><%=dto.getMid()%></td>
				<td><%=dto.getFinals()%></td>
				<td><%=dto.getReport()%></td>
				<td><%=dto.getAttend()%></td>
				<td><%=dto.getEtc()%></td>
				<td><%=dto.getTotal()%></td>
				<td><%=dto.getGrade()%></td>
</tr>









<%} %>
</table>
</section>

<jsp:include page="include/footer.jsp"/>