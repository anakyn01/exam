<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import = "dao.*"
%>
<%
DAO dao = new DAO();
String buy_date = request.getParameter("buy_date");
String s_code = request.getParameter("s_code");
String buy_number = request.getParameter("buy_number");
String buy_price = request.getParameter("buy_price");
String dept_code = request.getParameter("dept_code");

int result = dao.saveStockBuy(buy_date,s_code,buy_number,buy_price,dept_code);
String msg="매수내역이 정상적으로 등록되었습니다.";
if(result!=1) msg="등록 오류";
%>
<script>
alert('<%=msg%>');
location.href="index.jsp";
</script>






