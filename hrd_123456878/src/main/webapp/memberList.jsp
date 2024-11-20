<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="include/header.jsp" flush="false"/>


<section class="body_color center">
<div>
<h1 class="text-center" style="margin-bottom:30px;">홈쇼핑 회원 목록/조회</h1>
<form method="post" action="">
<table class="table">
<colgroup>
<col style="width:10%"/>
<col style="width:10%"/>
<col style="width:15%"/>
<col style="width:35%"/>
<col style="width:10%"/>
<col style="width:10%"/>
<col style="width:10%"/>
</colgroup>
<tr>
<td class="text-center">
회원번호
</td>
<td class="text-center">
회원성명
</td>
<td class="text-center">
전화번호
</td>
<td class="text-center">
주소
</td>
<td class="text-center">
가입일자
</td>
<td class="text-center">
고객등급
</td>
<td class="text-center">
거주지역
</td>
</tr>

</table>
</form>
</div>

</section>



<jsp:include page="include/footer.jsp" flush="false"/>