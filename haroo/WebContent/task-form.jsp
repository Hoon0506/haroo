<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="com.haroo.domain.TaskVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.haroo.domain.EmployeeVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% JSONArray jsonArray = (JSONArray) session.getAttribute("jsonArray");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'/>
    <!-- 화면 해상도에 따라 글자 크기 대응(모바일 대응) -->
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <!-- jquery CDN -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- fullcalendar CDN -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">
    <link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet'/>
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
    <!-- fullcalendar 언어 CDN -->
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <style>
        /* body 스타일 */
        html, body {
            overflow: hidden;
            font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
            font-size: 14px;
        }

        /* 캘린더 위의 해더 스타일(날짜가 있는 부분) */
        .fc-header-toolbar {
            padding-top: 1em;
            padding-left: 1em;
            padding-right: 1em;
        }

        .fc-time {
            display: none;
        }
    </style>
</head>
<body style="padding:30px;">
<!--공통 header-->
<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="#" class="nav-link px-2 text-secondary">Home</a></li>
                <li><a href="#" class="nav-link px-2 text-white">Features</a></li>
                <li><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
                <li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
                <li><a href="#" class="nav-link px-2 text-white">About</a></li>
            </ul>
            <div class="text-end">
                <button type="button" class="btn btn-outline-light me-2">${employeeVO.em_name}님 환영합니다 :)</button>
                <button type="button" class="btn btn-warning"><a href="mypage">마이 페이지</a></button>
            </div>
        </div>
    </div>
</header>
<nav>
    <ul class="nav justify-content-center">
        <li class="nav-item"><a class="nav-link active"
                                aria-current="page" href="#">인사정보</a></li>
        <li class="nav-item"><a class="nav-link" href="#">근태조회</a></li>
        <li class="nav-item"><a class="nav-link" href="task">캘린더</a></li>
        <li class="nav-item"><a class="nav-link" href="#">게시판</a></li>
        <li class="nav-item"><a class="nav-link" href="#">설문조사</a></li>
        <li class="nav-item"><a class="nav-link" href="#">전자결재</a></li>
        <li class="nav-item"><a class="nav-link disabled">채팅</a>
        </li>
    </ul>
</nav>
<!--일정 -->
<div id="bookingModal" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">일정</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                일정 명 : <input type="text" class="form-control" id="title"><br>
                일정 내용 : <input type="text" class="form-control" id="content"><br>
                <div class="modal-footer">
                    <button type="button" id="saveBtn" class="btn btn-primary">추가 하기</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- calendar 태그 -->
<div id='calendar-container'>
    <div id='calendar'></div>
</div>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        var calendarEl = document.getElementById('calendar'); // new FullCalendar.Calendar(대상 DOM객체, {속성:속성값, 속성2:속성값2..})
        var calendar = new FullCalendar.Calendar(calendarEl, {
            locale: 'ko',
            headerToolbar: {
                left: 'prev,next today',
                center: 'title',
                right: 'dayGridMonth,timeGridWeek,timeGridDay'
            },
            navLinks: true, // can click day/week names to navigate views
            selectable: true,
            selectMirror: true, // 이벤트명 : function(){} : 각 날짜에 대한 이벤트를 통해 처리할 내용..

            select: function (arg) {
                $('#bookingModal').modal('toggle');

                $('#saveBtn').off().on('click', function () {
                    var title = $('#title').val();
                    if (title) {
                        //달력 출력
                        calendar.addEvent({
                            title: title,
                            start: arg.start,
                            end: arg.end,
                            allDay: arg.allDay,
                            backgroundColor: "navy",
                            textColor: "yellow"
                        })
                        //일정 추가[DB에 저장]
                        //하루면 YYYY/MM/DD hh:mm
                        //이틀 이상이면 YYYY/MM/DD
                        var start, end;
                        if (arg.allDay) { // 이틀 이상
                            start = moment(arg.start).format('YYYY/MM/DD');
                            end = moment(arg.end).format('YYYY/MM/DD');
                        } else {
                            start = moment(arg.start).format('YYYY/MM/DD hh:mm');
                            end = moment(arg.end).format('YYYY/MM/DD hh:mm');
                        }

                        $.ajax({
                            url: '/task/save',
                            method: 'POST',
                            dataType: 'json',
                            data: {
                                "title": title,
                                "start": start,
                                "end": end,
                                "allDay": arg.allDay,
                                "backgroundColor": "navy",
                                "textColor": "yellow",
                                "em_no": '${employeeVO.em_no}',
                            }
                        })
                    }
                    $('#bookingModal').modal('hide');
                })
                calendar.unselect()
            },
            eventClick: function (arg) { // 있는 일정 클릭시,
                alert('삭제??')
            },
            editable: true,
            dayMaxEvents: true, // allow "more" link when too many events

            //일정 JSON으로 받아서 보여준다.
            events: <%=jsonArray%>
        });
        <%System.out.println(jsonArray);%>
        calendar.render();
    });
</script>
</body>
</html>