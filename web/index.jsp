<%--
  Created by IntelliJ IDEA.
  User: asus1
  Date: 2018/7/8
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>

<%--<jsp:useBean id="user" type="java.lang.String" scope="request"/>--%>
<html>
<head>
    <title>课程首页</title>

    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="jquery/jquery-3.3.1.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>

</head>
<body>

<jsp:include page="page/include/header.jsp" />

<jsp:useBean id="heat" type="java.util.List<entity.Course>" scope="request"/>
<jsp:useBean id="latest" type="java.util.List<entity.Course>" scope="request"/>

<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img height="500px" class="d-block w-100" src="res/img/${heat[0].img}" alt="First slide">
            <div class="carousel-caption d-none d-md-block">
                <h5>${heat[0].coursename}</h5>
                <p>${heat[0].description}</p>
            </div>
        </div>
        <div class="carousel-item">
            <img height="500px" class="d-block w-100" src="res/img/${heat[1].img}" alt="Second slide">
            <div class="carousel-caption d-none d-md-block">
                <h5>${heat[1].coursename}</h5>
                <p>${heat[1].description}</p>
            </div>
        </div>
        <div class="carousel-item">
            <img height="500px" class="d-block w-100" src="res/img/${heat[2].img}" alt="Third slide">
            <div class="carousel-caption d-none d-md-block">
                <h5>${heat[2].coursename}</h5>
                <p>${heat[2].description}</p>
            </div>
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="container" style="margin-top: 10px;">
    <div class="row">
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <img style="width: 100%;" src="res/img/${latest[0].img}" alt="...">
                <div class="caption">
                    <h3>${latest[0].coursename}</h3>
                    <p>${latest[0].description}</p>
                    <p><a href="detail?courseId=${latest[0].id}" class="btn btn-primary" role="button">查看</a></p>
                </div>
            </div>
        </div>
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <img style="width: 100%;" src="res/img/${latest[1].img}" alt="...">
                <div class="caption">
                    <h3>${latest[1].coursename}</h3>
                    <p>${latest[1].description}</p>
                    <p><a href="detail?courseId=${latest[1].id}" class="btn btn-primary" role="button">查看</a></p>
                </div>
            </div>
        </div>
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <img style="width: 100%;" src="res/img/${latest[2].img}" alt="...">
                <div class="caption">
                    <h3>${latest[2].coursename}</h3>
                    <p>${latest[2].description}</p>
                    <p><a href="detail?courseId=${latest[2].id}" class="btn btn-primary" role="button">查看</a></p>
                </div>
            </div>
        </div>


    </div>
</div>

</body>
</html>
