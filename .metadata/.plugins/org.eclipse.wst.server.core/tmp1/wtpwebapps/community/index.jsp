<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.PrintWriter, community.*, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 사이트</title>
<link rel="stylesheet" href="css/custom.css"/>
</head>
<body>
<div class="wrap">
<div class="title">
커뮤니티 사이트
</div>
<div class="content_body">
<p>총 10개의 게시물이 있습니다</p>
</div>
<table class="table">
<colgroup>
<col width="10%"/>
<col width="50%"/>
<col width="15%"/>
<col width="25%"/>
</colgroup>
<thead>
<tr>
<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
</tr>
</thead>
<tbody>
<%
BoardDAO boardDAO = new BoardDAO(); //실제 사용객체 (인스턴스) 생성
ArrayList<Board> list = boardDAO.getList();
for (int i =0; i < list.size(); i++){
%>
<tr>
<td><%=list.get(i).getIdx()%></td><!-- 글의 순번 -->
<td>
<a href="read.jsp?idx=<%=list.get(i).getIdx()%>">
<%=list.get(i).getSubject() %><!-- 제목 -->
</a>
</td>
<td>
<%=list.get(i).getWriter() %>
</td>
<td>
<%=list.get(i).getDate() %>
</td>
</tr>
<%} %>
</tbody>
</table>
<div class="btn-wrap">
<a href="write.jsp">작성</a>
</div>

<footer class="footer">
Copyright (C) 2018 정보처리산업기사 ALL Right Reserved
</footer>


</div>
</body>
</html>