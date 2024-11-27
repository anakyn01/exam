<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.PrintWriter, member.*, java.util.ArrayList"%>
<jsp:include page="include/header.jsp" flush="false"/>


<section class="body_color center">
<div>
<h1 class="text-center" style="margin-bottom:30px;">홈쇼핑 회원 목록/조회</h1>
<form method="post" action="">
<table class="table">
<colgroup>
<col style="width:10%"/>
<col style="width:10%"/>
<col style="width:15%"/>
<col style="width:35%"/>
<col style="width:10%"/>
<col style="width:10%"/>
<col style="width:10%"/>
</colgroup>
<thead>
<tr>
<td class="text-center">
회원번호
</td>
<td class="text-center">
회원성명
</td>
<td class="text-center">
전화번호
</td>
<td class="text-center">
주소
</td>
<td class="text-center">
가입일자
</td>
<td class="text-center">
고객등급
</td>
<td class="text-center">
거주지역
</td>
</tr>
</thead>
<tbody>
<%
MemberDAO memberDAO = new MemberDAO();//실제 사용객체 (인스턴스) 생성
ArrayList<Member> list = memberDAO.getList();
for (int i=0; i < list.size(); i++){
%>
<tr>
<td>
<a href="memberEdit.jsp?custno=<%=list.get(i).getCustno()%>">
<%=list.get(i).getCustno()%>
</a>
</td>
<td><%=list.get(i).getCustname() %></td>
<td><%=list.get(i).getPhone() %></td>
<td><%=list.get(i).getAddress() %></td>
<td><%=list.get(i).getJoindate() %></td>
<td><%=list.get(i).getGrade() %></td>
<td><%=list.get(i).getCity() %></td>
</tr>
<%}%>
</tbody>


</table>
</form>
</div>

</section>



<jsp:include page="include/footer.jsp" flush="false"/>