<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>글 수정폼</h3>
	<form action="updateAction.do" method="post">
		<input type="hidden" name="bdNo" value="${board.bdNo}">
		작성자 : ${board.writer}<br>
		제목 : <input type="text" name="title" value="${board.title}"><br>
		내용 : <br>
		<textarea rows="6" cols="70" name="contents">${board.contents}</textarea>
		<input type="submit" value="수정완료">
	</form>
</body>
</html>