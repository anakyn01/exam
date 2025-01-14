<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="community.*, java.io.PrintWriter" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="bbs" class="community.Board" scope="page"/>
<jsp:setProperty name="bbs" property="writer"/>
<jsp:setProperty name="bbs" property="subject"/>
<jsp:setProperty name="bbs" property="content"/>
<%
if(bbs.getWriter() == null || bbs.getSubject() == null || bbs.getContent() == null){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('입력되지 않은 사항이 있습니다')");
	script.println("history.back()");
	script.println("</script>");
}else{
	//정상적으로 입력이 되엇다면 글쓰기 로직을 수행한다
	BoardDAO boardDAO = new BoardDAO();

    bbs.setWriter(request.getParameter("writer"));
    bbs.setSubject(request.getParameter("subject"));
    bbs.setContent(request.getParameter("content"));
		
	int result = boardDAO.write(bbs.getWriter(), bbs.getSubject(), bbs.getContent());
	
	//데이터 베이스 오류인 경우
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
		script.println("location.href='index.jsp'");
		script.println("</script>");
	}	
}
%>