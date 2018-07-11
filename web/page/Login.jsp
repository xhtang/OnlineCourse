<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link href="../bootstrap/css/bootstrap.css" rel="stylesheet">

    <link href="../css/login.css" rel="stylesheet">

</head>
<body>
<%@include file="include/header.jsp"%>

<div>
    <div>
        <form id="login_form">
            <h2 id="login_title">Please sign in</h2>
            <input class="placeholder_text login_text" type="text" id="username" name="username" placeholder="Enter username">
            <br>
            <input class="placeholder_text login_text" type="password" id="password" name="password" placeholder="Enter password">
            <br>
            <div class="checkbox" id="login_remember">
                <label>
                    <input type="checkbox" value="remember-me">Remember me
                </label>
            </div>
            <input type="text" id="input_code" />
            <input type="text" onclick="createCode()" readonly="readonly" id="checkCode" class="unchanged"/><br />
            <button id="login_in" type="button">Sign in</button>
            <br>
            <a id="login_up" href="Register.jsp">Sign up</a>
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
<script src="../jquery/jquery-3.3.1.js"></script>
<script src="../bootstrap/js/bootstrap.js"></script>
<script src="../js/md5.min.js"></script>
<script src="../js/login.js"></script>

</body>
</html>
