<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: flower
  Date: 2018/7/12
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索课程</title>

    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="jquery/jquery-3.3.1.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>

</head>
<body>
<jsp:include page="include/header.jsp" />

<jsp:useBean id="courses" type="java.util.List<entity.Course>" scope="request"/>
<jsp:useBean id="user" class="entity.User" scope="session"/>

<div class="container">
    <div class="row" style="margin-top: 10px;">
        <c:forEach items="${courses}" var="course">
            <div class="col-3" style="margin-top: 10px;">
                <div class="card">
                    <div class="card-body">
                        
                        <img style="width: 100%; height: 150px;" src="res/img/${course.img}">
                        
                        <h5 style="margin-top: 10px;" class="card-title">${course.coursename}</h5>
                        <p class="card-text">${course.description}</p>
                        <c:if test="${user.username == null}">
                            <a href="#" class="btn btn-primary">请先登录</a>
                        </c:if>
                        <c:if test="${user.username != null}">
                            <a href="select?courseId=${course.id}" class="btn btn-primary">选课</a>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>

</body>
</html>
