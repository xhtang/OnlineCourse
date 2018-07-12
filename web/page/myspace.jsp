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

    <c:if test="${state==\"1\"}">
        <div style="margin-top: 10px;">
            <a href="search" class="btn btn-primary">选课</a>
        </div>

    </c:if>
    <c:if test="${state==\"2\"}">
        <div style="margin-top: 10px;">
            <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#openCourseModal">添加课程</a>
        </div>

    </c:if>

    <div class="row">

        <c:forEach items="${courses}" var="course">
            <div class="col-3" style="margin-top: 10px;">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${course.coursename}</h5>
                        <p class="card-text">${course.description}</p>
                        <a href="detail?courseId=${course.id}" class="btn btn-primary">查看</a>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="openCourseModal" tabindex="-1" role="dialog" aria-labelledby="openCourseModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="openCourseModalLabel">开设课程</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="opencourse" enctype="multipart/form-data" id="openCourseForm">
                    <div class="form-group">
                        <label for="coursename" class="col-form-label">课程名称</label>
                        <input name="coursename" type="text" class="form-control" id="coursename">
                    </div>
                    <div class="form-group">
                        <label for="description" class="col-form-label">课程描述:</label>
                        <textarea name="description" class="form-control" id="description"></textarea>
                    </div>

                    <button id="img_chooser" type="button" class="btn btn-primary">选择图片</button>

                    <input id="courseimg" type="file" name="filepath" hidden/>

                    <img style="max-width: 100%; margin-top: 10px;" src="" id="preview">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button form="openCourseForm" type="submit" class="btn btn-primary">创建</button>
            </div>
        </div>
    </div>
</div>


<script>
    // 选择图片
    $("#courseimg").change(function(){
        // getObjectURL是自定义的函数，见下面
        // this.files[0]代表的是选择的文件资源的第一个，因为上面写了 multiple="multiple" 就表示上传文件可能不止一个
        // ，但是这里只读取第一个
        var objUrl = getObjectURL(this.files[0]) ;
        // 这句代码没什么作用，删掉也可以
        // console.log("objUrl = "+objUrl) ;
        if (objUrl) {
            // 在这里修改图片的地址属性
            $("#preview").attr("src", objUrl) ;
        }
    }) ;
    //建立一個可存取到該file的url
    function getObjectURL(file) {
        var url = null ;
        // 下面函数执行的效果是一样的，只是需要针对不同的浏览器执行不同的 js 函数而已
        if (window.createObjectURL!=undefined) { // basic
            url = window.createObjectURL(file) ;
        } else if (window.URL!=undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file) ;
        } else if (window.webkitURL!=undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file) ;
        }
        return url ;
    }

    $("#img_chooser").click(function () {
        $("#courseimg").click();
    });
</script>
</body>
</html>
