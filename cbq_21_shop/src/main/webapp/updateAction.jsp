<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="java.io.PrintWriter, member.*"
%>
<% request.setCharacterEncoding("utf-8"); %>
<%
int custno = 0;
if(request.getParameter("custno") != null){
	custno = Integer.parseInt(request.getParameter("custno"));
}
Member member = new MemberDAO().getMember(custno);
if(custno == 0){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('ojdbc나 디벨로퍼를 확인하세요')");
	script.println("location.href='memberList.jsp'");
	script.println("</script>");
}

if(request.getParameter("custname")==null || request.getParameter("phone")==null || request.getParameter("address")==null ||
request.getParameter("custname").equals("") || request.getParameter("phone").equals("") || request.getParameter("address").equals("") 
		){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('입력이 안된 사항이 있습니다')");
	script.println("history.back()");
	script.println("</script>");
}else{
	MemberDAO memberDAO = new MemberDAO();
	int result = memberDAO.update(request.getParameter("custname"), request.getParameter("phone"), request.getParameter("address"), custno);
	if(result == -1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('글수정하기를 실패하였습니다')");
		script.println("location.href='memberEdit.jsp'");
		script.println("</script>");		
	}else{
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('글수정에 성공 했습니다')");
		script.println("location.href='memberList.jsp'");
		script.println("</script>");
	}
}

%>
