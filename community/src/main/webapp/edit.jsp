<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.PrintWriter, community.*"%>
<%
int idx = 0;//초기화 
if(request.getParameter("idx") != null){
	idx = Integer.parseInt(request.getParameter("idx"));
}
if(idx == 0){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('김숙 너에 오타')");
	script.println("window.location.href='index.jsp'");
	script.println("</script>");
}
Board board =new BoardDAO().getBoard(idx);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
<link rel="stylesheet" href="css/custom.css"/>
</head>
<body>
<div class="wrap">
<div class="title">
커뮤니티 사이트 수정
</div>
<div class="content_body">
<!--  <p>총 10개의 게시물이 있습니다</p>-->

<form method="post" action="updateAction.jsp?idx=<%=idx%>">
<h1 style="text-align:center;">게시물 작성</h1>
<table class="table-write">
<colgroup>
<col width="30%"/>
<col width="70%"/>
</colgroup>
<tr>
<td>작성자</td>
<td>
<input 
type="text" 
class="form-control" 
name="writer"
value="<%=board.getWriter()%>"
>
</td>
</tr>
<tr>
<td>제목</td>
<td>
<input 
type="text" 
class="form-control" 
name="subject"
value="<%=board.getSubject() %>"
>
</td>
</tr>
<tr>
<td>내용</td>
<td>
<textarea name="content" class="form-control" rows="10" ><%=board.getContent()%></textarea>
</td>
</tr>
</table>
<div class="btn-wrap">
<a href="index.jsp">목록</a>
<input type="submit" value="수정하기"/>
<button>delete</button>
</div>
</form>
<footer class="footer">
Copyright (C) 2018 정보처리산업기사 ALL Right Reserved
</footer>
</div>

</div>
</body>
</html>