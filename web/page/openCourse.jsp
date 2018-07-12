<%--
  Created by IntelliJ IDEA.
  User: asus1
  Date: 2018/7/12
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OpenCourse</title>
</head>
<body>
<form id="openCourseForm">
    <h2 id="register_title">开设课程</h2>
    <label for="coursename">课程名称</label>
    <input class="placeholder_text" id="coursename" type="text" name="coursename" placeholder="coursename" required>
    <br>
    <label for="description">课程简介</label>
    <textarea class="placeholder_text" id="description" type="text" name="password" required></textarea>
    <br>
    <label for="description">课程图片</label>
    <input id="courseimg" type="file" name="filepath" /> <br>

    <a id="openCourse" href="#">确定开设</a>
</form>
</body>
</html>
