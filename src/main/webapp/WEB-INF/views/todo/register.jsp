<%--
  Created by IntelliJ IDEA.
  User: 주영광교회
  Date: 2023-04-01
  Time: 오전 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>이수진</title>
    <link href="http://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <!--  <h1>Header</h1>-->
    <div class="row">
        <div class="col">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Features</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Pricing</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled">Disabled</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

        </div>
    </div>
    <!--header end-->
    <!--header 기존의 <h1>header</h1> 끝-->
    <div class="row content">
        <div class="col">
            <div class="card">
                <div class="card-header">
                    Featured
                </div>
                <div class="card-body">
                    <form action="/todo/register" method="post">
                        <div class="input-group mb-3">
                            <span class="input-group-text">제목</span>
                            <input type="text" name="title" class="form-control" placeholder="Title">
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">날짜</span>
                            <input type="date" name="dueDate" class="form-control" placeholder="Writer">
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">작성자</span>
                            <input type="text" name="Writer" class="form-control" placeholder="Writer">
                        </div>

                        <div class="my-4">
                            <div class="float-end">
                                <button type="submit" class="btn btn-primary">확인</button>
                                <button type="result" class="btn btn-secodary">취소</button>
                            </div>
                        </div>
                    </form>
                    <script>//p323
                        const serverValidResult ={}
                        <c:forEach items="${errors}" var="error">
                        serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
                        </c:forEach>
                        console.log(serverValidResult)
                    </script>

                </div>
            </div>
        </div>
    </div>
    <div class="row content">
        <h1>내용</h1>
    </div>

    <div class="row footer">
        <!--   <h1>Footer</h1>-->
        <div class="row fixed-bottom" style="z-index: -100">
            <footer class="py-1 my-1">
                <p class="text-center text-muted">Footer</p>
            </footer>
        </div>
    </div>
</div>
</body>
</html>
