<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="include/header.jsp"/>
<script src="js/js.js"></script>
<section>
<h2></h2>
<table border="1">
<tr>
	<th>매수일자</th>
	<td>
		<input type="text" name="buy_date">2022년 3월 2일 예)20220302
	</td>
</tr>
<tr>
	<th>종목명</th>
	<td>
		<select name="s_name" onchange="CodeInsert()">
			<option value="">=종목명=</option>
			<option value="100001">[100001]삼성전자</option>
			<option value="100002">[100002]카카오</option>
			<option value="100003">[100003]셀트리온헬스케어</option>
			<option value="100004">[100004]펄어비스</option>
			<option value="100005">[100005]2차전지사업ETF</option>
		</select>
	</td>
</tr>
<tr>
	<th>종목코드</th>
	<td class="td_left">
		<input type="text" name="s_code" readonly>
	</td>
</tr>
<tr>
	<th>매수수량</th>
	<td class="td_left">
		<input type="text" name="buy_number">주
	</td>
</tr>
<tr>
	<th>매수가격</th>
	<td class="td_left">
		<input type="text" name="buy_price">원
	</td>
</tr>
<tr>
	<th>부서코드</th>
	<td class="td_left">
		<select name="dept_code">
			<option value="">=부서=</option>
			<option value="100">[100]국내펀드1팀</option>
			<option value="200">[200]가치주펀드1팀</option>
			<option value="300">[300]배당주펀드1팀</option>
			<option value="400">[400]채권혼합펀드1팀</option>
		</select>
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="button" value="주식매수등록" onclick="goSave()">
		<input type="button" value="다시쓰기" onclick="goReset()">
	</td>
</tr>
</table>
</section>

<jsp:include page="include/footer.jsp"/>