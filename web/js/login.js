$(document).ready(function () {

    $("#login_in").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();

        $.post("login",
            {'username': username, 'password': md5(password)},
            function (data) {

                data = JSON.parse(data); // get js object

                if (data.existed === "TRUE") {
                    if (data.password === "TRUE") {
                        window.location.href = "../online-course"; //回到首页
                    }
                    else {
                        alert("用户名和密码错误！")
                    }
                }
                else {
                    alert("用户名和密码错误！")
                }
            });
    });
});

