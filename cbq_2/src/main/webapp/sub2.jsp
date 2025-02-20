<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="java.util.*,dto.*,dao.*"
    %>
<!DOCTYPE html>
<jsp:include page="include/header.jsp"/>
<script src="js/js.js"></script>
<section class="content">
<table class="table">
<thead>


</thead>
<form name="form">
<tbody>
   <tr>
    <th>예방접종이력번호</th>
    <td>
<input type="text" name="p_seno">예)20200001
    </td>
   </tr>
   <tr>
    <th>고객번호</th>
    <td>
<input type="text" name="p_no">
    </td>
   </tr>
   <tr>
    <th>백신코드</th>
    <td>
<input type="text" name="i_code">
    </td>
   </tr>
   <tr>
    <th>접종일자</th>
    <td>
<input type="text" name="p_date">
    </td>
   </tr>
   <tr>
    <td colspan="2">
        <a href="#" onclick="goSave()">예방접종등록</a>
        <input type="button" onclick="goReset()" value="다시쓰기"/>
    </td>
   </tr>
</tbody>
</table>
</form>
</section>
<jsp:include page="include/footer.jsp"/>