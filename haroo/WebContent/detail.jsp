<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
	<h2>글세부보기</h2>
	<table border="1">
		<tr>
			<td>제목</td>
			<td>${board.title }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${board.writer }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${board.contents }</td>
		</tr>
	</table>
	<br>
	<h4>댓글목록</h4>
	
	
	<table border="1">
		<tr>
			<td>댓글번호</td>
			
			<td>댓글작성자</td>
			<td>댓글내용</td>
			<td>댓글일자</td>
		</tr>
		<c:forEach var="reply" items="${replys}">
		<tr>
			<td>${reply.reNo}</td>
			
			<td>${reply.reWriter }</td>
			<td>${reply.reContents}</td>
			<td>${reply.reRegdate }</td>
		</tr>
		</c:forEach>
	</table>
	
	<form action="insertReplyAction.do" method="post">
		<input type="hidden" name="bdNo" value="${board.bdNo }">
		댓글작성자:<br>
		댓글 내용 : <input type="text" name="reContents"><br>
		<input type="submit" value="댓글쓰기">
	</form>
	<a href="updateForm.do?bdNo=${board.bdNo}">글수정</a>
	<a href="deleteAction.do?bdNo=${board.bdNo}">글삭제</a>
</body>
</html>