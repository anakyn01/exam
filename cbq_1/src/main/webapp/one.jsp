<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import ="cbq_1.*, java.util.ArrayList"
%>
<jsp:include page="include/header.jsp" flush="false" />


<h1>입출고 내역 조회</h1>

<table>
<colgroup>
<col style="width:10%"/>
<col style="width:20%"/>
<col style="width:10%"/>
<col style="width:20%"/>
<col style="width:20%"/>
</colgroup>
<thead>
<tr>
<th>제품코드</th><th>제품명</th><th>사이즈</th><th>매입단가</th><th>출고단가</th>
</tr>
</thead>
<tbody>
<%
AllDao allDao = new AllDao();//실제 사용객체 (인스턴스) 생성
ArrayList<Product> list = allDao.getList();
for (int i=0; i < list.size(); i++){
%>
<tr>
<td><%=list.get(i).getP_code() %></td>
<td><%=list.get(i).getP_name() %></td>
<td><%=list.get(i).getP_size() %></td>
<td><%=list.get(i).getP_incost()%></td>
<td><%=list.get(i).getP_outcost() %></td>
</tr>
<%} %>








</tbody>
</table>

<jsp:include page="include/footer.jsp" flush="false" />