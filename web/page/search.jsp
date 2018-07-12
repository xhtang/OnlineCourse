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
<%--<jsp:useBean id="user" class="entity.User" scope="session"/>--%>

<div class="container">
    <div class="row" style="margin-top: 10px;">
        ${courses.size()}
        <c:forEach items="${courses}" var="course">
            <div class="col-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${course.coursename}</h5>
                        <p class="card-text">${course.description}</p>
                        <a href="select?courseId=${course.id}" class="btn btn-primary">选课</a>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>

</body>
</html>
