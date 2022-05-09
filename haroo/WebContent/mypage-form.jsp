<%@ page import="com.haroo.domain.EmployeeVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    EmployeeVO employeeVO = ((EmployeeVO) request.getSession().getAttribute("employeeVO"));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/haroo/mypage/update-information" method="post">
    <input type="hidden" name="em_no" value="${employeeVO.getEm_no()}">
    사원번호 : <%=employeeVO.getEm_no()%><br>
    직책번호 : <%=employeeVO.getPo_no()%><br>
    부서번호 : <%=employeeVO.getDe_no()%><br>
    사원이름 : <%=employeeVO.getEm_name()%><br>
    내선전화 : <%=employeeVO.getEm_ext()%><br>
    입사일 : <%=employeeVO.getEm_first()%><br>
    퇴사일 : <%=employeeVO.getEm_last()%><br><br>

    휴대전화 : <input type="text" name="em_phone" value="${employeeVO.getEm_phone()}"><br>
    이메일 : <input type="text" name="em_email" value="${employeeVO.getEm_email()}"><br>
    비밀번호 : <input type="password" name="em_pw" value="${employeeVO.getEm_pw()}"><br>
    <input type="submit" value="수정하기">
</form>
</body>
</html>
