<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Haroo - 로그인</title>
</head>
<body>
<form action="/haroo/main" method="post">
    아이디 : <input type="text" name="em_no"><br>
    패스워드 : <input type="password" name="em_pw"><br>
    <input type="submit" value="로그인">
</form>
</body>
</html>
