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
    <input type="hidden" name="foNo" value="1" />
    <table class="table table-bordered">
      <tbody>
        <tr>
          <th class="text-center fs-2" scope="col" colspan="2">기안서 작성</th>
        </tr>
        <tr>
          <th scope="row">기안자</th>
          <td><input type="hidden" name="emNo" value="${emNo }" />${emName }</td>
        </tr>
        <tr>
          <th scope="row">제목</th>
          <td><input class="form-control" type="text" name="apTitle"/></td>
        </tr>
        <tr>
          <th scope="row">내용</th>
          <td><textarea id="summernote" name="editordata"></textarea></td>
        </tr>
        <tr>
          <th scope="row">결재선</th>
          <td>
            <button class="btn btn-outline-secondary ap-al-select">결재선 선택</button>
            <div class="ap-line-sign-form" id="ap-list-selected"></div>
          </td>
        </tr>
        <tr>
          <th scope="row">공개범위</th>
          <td>
            <input type="radio" name="apPublic" value="1" checked="checked"><span class="ap-form-radio-label">공개</span>
            <input type="radio" name="apPublic" value="0"><span class="ap-form-radio-label">비공개</span>
          </td>
        </tr>
      </tbody>   
      </table> 
      <div class="text-center">
        <div class="btn-group" role="group">
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