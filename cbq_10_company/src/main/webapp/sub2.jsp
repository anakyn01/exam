<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"

%>
<jsp:include page="include/header.jsp"/>
<section>
<h2>사원 등록/수정</h2>
		<table border="1" class="small">
			<tr>
				<th>사원번호</th>
				<td class="td_left">
					<input type="text" name="e_no">
				</td>
			</tr>
			<tr>
				<th>사원명</th>
				<td class="td_left">
					<input type="text" name="e_name">
				</td>
			</tr>
			<tr>
				<th>부서</th>
				<td class="td_left">
					<input type="radio" value="01" name="e_depart">인사&nbsp;&nbsp;
					<input type="radio" value="02" name="e_depart">총무&nbsp;&nbsp;
					<input type="radio" value="03" name="e_depart">영업&nbsp;&nbsp;
					<input type="radio" value="04" name="e_depart">생산
				</td>
			</tr>
			<tr>
				<th>직위</th>
				<td class="td_left">
					<select name="e_level">
						<option value="10">이사</option>
						<option value="20">부장</option>
						<option value="30">과장</option>
						<option value="40">대리</option>
						<option value="50">사원</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>근무지</th>
				<td class="td_left">
					<select name="e_work_place">
						<option value="31">대전영업소</option>
						<option value="32">청주영업소</option>
						<option value="33">공주영업소</option>
						<option value="40">충남본부</option>
						<option value="50">본사</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>실적</th>
				<td class="td_left">
					<select name="perfomance">
						<option value="A">A등급</option>
						<option value="B">B등급</option>
						<option value="C">C등급</option>
						<option value="D">D등급</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="등록" onclick="goSave()">
					<input type="button" value="수정" onclick="goUpdate()">
					<input type="button" value="다시쓰기" onclick="goReset()">
				</td>
			</tr>
		</table>
</section>

<jsp:include page="include/footer.jsp"/>