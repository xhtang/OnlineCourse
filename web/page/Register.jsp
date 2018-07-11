<%--
  Created by IntelliJ IDEA.
  User: asus1
  Date: 2017/7/13
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>

    <!-- Bootstrap core CSS -->
    <link href="../bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
<body>

<%@include file="include/header.jsp"%>

<div>
    <div id="register_form">
        <form id="registerForm">
            <h2 id="register_title">Please sign up</h2>
            <input class="register_text placeholder_text" id="username" type="text" name="username" placeholder="Username" required>
            <br>
            <input class="register_text placeholder_text" id="password" type="password" name="password" placeholder="Password" required>
            <span id="password_desc">密码为4位及以上的由数字和字母构成的字符串</span>
            <br>
            <input class="register_text placeholder_text" id="check_password" type="password" name="check_password" placeholder="Check Password" required>
            <br>
            <div class="checkbox" id="register_remember">
                <label>
                    <input type="checkbox" value="remember-me">Remember me
                </label>
            </div>
            <input type="text" id="input_code" />
            <input type="text" onclick="createCode()" readonly="readonly" id="checkCode" class="unchanged"/><br/>
            <button type="button" id="register_up">Sign up</button>
            <br>
            <a id="register_in" href="Login.jsp">Sign in</a>
        </form>
    </div>
</div>

<footer>
    <div id="copyrightRow">
        <div class="container">
            <p>All images are copyright to their owners. This is just a hypothetical site
                <span style="float: right">&copy; 2017 Copyright Art Store</span></p>
        </div>
    </div>

</footer>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/md5.min.js"></script>
<script src="../js/register.js"></script>

</body>
</html>
