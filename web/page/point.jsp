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
<jsp:useBean id="videoList" type="java.util.List<entity.Video>" scope="request"/>
<jsp:useBean id="userState" type="java.lang.String" scope="request"/>

<div class="container" style="padding: 10px;">

    <div class="row" style="margin-top: 10px;">
        <div class="col-8">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">${courseDetail.course.coursename}</a></li>
                    <li class="breadcrumb-item"><a href="#">${point.description}</a></li>
                </ol>
            </nav>

            <c:if test="${userState.equals(\"MyTeachCourse\")}">
                <form method="post" action="addVideo" enctype="multipart/form-data">
                    <div class="form-group">
                        <button id="video_chooser" type="button" class="btn btn-primary">选择视频</button>

                        <button id="upload" type="submit" class="btn btn-primary">上传</button>

                        <input name="pointId" value="${point.id}" hidden>
                        <input id="uploade_video" accept="video/mp4" type="file" name="video" hidden/>
                    </div>
                </form>
            </c:if>
            <c:forEach items="${videoList}" var="video">
                <video style="width: 100%; margin-top: 20px;" src="res/video/${video.path}" controls="controls">
                    您的浏览器不支持 video 标签。
                </video>
            </c:forEach>


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

<script>
    $("#video_chooser").click(function () {
        $("#uploade_video").click();
    });
</script>

</body>
</html>
