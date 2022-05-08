<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>품의서 작성</title>
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
    <div class="text-center">
      <h1 class="fs-2 ap-form-name">품의서</h1>
    </div>
    <form class="ap-form" action="/haroo/ap/form/2" method="post">
    <input type="hidden" name="foNo" value="2" />
    <table class="table table-bordered">
      <tbody>
        <tr>
          <th class="text-center" scope="row">기안자</th>
          <td><input type="hidden" name="emNo" value="${employeeVO.em_no }" />${employeeVO.em_name }</td>
        </tr>
        <tr>
          <th class="text-center" scope="row">제목</th>
          <td><div class="input-group input-group-sm">
            <input class="form-control" type="text" name="apTitle"/>
          </div></td>
        </tr>
        <tr>
          <td colspan="2">
            <table class="table mb-0 table-bordered">
              <tbody>
                <tr>
                  <th class="text-center">품목</th>
                  <th class="text-center">수량</th>
                  <th class="text-center">단가</th>
                  <th class="text-center">소계</th>
                </tr>
                <tr class="ap-el">
                  <td class="item">
                    <div class="input-group input-group-sm">
                      <input class="form-control" type="text" name="elItem1"/>
                    </div>
                  </td>
                  <td class="ap-quantity">
                    <div class="input-group input-group-sm">
                      <input class="form-control" type="number" name="elQuantity1" placeholder="숫자만"/>
                    </div>
                  </td>
                  <td class="ap-price">
                    <div class="input-group input-group-sm">
                      <input class="form-control" type="number" name="elPrice1" placeholder="숫자만"/>
                    </div>
                  </td>
                  <td class="ap-cost">
                    <div class="input-group input-group-sm">
                      <input class="form-control" type="text" name="elCost1" readOnly/>
                    </div>
                  </td>
                </tr> 
                <tr class="ap-el">
                  <td class="item">
                    <div class="input-group input-group-sm">
                      <input class="form-control" type="text" name="elItem2"/>
                    </div>
                  </td>
                  <td class="ap-quantity">
                    <div class="input-group input-group-sm">
                      <input class="form-control" type="number" name="elQuantity2" placeholder="숫자만"/>
                    </div>
                  </td>
                  <td class="ap-price">
                    <div class="input-group input-group-sm">
                      <input class="form-control" type="number" name="elPrice2" placeholder="숫자만"/>
                    </div>
                  </td>
                  <td class="ap-cost">
                    <div class="input-group input-group-sm">
                      <input class="form-control" type="text" name="elCost2" readOnly/>
                    </div>
                  </td>
                </tr>
                <tr class="ap-el">
                  <td class="item">
                    <div class="input-group input-group-sm">
                      <input class="form-control" type="text" name="elItem3"/>
                    </div>
                  </td>
                  <td class="ap-quantity">
                    <div class="input-group input-group-sm">
                      <input class="form-control" type="number" name="elQuantity3" placeholder="숫자만"/>
                    </div>
                  </td>
                  <td class="ap-price">
                    <div class="input-group input-group-sm">
                      <input class="form-control" type="number" name="elPrice3" placeholder="숫자만"/>
                    </div>
                  </td>
                  <td class="ap-cost">
                    <div class="input-group input-group-sm">
                      <input class="form-control" type="text" name="elCost3" readOnly/>
                    </div>
                  </td>
                </tr>
                <tr>
                  <th class="text-center">합계</th>
                  <td class="ap-total" colspan="3">
                    <div class="input-group input-group-sm">
                      <input class="form-control" name="elTotal" type="text" readOnly/>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </td>
        </tr>
        <tr>
          <th class="text-center" scope="row">내용</th>
          <td><textarea id="summernote" name="editordata"></textarea></td>
        </tr>
        <tr>
          <th class="text-center" scope="row">결재선</th>
          <td>
            <button class="btn btn-outline-secondary btn-sm ap-al-select">결재선 선택</button>
            <div class="ap-line-sign-form" id="ap-list-selected"></div>
          </td>
        </tr>
        <tr>
          <th class="text-center" scope="row">공개범위</th>
          <td>
            <input type="radio" name="apPublic" value="1" checked="checked"><span class="ap-form-radio-label">공개</span>
            <input type="radio" name="apPublic" value="0"><span class="ap-form-radio-label">비공개</span>
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
  <script type="text/javascript">
  $slim(document).ready(function() {
    $slim('#summernote').summernote({
        height: 300,                 // 에디터 높이
        minHeight: null,             // 최소 높이
        maxHeight: null,             // 최대 높이
        lang: "ko-KR",          // 한글 설정
        toolbar: [
          // [groupName, [list of button]]
          ['style', ['bold', 'italic', 'underline', 'clear']],
          ['font', ['strikethrough', 'superscript', 'subscript']],
          ['fontsize', ['fontsize']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['height', ['height']]
        ]
    });
  });
  </script>
</body>
</html>