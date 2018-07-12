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
    <title>开设课程</title>

    <link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="../jquery/jquery-3.3.1.js"></script>
    <script src="../bootstrap/js/bootstrap.js"></script>
</head>
<body>
<form action="../opencourse" method="post" enctype="multipart/form-data" id="openCourseForm">
    <h2 id="register_title">开设课程</h2>
    <label for="coursename">课程名称</label>
    <input class="placeholder_text" id="coursename" type="text" name="coursename" placeholder="coursename" required>
    <br>
    <label for="description">课程简介</label>
    <textarea class="placeholder_text" id="description" type="text" name="description" required></textarea>
    <br>
    <label for="description">课程图片</label>
    <input id="courseimg" type="file" name="filepath" /> <br>

    <input type="submit" value="开设">
</form>

<img src="" id="preview" >

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
</script>
</body>
</html>
