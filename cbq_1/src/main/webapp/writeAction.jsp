<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import = "cbq_1.*, java.io.PrintWriter"
%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="bbs" class="cbq_1.InOut" scope="page"/>
<jsp:setProperty name="bbs" property="t_no"/>
<jsp:setProperty name="bbs" property="p_code"/>
<jsp:setProperty name="bbs" property="t_type"/>
<jsp:setProperty name="bbs" property="t_cnt"/>
<jsp:setProperty name="bbs" property="t_date"/>
<jsp:setProperty name="bbs" property="c_code"/>

<%
if(bbs.getT_no() == null || bbs.getP_code() == null || bbs.getT_type() == null || bbs.getT_cnt() == null || bbs.getC_code() == null){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('입력되지 않은 사항이 있습니다')");
	script.println("history.back()");
	script.println("</script>");
}else{
    AllDao allDao = new AllDao();
	
	InOut inOut = new InOut();
	inOut.setT_no(request.getParameter("t_no"));
	inOut.setP_code(request.getParameter("p_code"));
	inOut.setT_type(request.getParameter("t_type"));
	inOut.setT_cnt(request.getParameter("t_cnt"));
	inOut.setT_date(request.getParameter("t_date"));
	inOut.setC_code(request.getParameter("c_code"));
	

		int result = allDao.write(bbs.getT_no(), bbs.getP_code(), bbs.getT_type(), bbs.getT_cnt(),  bbs.getT_date(), bbs.getC_code());	
		
		if(result == -1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('글쓰기에 실패하였습니다')");
			script.println("history.back()");
			script.println("</script>");
		}else{
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('글쓰기 성공')");
			script.println("location.href='index.jsp'");
			script.println("</script>");
		}
		


}
%>