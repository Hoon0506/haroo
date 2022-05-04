<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안서 작성</title>
  <!-- jquery -->
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <!-- editor -->
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
  <link rel="stylesheet" href="/haroo/css/approval-styles.css" />
</head>
<body>
  <div class="ap-container">
    <h3 class="ap-form-title">휴가신청서</h3>
    <form class="ap-form" action="report" method="post">
      <input type="hidden" name="foNo" value="3" />
      <input type="hidden" name="daNo" value="${daNo }" />
      <div class="ap-form-container">
        <div class="ap-form-input">
          <label class="ap-form-label">기안자</label>
          <input type="hidden" name="emNo" value="${emNo }" />${emName }
        </div>
        <div class="ap-form-input">
          <label class="ap-form-label">제목</label>
          <input class="ap-form-text" type="text" name="apTitle"/>
        </div>
        <div class="ap-form-input">
          <label class="ap-form-label">휴가종류</label>
          <input type="radio" name="leKind" value="1" checked="checked"><span class="ap-form-radio-label">연차</span>
          <input type="radio" name="leKind" value="2"><span class="ap-form-radio-label">반차</span>
          <input type="radio" name="leKind" value="3"><span class="ap-form-radio-label">병가</span>
          <input type="radio" name="leKind" value="4"><span class="ap-form-radio-label">경조사</span>
          <input type="radio" name="leKind" value="9"><span class="ap-form-radio-label">기타</span>
        </div>

          <div class="ap-form-input">
            <label class="ap-form-label">휴가시작일</label>
            <input class="ap-form-text-2" type="text" name="leStart" placeholder="예)2022/11/01"/>
          </div>
          <div class="ap-form-input">
            <label class="ap-form-label">휴가종료일</label>
            <input class="ap-form-text-2" type="text" name="leEnd" placeholder="예)2022/11/01" />
          </div>
          <div class="ap-form-input">
          <label class="ap-form-label">내용</label>
          <textarea id="summernote" name="editordata"></textarea>
        </div>
        <div class="ap-form-input">
          <label class="ap-form-label">결재선</label>
            <button class="ap-form-btn ap-al-select">결재선 선택</button>
            <div id="ap-list-selected"></div>
        </div>
        <div class="ap-form-input">
          <label class="ap-form-label">공개범위</label>
          <input type="radio" name="apPublic" value="1" checked="checked"><span class="ap-form-radio-label">공개</span>
          <input type="radio" name="apPublic" value="0"><span class="ap-form-radio-label">비공개</span>
        </div>
        <div class="ap-form-btns">
          <button class="ap-form-btn" type="submit">신청하기</button>
          <button class="ap-form-btn" type="reset">다시작성</button>
        </div>
      </div>
    </form>
  </div>
  <script type="text/javascript" src="/haroo/js/approval.js"></script>
</body>
</html>