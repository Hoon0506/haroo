<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">
            
    <!-- 사이드바 css -->
    <link rel="stylesheet" href="/haroo/css/sidebar.css" />

    <style type="text/css">
        .haroo-body {
            display: flex;
        }
    </style>
    <title>TEST</title>
</head>
<body>
<header class="p-3 bg-dark text-white">
    <div class="container">
        <div
                class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/"
               class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
            </a>

            <ul
                    class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="#" class="nav-link px-2 text-secondary">Home</a></li>
                <li><a href="#" class="nav-link px-2 text-white">Features</a></li>
                <li><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
                <li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
                <li><a href="#" class="nav-link px-2 text-white">About</a></li>
            </ul>
            <div class="text-end">
                <button type="button" class="btn btn-outline-light me-2">${employeeVO.em_no}님 환영합니다 :)</button>
                <button type="button" class="btn btn-warning"><a href="mypage">마이 페이지</a></button>
            </div>
        </div>
    </div>
</header>
<nav>
    <ul class="nav justify-content-center">
        <li class="nav-item"><a class="nav-link" href="#">인사정보</a></li>
        <li class="nav-item"><a class="nav-link" href="#">근태조회</a></li>
        <li class="nav-item"><a class="nav-link" href="task">캘린더</a></li>
        <li class="nav-item"><a class="nav-link" href="/haroo/board/listAction.do">게시판</a></li>
        <li class="nav-item"><a class="nav-link" href="#">설문조사</a></li>
        <li class="nav-item"><a class="nav-link" href="/haroo/ap/main">전자결재</a></li>
        <li class="nav-item"><a class="nav-link">채팅</a>
        </li>
    </ul>
</nav>

<div class="haroo-body">


    <div class="p-3 bg-white" style="width: 280px;">
        <a href="/" class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom">
            <svg class="bi me-2" width="30" height="24"><use xlink:href="#bootstrap"></use></svg>
            <span class="fs-5 fw-semibold">Collapsible</span>
        </a>
        <ul class="list-unstyled ps-0">
            <li class="mb-1">
                <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="false">
                    Home
                </button>
                <div class="collapse" id="home-collapse" style="">
                    <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                        <li><a href="#" class="link-dark rounded">Overview</a></li>
                        <li><a href="#" class="link-dark rounded">Updates</a></li>
                        <li><a href="#" class="link-dark rounded">Reports</a></li>
                    </ul>
                </div>
            </li>
            <li class="mb-1">
                <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="false">
                    Dashboard
                </button>
                <div class="collapse" id="dashboard-collapse" style="">
                    <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                        <li><a href="#" class="link-dark rounded">Overview</a></li>
                        <li><a href="#" class="link-dark rounded">Weekly</a></li>
                        <li><a href="#" class="link-dark rounded">Monthly</a></li>
                        <li><a href="#" class="link-dark rounded">Annually</a></li>
                    </ul>
                </div>
            </li>
            <li class="mb-1">
                <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#orders-collapse" aria-expanded="false">
                    Orders
                </button>
                <div class="collapse" id="orders-collapse" style="">
                    <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                        <li><a href="#" class="link-dark rounded">New</a></li>
                        <li><a href="#" class="link-dark rounded">Processed</a></li>
                        <li><a href="#" class="link-dark rounded">Shipped</a></li>
                        <li><a href="#" class="link-dark rounded">Returned</a></li>
                    </ul>
                </div>
            </li>
            <li class="border-top my-3"></li>
            <li class="mb-1">
                <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="false">
                    Account
                </button>
                <div class="collapse" id="account-collapse" style="">
                    <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                        <li><a href="#" class="link-dark rounded">New...</a></li>
                        <li><a href="#" class="link-dark rounded">Profile</a></li>
                        <li><a href="#" class="link-dark rounded">Settings</a></li>
                        <li><a href="#" class="link-dark rounded">Sign out</a></li>
                    </ul>
                </div>
            </li>
        </ul>
    </div>

    <div class="p-3 container-sm">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Handle</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td colspan="2">Larry the Bird</td>
                <td>@twitter</td>
            </tr>
            </tbody>
        </table>
    </div>

</div>


<div class="container">
    <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
        <p class="col-md-4 mb-0 text-muted">&copy; 2021 Company, Inc</p>

        <a href="/" class="col-md-4 d-flex align-items-center justify-content-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
            <h3>haroo</h3>
        </a>

        <ul class="nav col-md-4 justify-content-end">
            <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Home</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Features</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Pricing</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">FAQs</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">About</a></li>
        </ul>
    </footer>
</div>

<!-- Option 1: Bootstrap Bundle with Popper -->
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous">
</script>
</body>
</html>
