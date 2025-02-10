<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import = "dao.*, dto.*, java.util.*"
%>
<%
request.setCharacterEncoding("utf-8");
DAO dao = new DAO();
String empno = request.getParameter("t_empno");
ArrayList<DTO> dtos = dao.getContractList(empno);
%>
<jsp:include page="include/header.jsp"/>

<section>
<% if(dtos.size() > 0){ %>
<h2><%=empno %>님의 좌석예약조회</h2>
<form name="seat">
<table>
<colgroup>
<col width="15%"/>
<col width="15%"/>
<col width="30%"/>
<col width="10%"/>
<col width="15%"/>
<col width="15%"/>
</colgroup>
<tr>
<th>사원번호</th><th>이름</th><th>예약일자</th><th>좌석번호</th><th>좌석위치</th><th>내선번호</th>
</tr>
<% for(DTO dto:dtos){ %>
<tr>
<td><%=empno %></td>
<td><%=dto.empname %></td>
<td><%=dto.resvdate %></td>
<td><%=dto.seatno %></td>
<td><%=dto.office %></td>
<td><%=dto.callno %></td>
</tr>
<%} %>
<tr>
<td colspan="6">
<button onclick="location.href='sub_2.jsp'">돌아가기</button>
</td>
</tr>
</table>
<%}else{ %>
<h2>좌석예약조회</h2>
<table>
<tr>
<th>좌석예약 정보가 존재하지 않습니다</th>
</tr>
<tr>
<td>
<button onclick="location.href='sub_2.jsp'">돌아가기</button>
</td>
</tr>
</table>
<%} %>
</form>
</section>

<jsp:include page="include/footer.jsp"/>