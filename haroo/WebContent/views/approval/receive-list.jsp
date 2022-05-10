<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문서목록</title>
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
  <!-- 사이드메뉴 제외한 영역 -->
  <c:set var="url" value="${requestScope['javax.servlet.forward.request_uri']}" />
  <c:choose>
    <c:when test="${fn:contains(url, 'wait')  }"><h3>미결재 문서</h3></c:when>
    <c:when test="${fn:contains(url, 'sign') }"><h3>결재 문서</h3></c:when>
  </c:choose>
  
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
          <c:when test="${ap.alStatus == 0 }">
          <tr>
            <th scope="row">${ap.foKind }</th>
            <td><a class="ap-list-title ap-link" href="/haroo/ap/wait/${ap.apNo }">${ap.apTitle }</a></td>
            <td>${ap.emName }</td>
            <td>${ap.apDate }</td>
            <td>진행중</td>
          </tr>
          </c:when>
          <c:when test="${ap.alStatus > 0 }">
          <tr>
            <th scope="row">${ap.foKind }</th>
            <td><a class="ap-list-title ap-link" href="/haroo/ap/sign/${ap.apNo }">${ap.apTitle }</a></td>
            <td>${ap.emName }</td>
            <td>${ap.apDate }</td>
            <c:choose>
              <c:when test="${ap.apStatus == 1 }">
                <td>승인</td>
              </c:when>
              <c:when test="${ap.apStatus == 2 }">
                <td>반려</td>
              </c:when>
              <c:otherwise>
                <td>진행중</td>
              </c:otherwise>
            </c:choose>
          </tr>
          </c:when>
          </c:choose>
        </c:forEach>
      </tbody>
    </table>
</body>
</html>