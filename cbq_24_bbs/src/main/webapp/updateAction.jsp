<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.PrintWriter, community.*"%>
<% request.setCharacterEncoding("utf-8"); %>
<%
int idx = 0;
if(request.getParameter("idx") != null){
	idx = Integer.parseInt(request.getParameter("idx"));
}
Board board = new BoardDAO().getBoard(idx);
if(idx == 0){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('아영이 너에 오타')");
	script.println("location.href='index.jsp'");
	script.println("</script>");
}


if(request.getParameter("writer")==null || request.getParameter("subject")==null || request.getParameter("content") == null
|| request.getParameter("writer").equals("") || request.getParameter("subject").equals("") || request.getParameter("content").equals("")){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('입력이 안된 사항이 있습니다')");
	script.println("location.href='index.jsp'");
	script.println("</script>");
}else{//정상적으로 입력이 되었다면 글 수정 로직을 수행한다
	BoardDAO boardDAO = new BoardDAO();
	int result = boardDAO.update(request.getParameter("boardWriter"), request.getParameter("boardSubject"),request.getParameter("boardContent"), idx);
	//int result = boardDAO.update(boardWriter, boardSubject, boardContent, idx);
	if(result == -1) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('글 수정하기에 실패했습니다ㅣ')");
		script.println("history.back()");
		script.println("</script>");
	}else{//글쓰기 로직이 성공한다면 메인페이지로 이동
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('글 수정에 성공했습니다')");
		script.println("location.href='index.jsp'");
		script.println("</script>");
	}
}






%>
