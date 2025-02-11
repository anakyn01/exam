<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<jsp:include page="include/header.jsp" flush="false"/>

<h1>오디션 등록</h1>
<form name="artist">
<table>
<tr>
<th>참가번호</th><td><input type="text" name="a_no"/> *참가번호는 (A000)4자리 입니다</td>
</tr>
<tr>
<th>참가자명</th><td><input type="text" name="a_name"/></td>
</tr>
<tr>
<th>생년월일</th>
<td>
<input type="text" name="t_year"/>년&nbsp;
<input type="text" name="t_month"/>월&nbsp;
<input type="text" name="t_date"/>일
</tr>
<tr>
<th>성별</th>
<td>
<input type="radio" name="gender" value="M"/>남성&nbsp;
<input type="radio" name="gender" value="F"/>여성</td>
</tr>
<tr>
<th>특기</th>
<td>
<select name="talent">
<option value="">특기선택</option>
<option value="1">댄스</option>
<option value="2">노래</option>
<option value="3">랩</option>
</select>
</td>
</tr>
<tr>
<th>소속사</th><td><input type="text" name="agency"/></td>
</tr>
<tr>
<td colspan="2">
<input type="button" value="오디션 등록" onclick="goSave()"/>
<input type="button" value="다시쓰기" onclick="goReset()"/>
</td>
</tr>
</table>
</form>

<jsp:include page="include/footer.jsp" flush="false"/>