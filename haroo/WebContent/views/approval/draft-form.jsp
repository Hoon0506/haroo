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
    <h3 class="ap-form-title">기안서</h3>
    <form class="ap-form" action="" method="post">
      <input type="hidden" name="foNo" value="1" />
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
          <button class="ap-form-btn" type="submit">상신하기</button>
          <button class="ap-form-btn" type="reset">다시작성</button>
        </div>
      </div>
    </form>
  </div>
  <script type="text/javascript" src="/haroo/js/approval.js"></script>
</body>
</html>