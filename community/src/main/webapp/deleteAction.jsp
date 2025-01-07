<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.PrintWriter, community.*"%>
<% request.setCharacterEncoding("utf-8");%>
<%
int idx = 0;
if(request.getParameter("idx") != null){
	idx = Integer.parseInt(request.getParameter("idx"));
}
if(idx == 0){//삭제할것이 존재하지 않는다면
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('유효하지 않은 글 입니다')");
	script.println("location.href='index.jsp'");
	script.println("</script>");
}

Board board = new BoardDAO().getBoard(idx);
BoardDAO boardDAO = new BoardDAO();
int result = boardDAO.delete(idx);

//글을 삭제할때 성공과 실패를 표현
if(result == -1){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('글 삭제하기에 실패했습니다')");
	script.println("history.back()");
	script.println("</script>");
}else{
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('글 삭제하기에 성공했습니다')");
	script.println("location.href='index.jsp'");
	script.println("</script>");
}
%>