<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: flower
  Date: 2018/7/12
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人空间</title>

    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="jquery/jquery-3.3.1.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>

</head>
<body>

<jsp:include page="include/header.jsp" />
<jsp:useBean id="state" type="java.lang.String" scope="request"/>
<jsp:useBean id="courses" type="java.util.List<entity.Course>" scope="request"/>

<div class="container">

    <ul class="nav nav-tabs" style="margin-top: 10px;">
        <c:if test="${state==\"1\"}">
            <li class="nav-item">
                <a class="nav-link active" href="myspace?state=1">我选的课</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="myspace?state=2">我开的课</a>
            </li>
        </c:if>
        <c:if test="${state==\"2\"}">
            <li class="nav-item">
                <a class="nav-link" href="myspace?state=1">我选的课</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="myspace?state=2">我开的课</a>
            </li>
        </c:if>

    </ul>

    <div class="row" style="margin-top: 10px;">

        <c:forEach items="${courses}" var="courses">
            <div class="col-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Special title treatment</h5>
                        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>

</body>
</html>
