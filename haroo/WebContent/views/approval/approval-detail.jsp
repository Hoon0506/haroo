<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문서보기</title>
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
  <div class="ap-form-container">
    <table class="table table-bordered">
      <tbody>
        <tr>
          <th class="text-center fs-2" scope="col" colspan="2">${ap.foKind }</th>
        </tr>
        <tr>
           <td colspan="2">
            <table class="table mb-0 table-bordered">
              <tbody>
                <tr>
                  <th class="text-center ap-line-table-1" rowspan="3">결재</th>
                </tr>
                <tr>
                  <c:forEach var="apLine" items="${ap.apLine }">
                    <th class="text-center">${apLine.emName} ${apLine.poName}(${apLine.deName })</th>
                  </c:forEach>
                </tr>
                <c:if test="${ap.apStatus >=0 }">
                <tr>
                  <c:forEach var="apLine" items="${ap.apLine }">
                    <td class="text-center">
                      <c:choose>
                        <c:when test="${apLine.alStatus == 0  and ap.apStatus == 0 }">
                          <button class="btn btn-outline-secondary btn-sm">진행중</button>
                        </c:when>
                        <c:when test="${apLine.alStatus == 1 }">
                          <button class="btn btn-success btn-sm" type="button" data-bs-toggle="collapse" data-bs-target="#al-detail-${apLine.alOrder }" aria-expanded="false" aria-controls="collapseExample">
                            승인
                          </button>
                          <div class="collapse" id="al-detail-${apLine.alOrder }">
                            <c:if test="${apLine.alDate != null}">
                              <div class="ap-line-sign-form">
                                <div class="ap-line-date">${apLine.alDate }</div>
                                ${apLine.alComment}
                              </div>
                            </c:if>
                          </div>
                        </c:when>
                        <c:when test="${apLine.alStatus == 2 }">
                          <button class="btn btn-secondary btn-sm" type="button" data-bs-toggle="collapse" data-bs-target="#al-detail-${apLine.alOrder }" aria-expanded="false" aria-controls="collapseExample">
                            반려
                          </button>
                          <div class="collapse" id="al-detail-${apLine.alOrder }">
                            <c:if test="${apLine.alDate != null}">
                              <div class="ap-line-sign-form">
                                <div class="ap-line-date">${apLine.alDate }</div>
                                ${apLine.alComment}
                              </div>
                            </c:if>
                          </div>
                        </c:when>
                      </c:choose>
                    </td>
                  </c:forEach>
                </tr>
                </c:if>
              </tbody>
            </table>
          </td>
        </tr>
      
        <tr>
          <th scope="row">제목</th>
          <td>${ap.apTitle }</td>
        </tr>
        <tr>
          <th scope="row">작성일자</th>
          <td>${ap.apDate }</td>
        </tr>
        <tr>
          <th scope="row">기안자</th>
          <td>${ap.emName }</td>
        </tr>
        <c:if test="${ap.leave != null }">
          <tr>
            <th scope="row">휴가종류</th>
            <c:choose>
              <c:when test="${ap.leave.leKind == 1 }">
                <td>연차</td>
              </c:when>
              <c:when test="${ap.leave.leKind == 2 }">
                <td>반차</td>
              </c:when>
              <c:when test="${ap.leave.leKind == 3 }">
                <td>병가</td>
              </c:when>
              <c:when test="${ap.leave.leKind == 4 }">
                <td>경조사</td>
              </c:when>
              <c:otherwise>
                <td>기타</td>
              </c:otherwise>
            </c:choose>
          </tr>
          <tr>
            <th scope="row">휴가일정</th>
            <td>${ap.leave.leStart } - ${ap.leave.leEnd } (${ap.leave.leDays }일 간)</td>
          </tr>
        </c:if>
        <c:if test="${ap.expense != null }">
        <tr>
           <td colspan="2">
            <table class="table mb-0 table-bordered">
              <tbody>
                <tr>
                  <th class="text-center" scope="row" colspan="4">품의목록</th>
                </tr>
                <tr>
                  <th class="text-center">품목</th>
                  <th class="text-center">수량</th>
                  <th class="text-center">가격</th>
                  <th class="text-center">소계</th>
                </tr>
              <c:forEach var="ex" items="${ap.expense }">
                <tr>
                  <td class="text-center">${ex.elItem }</td>
                  <td class="text-center">${ex.elQuantity }</td>
                  <td class="text-center">${ex.elPrice }</td>
                  <td class="text-center">${ex.elCost }</td>
                </tr>
                <c:set var="total" value="${ex.elTotal }"></c:set>
              </c:forEach>  
                <tr>
                  <th class="text-center" colspan="2">합계</th>
                  <td class="text-center" colspan="2">${total }</td>
                </tr>
              </tbody>
            </table>
          </td>
        </tr>
        </c:if>
        <tr>
          <th class="text-center" scope="row" colspan="2">내용</th>
        </tr>
        <tr>
          <td colspan="2">${ap.apContent }</td>
        </tr>
        <tr>
          <th scope="row">공개여부</th>
          <c:choose>
            <c:when test="${ap.apPublic == 1 }">
              <td>공개</td>
            </c:when>
            <c:when test="${ap.apPublic == 0 }">
              <td>비공개</td>
            </c:when>
          </c:choose>
        </tr>
      </tbody>
    </table>
      <div class="text-end">
        <c:if test="${ap.apStatus == 0 }">
          <form action="/haroo/ap/process/${ap.apNo }" method="post">
            <input type="hidden" name="apNo" value="${ap.apNo }" />
            <button class="btn btn-outline-secondary btn-sm">상신취소</button>
          </form>
        </c:if>
        <c:if test="${ap.apStatus == -1 }">
          <form action="/haroo/ap/re" method="post">
            <input type="hidden" name="approval" value="${ap }" />
            <button class="btn btn-outline-secondary btn-sm">재상신</button>
          </form>
        </c:if>
       </div>
  </div>
</body>
</html>