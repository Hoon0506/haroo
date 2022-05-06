<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상신-진행</title>
</head>
<body>
  <ol>
    <c:forEach var="ap" items="${list }">
      <li>${ap.apTitle }</li>
    </c:forEach>
  </ol>
</body>
</html>