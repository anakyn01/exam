<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dto.*,dao.*,java.util.*"
%>
<%
	DAO dao = new DAO();
	ArrayList<DTO> dtos = dao.getStudentScore();
%>
<jsp:include page="include/header.jsp"/>
	<section>
		<h2>개인성적조회</h2>
		<table border="1" class="small">
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>학위과정</th>
				<th>총수강과목수</th>
				<th>총점</th>
				<th>평균</th>
			</tr>
			<%for(DTO dto : dtos){ %>
			<tr>
				<td><%=dto.getS_id()%></td>
				<td><%=dto.getS_name()%></td>
				<td><%=dto.getCourse()%></td>
				<td><%=dto.getMid()%></td>
				<td><%=dto.getStrtotal()%></td>
				<td><%=dto.getStravg()%></td>
			</tr>
			<%} %>
		</table>
	</section>

<jsp:include page="include/footer.jsp"/>