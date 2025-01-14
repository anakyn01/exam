<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.PrintWriter, community.*"%>
<%
int idx = 0;
if(request.getParameter("idx") != null){
	idx = Integer.parseInt(request.getParameter("idx"));
	//parseint : 문자열을 파싱[구문분석]하여 특정진수의 정수로 리턴
	//문장이 이루고 있는 구성성분을 분해하고 성분의 위계 관계를 분석하여 결정
}

//만약 넘어온 데이터가 없다면
if(idx == 0){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('개발자여 오타 났음')");
	script.println("window.location.href='index.jsp'");
	script.println("</script>");
}

//오타가 (99번 까지 오타 100번재 네트워크 오류)나지 않앗다면 구체적인 실존하는 글에 정보를 담는다
Board board = new BoardDAO().getBoard(idx);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회</title>
<link rel="stylesheet" href="css/custom.css"/>
</head>
<body>
<div class="wrap">
<div class="title">
커뮤니티 사이트
</div>
<div class="content_body">
<!--  <p>총 10개의 게시물이 있습니다</p>-->

<form method="post" action="">
<h1 style="text-align:center;">게시물 조회</h1>
<p>제목 : 
<%= board.getSubject() %>
</p>
<p>작성자 : <%= board.getWriter() %> <span>작성일 : <%= board.getDate() %></span></p>
<p>
내용 :<%= board.getContent() %>
</p>
<div class="btn-wrap">
<a href="index.jsp">목록</a>
<a href="edit.jsp?idx=<%=idx%>">수정</a>
<a href="deleteAction.jsp?idx=<%=idx%>" onclick="return confirm('정말로 삭제하시겠습니까?')">
삭제
</a>
</div>
</form>
<footer class="footer">
Copyright (C) 2018 정보처리산업기사 ALL Right Reserved
</footer>
</div>

</div>
</body>
</html>