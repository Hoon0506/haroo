<%@page import="com.haroo.domain.FileVO"%>
<%@ page import="com.haroo.repository.FileDAO" %>
<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.multipart.*" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>JSP 파일 업로드</title>
</head>
<body>
	<%
		
		String directory = application.getRealPath("/upload/");
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
		
		MultipartRequest multipartRequest
		= new MultipartRequest(request, directory, maxSize, encoding,
				new DefaultFileRenamePolicy());
		
		String contentsName = multipartRequest.getOriginalFileName("file");
		String contentsRealName = multipartRequest.getFilesystemName("file");
		
		
		new FileDAO().upload(contentsName, contentsRealName);
		out.write("파일명: " + contentsName + "<br>");
		out.write("실제 파일명: " + contentsRealName + "<br>");
	%>
</body>
</html>