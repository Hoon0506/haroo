<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>품의서 작성</title>
  <!-- jquery -->
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <!-- editor -->
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
  <!-- bootstrap 
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  -->
  <link rel="stylesheet" href="/haroo/css/approval-styles.css" />
</head>
<body>
  <div class="ap-container">
    <h3 class="ap-form-title">품의서</h3>
    <form class="ap-form" action="" method="post">
      <input type="hidden" name="foNo" value="2" />
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
          <label class="ap-form-label">품의목록</label>
          <table class="ap-form-table">
            <tr>
              <th>품목</th>
              <th>수량</th>
              <th>단가</th>
              <th>소계</th>
            </tr>
            <tr class="ap-el ap-toggle ap-hidden">
              <td class="item"><input class="ap-form-text-3" type="text" name="elItem1"/></td>
              <td class="ap-quantity"><input class="ap-form-text-3" type="number" name="elQuantity1" placeholder="숫자만"/></td>
              <td class="ap-price"><input class="ap-form-text-3" type="number" name="elPrice1" placeholder="숫자만"/></td>
              <td class="ap-cost"><input class="ap-form-text-3" type="text" name="elCost1" readOnly/></td>
            </tr>
            <tr class="ap-el ap-toggle ap-hidden">
              <td class="item"><input class="ap-form-text-3" type="text" name="elItem2"/></td>
              <td class="ap-quantity"><input class="ap-form-text-3" type="number" name="elQuantity2" placeholder="숫자만"/></td>
              <td class="ap-price"><input class="ap-form-text-3" type="number" name="elPrice2" placeholder="숫자만"/></td>
              <td class="ap-cost"><input class="ap-form-text-3" type="text" name="elCost2" readOnly/></td>
            </tr>
            <tr class="ap-el ap-toggle ap-hidden">
              <td class="item"><input class="ap-form-text-3" type="text" name="elItem3"/></td>
              <td class="ap-quantity"><input class="ap-form-text-3" type="number" name="elQuantity3" placeholder="숫자만"/></td>
              <td class="ap-price"><input class="ap-form-text-3" type="number" name="elPrice3" placeholder="숫자만"/></td>
              <td class="ap-cost"><input class="ap-form-text-3" type="text" name="elCost3" readOnly/></td>
            </tr>
            <tr>
              <td></td>
              <td></td>
              <td>합계</td>
              <td class="ap-total"><input class="ap-form-text-3" name="elTotal" type="text" readOnly/></td>
            </tr>
          </table>
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
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <script type="text/javascript" src="/haroo/js/approval.js"></script>
</body>
</html>