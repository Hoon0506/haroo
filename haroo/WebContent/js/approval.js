// summernote 실행
$(document).ready(function() {
  $('#summernote').summernote({
      height: 300,                 // 에디터 높이
      minHeight: null,             // 최소 높이
      maxHeight: null,             // 최대 높이
      focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
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

// enter submit 방지
$(':reset').click(function(){
  $('#summernote').summernote('reset');
});

$(".ap-form input").keydown(function (event) {
  if (event.keyCode == '13') {
    if (event) {
      event.preventDefault();
      return false;
    }
  }
});

// 품의 목록 금액 계산하기
$('.ap-el input').change(function(){
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
$('.ap-al-select').click(function(event){
  event.preventDefault();
  $('#ap-list-selected').empty();
  window.open("line", "결재선 선택", "width=600, height=500, left=50, top=50");
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

let insertAlList = '<table class="table mb-0 table-bordered"><tbody><tr>';

// 선택한 결재선 저장
$(document).on('click', '#ap-alist-selected-sticky .ap-form-btn', function(event){
  $('.ap-selected-name').each(function(index){
    insertAlList += '<td>'+(index+1)+'. '+$(this).text();
    insertAlList += '<input type="hidden" name="alNo'+(index+1)+'" value="'+$(this).find('.ap-hidden-emNo').val()+'"/>'
    insertAlList += '</td>'
  })
  insertAlList += '</tr></tbody></table>'
  $(opener.document).find('#ap-list-selected').html(insertAlList);
  window.close();
})

// form reset 될 때 선택한 결재선 삭제
$('.ap-form-reset').click(function(){
  $('#ap-list-selected').empty();
});
