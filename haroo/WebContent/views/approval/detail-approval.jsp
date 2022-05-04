<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문서보기</title>
<!-- bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- jquery -->
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <!-- editor -->
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
  <link rel="stylesheet" href="/haroo/css/approval-styles.css" />
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
                  <c:forEach var="apLine" items="${ap.apLine }">
                    <th class="text-center">${apLine.emName} ${apLine.poName}(${apLine.deName })</th>
                  </c:forEach>
                </tr>
                <tr>
                  <c:forEach var="apLine" items="${ap.apLine }">
                    <td class="text-center">
                      <button class="ap-line-button ap-form-btn">
                      <c:choose>
                        <c:when test="${apLine.alStatus == 0 }">
                          진행중
                        </c:when>
                        <c:when test="${apLine.alStatus == 1 }">
                          승인
                        </c:when>
                        <c:when test="${apLine.alStatus == 2 }">
                          반려
                        </c:when>
                      </c:choose>
                      </button>
                    </td>
                  </c:forEach>
                </tr>
                <tr class="ap-toggle ap-hidden">
                  <c:forEach var="apLine" items="${ap.apLine }">
                    <c:if test="${apLine.alDate != null }">
                      <td class="text-center">${apLine.alDate }</td>
                    </c:if>
                  </c:forEach>
                </tr>
                <tr class="ap-toggle ap-hidden">
                  <c:forEach var="apLine" items="${ap.apLine }">
                    <c:if test="${apLine.alComment != null }">
                      <td class="text-center">${apLine.alComment}</td>
                    </c:if>
                  </c:forEach>
                </tr>
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
        <tr>
          <th class="text-center" scope="row" colspan="2">내용</th>
        </tr>
        <c:if test="${ap.expense != null }">
        <tr>
           <td colspan="2">
            <table class="table mb-0 table-bordered">
              <tbody>
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
                  <td class="text-center" colspan="2">합계</td>
                  <td class="text-center" colspan="2">${total }</td>
                </tr>
              </tbody>
            </table>
          </td>
        </tr>
        </c:if>
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
    <c:if test="${ap.apStatus == 0 }">
      <div class="ap-form-btns">
      <form action="" method="post">
        <input type="hidden" name="apNo" value="${ap.apNo }" />
        <button class="ap-form-btn">상신취소</button>
      </form>
      </div>
    </c:if>
    <c:if test="${ap.apStatus == -1 }">
      <div class="ap-form-btns">
      <form action="" method="post">
        <input type="hidden" name="approvalVO" value="${ap }" />
        <button class="ap-form-btn">재상신</button>
      </form>
      </div>
    </c:if>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <script type="text/javascript" src="/haroo/js/approval.js"></script>
</body>
</html>