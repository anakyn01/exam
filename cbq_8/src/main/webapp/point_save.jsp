<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="dao.*"
%>
<%
DAO dao = new DAO();
String player_no = request.getParameter("player_no");
int point_1 = Integer.parseInt(request.getParameter("point_1"));
int point_2 = Integer.parseInt(request.getParameter("point_2"));
int point_3 = Integer.parseInt(request.getParameter("point_3"));
int point_4 = Integer.parseInt(request.getParameter("point_4"));

//초기화
int max = 0;
int[] points = {point_1,point_2,point_3,point_4};
for(int k=0; k<points.length; k++){
	if(max <= points[k]){
		max = points[k];
	}
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>