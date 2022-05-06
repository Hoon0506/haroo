<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재선 선택</title>
<!-- jquery -->
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <!-- editor -->
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
  <link rel="stylesheet" href="/haroo/css/approval-styles.css" />
</head>
<body>
  <div class="ap-alist-container">
    <div class="ap-alist-left">
      <ul class="ap-alist">
        <c:forEach var="em" items="${list}">
          <li class="ap-alist-name">
          <a class="ap-alist-name" href="#">
            ${em.deName } - ${em.emName } ${em.poName }
            <input type="hidden" class="ap-hidden-emNo" value="${em.emNo }" />
            <input type="hidden" class="ap-hidden-deName" value="${em.deName }">
          </a>
          </li>
        </c:forEach>
      </ul>
    </div>
    <div class="ap-alist-select">
      <div id="ap-alist-selected-sticky">
        <div id="ap-alist-selected"></div>
        <button type="button" class="ap-form-btn">완료</button>
      </div>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <script type="text/javascript" src="/haroo/js/approval.js"></script>
</body>
</html>