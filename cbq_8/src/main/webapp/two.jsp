<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="include/header.jsp" flush="false"/>

<h1>심사점수등록</h1>
<form action="">
<table>
<colgroup>
<col style="width:30%"/>
<col style="width:70%"/>
</colgroup>

<tr>
<th>선수번호</th><td><input type="text" /></td>
</tr>

<tr>
<th>심사위원1</th><td><input type="text" />최소 1, 최대 10</td>
</tr>
<tr>
<th>심사위원2</th><td><input type="text" />최소 1, 최대 10</td>
</tr>
<tr>
<th>심사위원3</th><td><input type="text" />최소 1, 최대 10</td>
</tr>
<tr>
<th>심사위원4</th><td><input type="text" />최소 1, 최대 10</td>
</tr>
<tr>
<td colspan="3">
<input type="submit" value="등록"/><a href="edit.jsp">수정</a>
<input type="reset" value="다시쓰기"/>
</td>
</tr>
</table>
</form>
<jsp:include page="include/footer.jsp" flush="false"/>