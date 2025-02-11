<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="include/header.jsp"/>
<script src="js/js.js"></script>
<h2>개인성적등록</h2>
<form name="form">
		<table border="1" class="small">
			<tr>
				<th>학번</th>
				<td class="td_left">
					<input type="text" name="s_id" class="input120">
				</td>
			</tr>
			<tr>
				<th>수강코드</th>
				<td class="td_left">
					<input type="text" name="sbj_code" class="input120">
					예)S001
				</td>
			</tr>
			<tr>
				<th>중간 30% (0~100)</th>
				<td class="td_left">
					<input type="text" name="mid" class="input80">
				</td>
			</tr>
			<tr>
				<th>기말 30% (0~100)</th>
				<td class="td_left">
					<input type="text" name="finals" class="input80">
				</td>
			</tr>
			<tr>
				<th>레포트 20% (0~100)</th>
				<td class="td_left">
					<input type="text" name="report" class="input80">
				</td>
			</tr>
			<tr>
				<th>출석 10% (0~100)</th>
				<td class="td_left">
					<input type="text" name="attend" class="input80">
				</td>
			</tr>
			<tr>
				<th>기타 10% (0~100)</th>
				<td class="td_left">
					<input type="text" name="etc" class="input80">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="등록" onclick="goScoreSave()">
					<input type="button" value="다시등록" onclick="goReset()">
				</td>
			</tr>
		
		</table>
		</form>
	</section>

<jsp:include page="include/footer.jsp"/>