<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="java.io.PrintWriter, member.*, java.util.ArrayList"
    %>
<jsp:include page="include/header.jsp" flush="false"/>


<section class="body_color center">
<div>
<h1 class="text-center" style="margin-bottom:30px;">회원매출 조회</h1>
<form method="post" action="">
<table class="table">
<colgroup>
<col style="width:25%"/>
<col style="width:25%"/>
<col style="width:25%"/>
<col style="width:25%"/>

</colgroup>
<tr>
<td class="text-center">
회원번호
</td>
<td class="text-center">
회원성명
</td>
<td class="text-center">
고객등급
</td>
<td class="text-center">
매출
</td>
</tr>

<tbody>
<%
NewDAO newDAO = new NewDAO();//실제 사용객체 (인스턴스) 생성
ArrayList<New> list = newDAO.getListt();
for (int i=0; i < list.size(); i++){
%>
<tr>
<td>
<%=list.get(i).getCustno()%>
</td>
<td><%=list.get(i).getCustname() %></td>
<td><%=list.get(i).getVip() %></td>
<td><%=list.get(i).getPrice() %></td>

</tr>
<%}%>
</tbody>
</table>
</form>
</div>

</section>



<jsp:include page="include/footer.jsp" flush="false"/>