//enter submit 방지
$(document).on('keydown', ".ap-form input", function (event) {
  if (event.keyCode == '13') {
    if (event) {
      event.preventDefault();
      return false;
    }
  }
});

// 품의목록 추가하기
let count = 2;
$(document).on('click', '#ap-el-plus', function(){
  if(count == 6) {
    return;
  }
  let html = '<tr class="ap-el"><td class="el-item"><div class="input-group input-group-sm">';
  html += '<input class="form-control" type="text" name="elItem'+count+'"/></div></td>';
  html += '<td class="ap-quantity"><div class="input-group input-group-sm">';
  html += '<input class="form-control" type="number" name="elQuantity'+count+'" placeholder="숫자만"/></div></td>';
  html += '<td class="ap-price"><div class="input-group input-group-sm">';
  html += '<input class="form-control" type="number" name="elPrice'+count+'" placeholder="숫자만"/></div></td>';
  html += '<td class="ap-cost"><div class="input-group input-group-sm">';
  html += '<input class="form-control" type="text" name="elCost'+count+'" readOnly/></div></td></tr>';
  
  $('#el-total').before(html);
  count++;
  
})

// 품의목록 삭제
$(document).on('click', '#ap-el-minus', function(){
  if(count==2) {
    return;
  }
  $('#el-total').prev().remove();
  count--;
})

// 품의 목록 금액 계산하기
$(document).on('change', '.ap-el input', function(){
  let quantity = 0; // 물건 개수
  let price = 0; // 물건 가격
  let cost = 0; // 물건 총 금액
  let total = 0; // 총금액
  
  $('.ap-el').each(function(){
    quantity = parseInt($(this).find('.ap-quantity input').val()); // 입력 값
    quantity = isNaN(quantity) ? 0 : quantity; // 안전장치
    
    price = parseInt($(this).find('.ap-price input').val());
    price = isNaN(price) ? 0 : price;
    
    cost = quantity * price;
    
    total += cost;
    $(this).find('.ap-cost input').val(cost.toLocaleString()+' 원')
  })
  $('.ap-total input').val(total.toLocaleString()+' 원');
});


//결재선 선택 직원 목록
$(document).on('click', '.ap-al-select', function(event){
  event.preventDefault();
  $('#ap-list-selected').empty();
  window.open("/haroo/ap/form/line", "결재선 선택", "width=600, height=500, left=50, top=50");
});

//결재선 선택
$('a.ap-alist-name').click(function(event){
  event.preventDefault();
  let listName = $(this).html();
  if($('.ap-selected-name').length <3) {
    $('#ap-alist-selected').append('<p><a class="ap-selected-name" href="#">'+listName+'</a></p>');
  } else {
    alert("3명까지 선택 가능")
  }
})

// 선택한 결재선 회수
$(document).on('click', '.ap-selected-name', function(event){
  event.preventDefault();
  $(this).remove();
});

//선택한 결재선 저장
let insertAlList = '<table class="table mb-0 table-bordered"><tbody>';
$(document).on('click', '#ap-alist-selected-sticky .ap-form-btn', function(event){
  $('.ap-selected-name').each(function(index){
    insertAlList += '<tr><td>'+'<span class="badge rounded-pill bg-light text-dark">'+(index+1)+'</span>'+$(this).text();
    insertAlList += '<input type="hidden" name="alNo'+(index+1)+'" value="'+$(this).find('.ap-hidden-emNo').val()+'"/>'
    insertAlList += '</td></tr>'
  })
  insertAlList += '</tbody></table>'
  $(opener.document).find('#ap-list-selected').html(insertAlList);
  window.close();
})

// form reset 될 때 선택한 결재선 삭제, summernote 내용 비우기
$(document).on('click', '.ap-form-reset', function(){
  $('#ap-list-selected').empty();
  $('#summernote').summernote('reset');
});

// 메뉴선택 ajax로 불러오기
let url='';
$(document).on('click', 'a.ap-link', function(event){ // 링크를 클릭했을 때
  event.preventDefault();
  url = $(this).attr('href');
  // console.log(url); url 확인
  apChangeView(url);
});

// 뒤로가기 했을 때 url에 따라 contents 변경
window.addEventListener('popstate', (e) => { // 뒤로가기 이벤트 발생
  const apPathname = window.location.pathname
  //console.log('[popstate]', window.location.pathname);
  
  if(apPathname == "/haroo/ap/main") {
    location.href = apPathname;
  } else {
    apChangeView(apPathname);
  }
  
});

// 새로고침시 현재 url 세션에 저장하여 main으로 이동하기
window.addEventListener('beforeunload', function(event){
  event.preventDefault();
  const apRefreshPath = window.location.pathname
  
  if(apRefreshPath != '/haroo/ap/main'){
    sessionStorage.setItem('apRefreshPath', apRefreshPath);
  }
});

// url로 이동하고 url 반영
function apChangeView(url) {
  $.ajax({
    url: url,
    dataType: 'html',
    success: function(data){
      $('#ap-contents').html(data);
      window.history.pushState({}, null, url);
    }
  })
}
