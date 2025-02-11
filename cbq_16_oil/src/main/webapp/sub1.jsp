<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="include/header.jsp" flush="false"/>
<script src="js/js.js">
</script>
<div class="text-center">
<h1>매출등록</h1>
<form method="post">
<table>
<tr>
<th>매출번호</th><td><input type="text" class="" name=""/>예)9001</td>
</tr>
<tr>
<th>주유일자</th><td><input type="text" class="" name=""/>예)20201001</td>
</tr>
<tr>
<th>유종</th>
<td>
<select>
<option value="">유종선택</option>
<option value="">[1]휘발유</option>
<option value="">[2]고급휘발유</option>
<option value="">[3]경유</option>
<option value="">[4]등유</option>
</select>
</td>
</tr>
<tr>
<th>주유량</th><td><input type="text" class="" name="amount"/>리터</td>
</tr>
<tr>
<th>결제방법</th><td><input type="text" class="" name="paytype"/>(1:현금/2카드)</td>
</tr>
<tr>
<th>고객번호</th>
<td><input type="text" class="" name="custno"/></td>
</tr>
<tr>
<th>카드번호</th>
<td>
<input type="text" class="" name="credit1"/>-
<input type="text" class="" name="credit2"/>-
<input type="text" class="" name="credit3"/>-
<input type="text" class="" name="credit4"/>
</td>
</tr>
<tr>
<th>금액</th><td><input type="text" class="" name="oilcost"/></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="결제" onclick="goSave()"/>
<input type="reset" value="다시쓰기" onclick="goReset()"/>
</td>
</tr>
</table>
</form>
</div>


<jsp:include page="include/footer.jsp" flush="false"/>