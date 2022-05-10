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
<h3>양식 목록</h3>
<div class="list-group">
  <a href="/haroo/ap/form/1" class="ap-link list-group-item list-group-item-action">
  <span class="badge bg-light rounded-pill text-dark">1</span> 기안서</a>
  <a href="/haroo/ap/form/2" class="ap-link list-group-item list-group-item-action">
  <span class="badge bg-light rounded-pill text-dark">2</span> 품의서</a>
  <a href="/haroo/ap/form/3" class="ap-link list-group-item list-group-item-action">
  <span class="badge bg-light rounded-pill text-dark">3</span> 휴가신청서</a>
</div>
</body>
</html>