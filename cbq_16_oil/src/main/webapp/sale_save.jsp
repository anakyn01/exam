<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*"
%>
<%
DAO dao = new DAO();

String saleno = request.getParameter("saleno");
String oildate = request.getParameter("oildate");
String oiltype = request.getParameter("oiltype");
String amount = request.getParameter("amount");
String paytype = request.getParameter("paytype");
String credit1 = request.getParameter("credit1");
String credit2 = request.getParameter("credit2");
String credit3 = request.getParameter("credit3");
String credit4 = request.getParameter("credit4");
String creditcard = credit1+credit2+credit3+credit4;
String oilcost = request.getParameter("oilcost");
String custno = request.getParameter("custno");

if(paytype.equals("1")) creditcard="";
if(custno.equals("null")) creditcard="";

int result = dao.saveOilSale(saleno,oildate,oiltype,amount,paytype,creditcard,custno,oilcost);
String msg ="매출정보가 정상적으로 등록되었습니다!";
if(result!=1) msg="등록 오류!";
%>
<script>
alert('<%=msg%>');
location.href="index.jsp";
</script>