<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="java.io.PrintWriter, member.*"%>
<%
int custno = 0;//초기화
if(request.getParameter("custno") != null){
	custno = Integer.parseInt(request.getParameter("custno"));
}
Member member = new MemberDAO().getMember(custno);
//Read매서드인데 다오에서 아직 작성안함
%>
    
    
<jsp:include page="include/header.jsp" flush="false"/>


<section class="body_color center">
<div>
<h1 class="text-center" style="margin-bottom:30px;">홈쇼핑 회원 등록</h1>
<form method="post" action="updateAction.jsp?custno=<%=custno%>">
<table class="table">
<colgroup>
<col style="width:30%"/>
<col style="width:70%"/>
</colgroup>
<tr>
<td class="text-center">
회원번호
</td>
<td>
<input 
type="text" 
name="custno" 
class="form-control"
value="<%=member.getCustno() %>"
/>
</td>
</tr>
<tr>
<td class="text-center">
회원성명
</td>
<td>
<input 
type="text" 
name="custname" 
class="form-control"
value="<%=member.getCustname() %>"
/>
</td>
</tr>
<tr>
<td class="text-center">
회원전화
</td>
<td>
<input 
type="text" 
name="phone" 
class="form-control"
value="<%=member.getPhone() %>"
/>
</td>
</tr>
<tr>
<td class="text-center">
회원주소
</td>
<td>
<input 
type="text" 
name="address" 
class="form-control"
value="<%=member.getAddress() %>"
/>
</td>
</tr>
<tr>
<td class="text-center">
가입일자
</td>
<td>
<input 
type="text" 
name="joindate" 
class="form-control"
value="<%=member.getJoindate() %>"
/>
</td>
</tr>
<tr>
<td class="text-center">
고객등급(A:VIP,B:일반,C:직원)
</td>
<td>
<input 
type="text" 
name="grade" 
class="form-control"
value="<%=member.getGrade() %>"
/>
</td>
</tr>
<tr>
<td class="text-center">
도시코드
</td>
<td>
<input 
type="text" 
name="city" 
class="form-control"
value="<%=member.getCity() %>"
disabled="disabled"
/>
</td>
</tr>
<tr>
<td colspan="2" class="text-center">
<input type="submit" value="수정"/>
<button type="submit">조회</button>
</td>
</tr>
</table>
</form>
</div>

</section>



<jsp:include page="include/footer.jsp" flush="false"/>