<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전자결재</title>
  <link rel="stylesheet" href="/haroo/css/approval-styles.css" />
  <script type="text/javascript" src="/haroo/js/approval.js"></script>
</head>
<body>
  <a href="forms"><button>결재문서 작성</button></a>
  <h3>수신</h3>
  <ul>
    <li><a href="wait">미결재</a></li>
    <li><a href="sign">결재완료</a></li>
  </ul>
  <h3>상신</h3>
  <ul>
    <li><a href="process">진행</a></li>
    <li><a href="done">완료</a></li>
    <li><a href="takeback">취소</a></li>
  </ul>
  <ul>
    <li><a href="all">전체문서함</a></li>
  </ul>
</body>
</html>