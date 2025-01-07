<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>

<table style="width:1000px;">
<colgroup>
<col style="width:10%"/>
<col style="width:10%"/>
</colgroup>
<thead>
<tr>
<th>예방접종 이력번호</th><td><input type="text" name=""/>예) 20202021</td>
</tr>
<tr>
<th>고객번호</th><td><input type="text" name=""/></td>
</tr>
<tr>
<th>백신코드</th><td><input type="text" name=""/></td>
</tr>
<tr>
<th>접종일자</th><td><input type="text" name=""/></td>
</tr>
<tr>
<td colspan="2" style="text-align:center">
<input type="submit" value="예방접종등록"/>
<input type="reset" value="다시쓰기"/>
</td>
</tr>
</thead>
<tbody></tbody>
</table>

<%@ include file="include/footer.jsp" %>