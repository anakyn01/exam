<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import ="member.*, java.io.PrintWriter"
%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="member" class="member.Member" scope="page"/>
<jsp:setProperty name="member" property="custno"/>
<jsp:setProperty name="member" property="custname"/>
<jsp:setProperty name="member" property="phone"/>
<jsp:setProperty name="member" property="address"/>
<jsp:setProperty name="member" property="joindate"/>
<jsp:setProperty name="member" property="grade"/>
<jsp:setProperty name="member" property="city"/>
<%
if(member.getCustname() == null || member.getPhone() == null || member.getAddress() == null || member.getGrade() == null || member.getCity() == null){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('입력되지 않은 사항이 있습니다')");
	script.println("history.back()");
	script.println("</script>");
}else{
	//정상적으로 입력이 되었다면 글쓰기 로직을 수행한다
	MemberDAO memberDAO = new MemberDAO();
	member.setCustname(request.getParameter("custname"));
	member.setPhone(request.getParameter("phone"));
	member.setAddress(request.getParameter("address"));
	member.setGrade(request.getParameter("grade"));
	member.setCity(request.getParameter("city"));
	
	
	int result = memberDAO.write(member.getCustname(), member.getPhone(), member.getAddress(), member.getGrade(), member.getCity());
	
	//데이터 베이스 오류
	if(result == -1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('글쓰기에 실패하였습니다')");
		script.println("history.back()");
		script.println("</script>");
	}else{
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('글쓰기 성공')");
		script.println("location.href='memberList.jsp'");
		script.println("</script>");
	}

}

%>