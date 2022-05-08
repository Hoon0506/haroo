<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문서목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link rel="stylesheet" href="/haroo/css/approval-styles.css" />
</head>
<body>
  <!-- 사이드메뉴 제외한 영역 -->
  <div class="p-3 container-sm">
    <table class="table table-hover">
      <thead>
        <tr>
          <th scope="col">문서종류</th>
          <th scope="col">제목</th>
          <th scope="col">기안자</th>
          <th scope="col">상신날짜</th>
          <th scope="col">결재상태</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="ap" items="${list }">
          <c:choose>
          <c:when test="${ap.apStatus == 0 }">
          <tr>
            <th scope="row">${ap.foKind }</th>
            <td><a class="ap-list-title" href="process/${ap.apNo }">${ap.apTitle }</a></td>
            <td>${ap.emName }</td>
            <td>${ap.apDate }</td>
            <td>진행중</td>
          </tr>
          </c:when>
          <c:when test="${ap.apStatus > 0 }">
          <tr>
            <th scope="row">${ap.foKind }</th>
            <td><a class="ap-list-title" href="done/${ap.apNo }">${ap.apTitle }</a></td>
            <td>${ap.emName }</td>
            <td>${ap.apDate }</td>
            <c:if test="${ap.apStatus == 1 }">
              <td>승인</td>
            </c:if>
            <c:if test="${ap.apStatus == 2 }">
              <td>반려</td>
            </c:if>
          </tr>
          </c:when>
          <c:when test="${ap.apStatus == -1 }">
          <tr>
            <th scope="row">${ap.foKind }</th>
            <td><a class="ap-list-title" href="takeback/${ap.apNo }">${ap.apTitle }</a></td>
            <td>${ap.emName }</td>
            <td>${ap.apDate }</td>
            <td>취소</td>
          </tr>
          </c:when>
          </c:choose>
        </c:forEach>
      </tbody>
    </table>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <script type="text/javascript" src="/haroo/js/approval.js"></script>
</body>
</html>