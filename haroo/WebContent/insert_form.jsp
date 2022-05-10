<%@page import="com.haroo.domain.EmployeeVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	EmployeeVO employeeVO = ((EmployeeVO) request.getSession().getAttribute("employeeVO"));
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<form action="insertAction.do" method="post">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<tr>
						<th colspan="3" style="background: #eeeeee; text-align: center;">게시판
							글쓰기</th>
					</tr>

					<tr>
						<td><input type="hidden" class="form-control" name="emNo"
							value="<%=employeeVO.getEm_no()%>"> 제목 :<input
							type="text" class="form-control" name="title" placeholder="글 제목"
							maxlength="50"></td>
					</tr>
					<tr>
						<td>작성자 :
							<div class="form-control"><%=employeeVO.getEm_name()%></div>
							<input type="hidden" name="name"
							value="<%=employeeVO.getEm_name()%>">
						</td>
					</tr>
					<tr>
						<td>내용 <textarea name="contents" class="form-control"
								maxlength="500" placeholder="글 내용" style="height: 350px;"></textarea>
						</td>
				</table>
				<input type="submit" value="글쓰기" class="btn btn-primary float-end">
			</form>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous">
		
	</script>
</body>
</html>








