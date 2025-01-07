<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
<link rel="stylesheet" href="css/custom.css"/>
</head>
<body>
<div class="wrap">
<div class="title">
커뮤니티 사이트
</div>
<div class="content_body">
<!--  <p>총 10개의 게시물이 있습니다</p>-->

<form method="post" action="writeAction.jsp">
<h1 style="text-align:center;">게시물 작성</h1>
<table class="table-write">
<colgroup>
<col width="30%"/>
<col width="70%"/>
</colgroup>
<tr>
<td>작성자</td>
<td><input type="text" class="form-control" name="writer"></td>
</tr>
<tr>
<td>제목</td>
<td><input type="text" class="form-control" name="subject"></td>
</tr>
<tr>
<td>내용</td>
<td>
<textarea class="form-control" rows="10" name="content" ></textarea>
</td>
</tr>
</table>
<div class="btn-wrap">
<a href="index.jsp">목록</a>
<input type="submit" value="완료"/>
</div>
</form>
<footer class="footer">
Copyright (C) 2018 정보처리산업기사 ALL Right Reserved
</footer>
</div>

</div>
</body>
</html>