<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>양식 선택</title>
<script type="text/javascript">
window.onload = function() {
  const apRefreshPath = sessionStorage.getItem('apRefreshPath');
  if(apRefreshPath != null && apRefreshPath != '/haroo/ap/main') {
    location.href = '/haroo/ap/main';
  }
}
</script>
</head>
<body>
  <a href="/haroo/ap/form/1" class="ap-link" >기안서</a>
  <a href="/haroo/ap/form/2" class="ap-link" >품의서</a>
  <a href="/haroo/ap/form/3" class="ap-link" >휴가신청서</a>
</body>
</html>