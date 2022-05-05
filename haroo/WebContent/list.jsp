<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="insertForm.do">글쓰기</a>
	<table border="1" width="500" cellpadding=0 cellspacing=0>
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일자</td>
			<td>조회수</td>
		</tr>
	
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.bdNo}</td>	
				<td><a href="detailAction.do?bdNo=${board.bdNo}">${board.title}</a></td>
				<td>${board.writer}</td>
				<!-- <td>${board.regdate}</td> -->
				<td>
					<fmt:parseDate var="dt" value="${board.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${dt}" pattern="yyyy/MM/dd"/>
				</td>
				<td>${board.hitcount}</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	
	<form action="listAction.do" method="get">
		<input type="checkbox" name="area" value="bd_title">제목
		<input type="checkbox" name="area" value="bd_writer">작성자
		<input type="text" name="searchKey" size="10">
		<input type="submit" value="검색">
	</form>
</body>
</html>