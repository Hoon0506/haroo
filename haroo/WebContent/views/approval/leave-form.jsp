<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안서 작성</title>
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
    <form class="ap-form" action="" method="post">
    <input type="hidden" name="foNo" value="3" />
    <input type="hidden" name="daNo" value="${daNo }" />
    <table class="table table-bordered">
      <tbody>
        <tr>
          <th class="text-center fs-2" scope="col" colspan="2">휴가신청서 작성</th>
        </tr>
        <tr>
          <th scope="row">신청자</th>
          <td><input type="hidden" name="emNo" value="${employeeVO.em_no }" />${employeeVO.em_name }</td>
        </tr>
        <tr>
          <th scope="row">제목</th>
          <td><div class="input-group input-group-sm">
            <input class="form-control" type="text" name="apTitle"/>
          </div></td>
        </tr>
        <tr>
          <th scope="row">휴가종류</th>
          <td>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" id="inlineRadio1" name="leKind" value="1" checked="checked">
              <label class="form-check-label" for="inlineRadio1">연차</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" id="inlineRadio2" name="leKind" value="2" disabled>
              <label class="form-check-label" for="inlineRadio2">반차</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" id="inlineRadio3" name="leKind" value="3">
              <label class="form-check-label" for="inlineRadio3">병가</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" id="inlineRadio4" name="leKind" value="4">
              <label class="form-check-label" for="inlineRadio4">경조사</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" id="inlineRadio5" name="leKind" value="9">
              <label class="form-check-label" for="inlineRadio5">기타</label>
            </div>
          </td>
        </tr>
        <tr>
          <th scope="row">휴가일정</th>
          <td>
            <div class="input-group input-group-sm">
              <span class="input-group-text">시작일</span>
              <input type="text" class="form-control" pattern="^\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$" name="leStart" placeholder="예)2022-11-01">
              <span class="input-group-text">종료일</span>
              <input type="text" class="form-control" pattern="^\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$" name="leEnd" placeholder="예)2022-11-01">
            </div>
          </td>
        </tr>
        <tr>
          <th scope="row">내용</th>
          <td><textarea id="summernote" name="editordata"></textarea></td>
        </tr>
        <tr>
          <th scope="row">결재선</th>
          <td>
            <button class="btn btn-outline-secondary btn-sm ap-al-select">결재선 선택</button>
            <div class="ap-line-sign-form" id="ap-list-selected"></div>
          </td>
        </tr>
        <tr>
          <th scope="row">공개범위</th>
          <td>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" id="apPublic1" name="apPublic" value="1" checked="checked">
              <label class="form-check-label" for="apPublic1">공개</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" id="apPublic2" name="apPublic" value="0">
              <label class="form-check-label" for="apPublic2">비공개</label>
            </div>
          </td>
        </tr>
      </tbody>   
      </table> 
      <div class="text-end">
        <div class="btn-group-sm" role="group">
          <button class="btn btn-outline-secondary" type="submit">상신하기</button>
          <button class="btn btn-outline-secondary ap-form-reset" type="reset">다시작성</button>
        </div>
      </div>
    </form>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <script type="text/javascript" src="/haroo/js/approval.js"></script>
</body>
</html>