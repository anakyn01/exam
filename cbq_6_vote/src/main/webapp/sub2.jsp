<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="include/header.jsp"/>
<script src="js/js.js"></script>
<section>
<form name="form">
<h1>투표하기</h1>
<table>
<tr>
<th>주민번호</th>
<td>
<input type="text" name="v_jumin" class="">
예)9901011000001
</td>
</tr>

<tr>
<th>성명</th>
<td>
<input type="text" name="v_name" class="">
</td>
</tr>

<tr>
<th>후보번호</th>
<td>
<select name="m_no">
<option value="">후보번호</option>
<option value="1">[1] 김후보</option>
<option value="2">[2] 이후보</option>
<option value="3">[3] 박후보</option>
<option value="4">[4] 조후보</option>
<option value="5">[5] 박후보</option>
</select>
</td>
</tr>

<tr>
<th>투표시간</th>
<td>
<input type="text" name="v_time" class="">
</td>
</tr>

<tr>
<th>투표장소</th>
<td>
<input type="text" name="v_area" class="">
</td>
</tr>

<tr>
<th>유권자 확인</th>
<td>
<input type="radio" name="v_confirm" value="Y">확인&nbsp;&nbsp;
<input type="radio" name="v_confirm" value="N">미확인
</td>
</tr>

<tr>
<td colspan="2">
<input type="button" value="투표하기" onclick="goVote()">
<input type="button" value="다시쓰기" onclick="Reset()">
</td>
</tr>








</table>
</form>
</section>

<jsp:include page="include/footer.jsp"/>