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
  <c:when test="${fn:contains(url, 'done')  }"><h3>완료 문서</h3></c:when>
  <c:when test="${fn:contains(url, 'process') }"><h3>진행 문서</h3></c:when>
  <c:when test="${fn:contains(url, 'takeback') }"><h3>취소 문서</h3></c:when>
  <c:when test="${fn:contains(url, 'all') }"><h3>전체 문서</h3></c:when>
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
          <c:when test="${ap.apStatus == 0 }">
          <tr>
            <th scope="row">${ap.foKind }</th>
            <td><a class="ap-list-title ap-link" href="/haroo/ap/process/${ap.apNo }">${ap.apTitle }</a></td>
            <td>${ap.emName }</td>
            <td>${ap.apDate }</td>
            <td>진행중</td>
          </tr>
          </c:when>
          <c:when test="${ap.apStatus > 0 }">
          <tr>
            <th scope="row">${ap.foKind }</th>
            <td><a class="ap-list-title ap-link" href="/haroo/ap/done/${ap.apNo }">${ap.apTitle }</a></td>
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
            <td><a class="ap-list-title ap-link" href="/haroo/ap/takeback/${ap.apNo }">${ap.apTitle }</a></td>
            <td>${ap.emName }</td>
            <td>${ap.apDate }</td>
            <td>취소</td>
          </tr>
          </c:when>
          </c:choose>
        </c:forEach>
      </tbody>
    </table>
</body>
</html>