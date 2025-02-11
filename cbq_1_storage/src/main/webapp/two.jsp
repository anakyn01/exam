<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="include/header.jsp" flush="false" />

<h1>입출고 등록</h1>
<form method="POST" action="writeAction.jsp">
<table>
<colgroup>
<col style="width:20%"/>
<col style="width:80%"/>
</colgroup>

<tr>
<th>입출고 번호</th><td><input type="text" name="t_no"/></td>
</tr>
<tr>
<th>제품코드</th><td><input type="text" name="p_code"/></td>
</tr>
<tr>
<th>입출고구분</th>
<td>
<input type="radio" name="t_type" value="I" checked/>입고
<input type="radio" name="t_type" value="O"/>출고
</td>
</tr>
<tr>
<th>수량</th><td><input type="text" name="t_cnt"/></td>
</tr>
<tr>
<th>거래일자</th><td><input type="text" name="t_date"/></td>
</tr>
<tr>
<th>거래처</th>
<td>
<select name="c_code">
<option value=""></option>
<option value="10">서울공장</option>
<option value="20">울산공장</option>
<option value="30">부산상사</option>
<option value="40">광주상사</option>
<option value="50">대전상사</option>
</select>
</td>
</tr>
<tr>
<th colspan="2">
<input type="submit" value="입출고 등록"/> <input type="reset" value="다시쓰기"/>
</th>
</tr>

</table>
</form>
<jsp:include page="include/footer.jsp" flush="false" />