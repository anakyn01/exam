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

int total = point_1 + point_2 + point_3 + point_4 - max;
double ava = (double)total / 3.0;
double ava2 = Math.floor (ava * 100) / 100.0;

String skillcode = dao.getSkill_level(player_no);
int sc = Integer.parseInt(skillcode);

if (skillcode != null && !skillcode.isEmpty()) {
    try {
        sc = Integer.parseInt(skillcode);
    } catch (NumberFormatException e) {
        // skillcode가 숫자가 아닐 경우 처리
        sc = 0;  // 예를 들어 기본값을 0으로 설정
    }
} else {
    sc = 0;  // skillcode가 null 또는 빈 값일 경우 기본값 설정
}

double scd = sc/100.00;

double pluspoint = Math.floor( ava2 * scd * 10) / 10.0;
double realava = ava2 + pluspoint;

int result = dao.pointSave(player_no, point_1, point_2, point_3, point_4, total, realava);

String msg = "심사점수가 정상적으로 수정되었습니다";
if(result != 1) msg = "수정 오류";
%>
<script>
alert('<%=msg%>');
location.href="three.jsp";
</script>