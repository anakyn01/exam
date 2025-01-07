<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="include/header.jsp" flush="false"/>

<h1>참가자등수조회</h1>
<table>
<colgroup>
<col style="width:5%"/>
<col style="width:10%"/>
<col style="width:25%"/>
<col style="width:20%"/>
<col style="width:10%"/>
<col style="width:25%"/>
<col style="width:5%"/>
</colgroup>
<thead>
<tr>
<th>선수번호</th><th>선수명</th><th>국적</th><th>기술난이도</th><th>총점</th><th>평균</th><th>등수</th>
</tr>
</thead>
</table>

<jsp:include page="include/footer.jsp" flush="false"/>