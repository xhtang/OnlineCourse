<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: flower
  Date: 2018/7/13
  Time: 01:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>知识点展示</title>

    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="jquery/jquery-3.3.1.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>

</head>
<body>
<jsp:include page="include/header.jsp"/>

<jsp:useBean id="courseDetail" type="entity.CourseDetails" scope="session"/>
<jsp:useBean id="point" type="entity.Point" scope="request"/>

<div class="container" style="padding: 10px;">

    <h3><span class="badge badge-secondary">${courseDetail.course.coursename}</span></h3>
    <div class="row" style="margin-top: 10px;">
        <div class="col-6">

        </div>


        <div class="col-2">
        </div>

        <div class="col-4">

            <c:forEach items="${courseDetail.chapterDetailsList}" var="chapterDetail">
                <div class="list-group" style="margin-top: 10px;">

                    <a href="#" class="list-group-item list-group-item-action active">
                            ${chapterDetail.chapter.description}
                    </a>

                    <c:forEach items="${chapterDetail.points}" var="point">
                        <a href="point?pointId=${point.id}" class="list-group-item list-group-item-action">${point.description}</a>
                    </c:forEach>

                </div>

            </c:forEach>

        </div>
    </div>

</div>



</body>
</html>
