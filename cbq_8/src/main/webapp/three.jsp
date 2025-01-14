<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="include/header.jsp" flush="false"/>

<h1>심사 점수 조회</h1>
<table>
<colgroup>
<col style="width:10%"/>
<col style="width:10%"/>
<col style="width:15%"/>
<col style="width:15%"/>
<col style="width:15%"/>
<col style="width:15%"/>
<col style="width:10%"/>
<col style="width:10%"/>
</colgroup>
<thead>
<tr>
<th>선수번호</th><th>선수명</th><th>심사위원1</th><th>심사위원2</th><th>심사위원3</th><th>심사위원4</th><th>총점</th><th>평균</th>
</tr>
</thead>
</table>

<jsp:include page="include/footer.jsp" flush="false"/>