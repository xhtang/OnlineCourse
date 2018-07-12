
// 异步请求demo
$(document).ready(function () {
    $("#register").click(function () {
        var reg_username = $("#reg-username").val();
        var reg_password = $("#reg-password").val();

        var check_password = $("#check-password").val();

        if (reg_password === check_password) {

            $.post("register", // path

                //在这里加密
                {
                    'username': reg_username,
                    'password': md5(reg_password)
                },
                function (data) {
                    data = JSON.parse(data); // get js object
                    if (data.result === "OK") {
                        window.location.href = "http://localhost:8080/online-course/"; //回到首页
                    }
                    else {
                        alert("存在同名的用户");
                    }
                }
            );
        }
        else {
            alert("两次密码不相同")
        }
    });


});
