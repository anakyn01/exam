<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import ="cbq_1.*, java.util.ArrayList"
%>
<jsp:include page="include/header.jsp" flush="false" />


<h1>입출고 내역 조회</h1>

<table>
<colgroup>
<col style="width:10%"/>
<col style="width:10%"/>
<col style="width:20%"/>
<col style="width:20%"/>
<col style="width:10%"/>
<col style="width:20%"/>
<col style="width:10%"/>
</colgroup>
<thead>
<tr>
<th>입출고번호</th><th>제품코드</th><th>제품명</th><th>입출고 구분</th><th>수량</th><th>거래처</th><th>거래일자</th>
</tr>
</thead>
<tbody>
<%
AllDao allDao = new AllDao();//실제 사용객체 (인스턴스) 생성
ArrayList<InOut> list2 = allDao.getList2();
for (int i=0; i < list2.size(); i++){
%>
<tr>
<td></td>
<td><%=list2.get(i).getT_no() %></td>
<td><%=list2.get(i).getP_code() %></td>
<td><%=list2.get(i).getT_type() %></td>
<td><%=list2.get(i).getT_cnt() %></td>
<td><%=list2.get(i).getC_code() %></td>
<td><%=list2.get(i).getT_date()%></td>

</tr>
<%} %>







</tbody>
</table>

<jsp:include page="include/footer.jsp" flush="false" />