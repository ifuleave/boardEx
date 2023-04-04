<%--
  Created by IntelliJ IDEA.
  User: 주영광교회
  Date: 2023-04-02
  Time: 오후 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="row">
            <div class="col">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">Navbar</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                            <div class="navbar-nav">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                                <a class="nav-link" href="#">Features</a>
                                <a class="nav-link" href="#">Pricing</a>
                                <a class="nav-link disabled">Disabled</a>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </div>

        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        Featured
                    </div>

        <div class="card-body">
            <h5 class="card-title">Special title treatment</h5>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">번호</th>
                    <th scope="col">제목</th>
                    <th scope="col">작성자</th>
                    <th scope="col">날짜</th>
                    <th scope="col">완료여부</th>
                </tr>
                </thead>
                <tbody>         <!--model에 responseDTO라는 이름으로 PageResponseDTO를 담아주었기 때문에-->
                <c:forEach items="${responseDTO.dtoList}" var="dto">
                    <tr>
                        <th scope="row"><c:out value="${dto.tno}"/></th>
                        <td>
                            <a href="/todo/read?tno=${dto.tno}" class="text-decoration-none" data-tno="${dto.tno}">
                                <c:out value="${dto.title}"/></a>
                        </td>
                        <td><c:out value="${dto.writer}"/></td>
                        <td><c:out value="${dto.dueDate}"/></td>
                        <td><c:out value="${dto.finished}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="float-end">
                <ul class="pagination flex-wrap">
                    <c:if test="${responseDTO.prev}"> <!--c:if를 이용해서 prev/next 처리하면 11페이지 이상되었을때 이전버튼이 보이게, 1~10이면 이전버튼 안보이게-->
                        <li class="page-item">
                            <a class="page-link" data-num="${responseDTO.start -1}">이전</a>
                        </li>                       <!--data-num이라는 속성을 추가해서 페이지 번호를 보관하도록 구성 -->
                    </c:if>
                    <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                        <li class="page-item ${responseDTO.page == num? "active":""}"><a class="page-link" href="#">${num}</a></li>
                    </c:forEach>
                    <c:if test="${responseDTO.next}">
                        <li class="page-item">
                            <a class="page-link" data-num="${responseDTO.end+1}">다음</a>
                        </li>
                    </c:if>
                </ul>
            </div>
            <script>
                document.querySelector(".pagination").addEventListener("click",function (e){
                    e.preventDefault()
                    e.stopPropagation()

                    const target = e.target
                    if(target.tagName !== 'A'){
                        return
                    }
                    const num = target.getAttribute("data-num") //a태그를 클릭했을때만 data-num속성값을 읽어와서 현재주소를 변경하는 방식으로 작성
                    const formObj = document.querySelector("form");
                    formObj.innerHTML += `<input type='hidden' name='page' value='\${num}'>` //``(백틱)을 이요하면 문자열 결합에 +를 이용해야 하는 불편함을 줄일 수 있음
                    formObj.submit();

                },false)
            </script>
        </div>
    </div>
</div>
 </div>
    </div>
</div>
</body>
</html>
