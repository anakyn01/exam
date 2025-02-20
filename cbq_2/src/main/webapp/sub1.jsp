<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="java.util.*,dto.*,dao.*"
    %>
<!DOCTYPE html>
<jsp:include page="include/header.jsp"/>
<section class="content">
<table class="table">
<thead>
    <tr>
<th>고객번호</th><th>고객명</th><th>고객생년월일</th><th>성별</th><th>전화번호</th><th>지역</th>
    </tr>

</thead>
<% DAO dao = new DAO(); ArrayList<DTO> dtos = dao.sub1();%>
<tbody>
    <% for (DTO dto : dtos){%>
    <tr>
        <td><%=dto.getP_no() %></td>
        <td><%=dto.getP_name() %></td>
        <td><%=dto.getP_birth() %></td>
        <td><%=dto.getP_gender() %></td>
        <td><%=dto.getP_tel1() %><%=dto.getP_tel2() %><%=dto.getP_tel3() %></td>
        <td><%=dto.getP_city() %></td>
    </tr>
    <%}%>
</tbody>
</table>
</section>
<jsp:include page="include/footer.jsp"/>