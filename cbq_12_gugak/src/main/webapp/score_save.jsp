<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*, dto.*"
%>
<%
request.setCharacterEncoding("UTF-8");
DAO dao = new DAO();
String entry_no= request.getParameter("entry_no");
int score1 = Integer.parseInt(request.getParameter("score1"));
int score2 = Integer.parseInt(request.getParameter("score2"));
int score3 = Integer.parseInt(request.getParameter("score3"));
int score4 = Integer.parseInt(request.getParameter("score4"));
int score5 = Integer.parseInt(request.getParameter("score5"));

int[] scores = {score1, score2, score3, score4, score5};
int max=0;
int min = 100;
for(int k=0; k < scores.length; k++){
	if(scores[k]>=max){
		max=scores[k];
	}
	if(scores[k]<=min){
		min=scores[k];
	}
}
int total = score1 + score2 + score3 + score4 + score5 -max -min;
double ava = (double)total/3.0;
double ava2 = Math.round(ava * 100) / 100.0;

int result = dao.saveScore(entry_no,score1,score2,score3,score4,score5,max,min,total,ava2);
String msg = "경연점수가 등록되었습니다!";
if(result!=1) msg = "등록 오류";
%>
<script>
alert("<%=msg%>");
location.href="index.jsp";
</script>