var code; //在全局 定义验证码
var str = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u'
    , 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];
var code_pass = false;

/**
 * @return {string}
 */
function RndStr(n) {
    var rnd = "";
    for (var i = 0; i < n; i++)
        rnd += str[Math.floor(Math.random() * 36)];
    return rnd;
}

function createCode() {
    code = "";
    var checkCode = document.getElementById("checkCode");
    code = RndStr(4);
    if (checkCode) {
        checkCode.className = "code";
        checkCode.value = code;
    }
}

// 异步请求demo
$(document).ready(function () {
    createCode();
    $("#register_up").click(function () {
        //验证码
        var inputCode = document.getElementById("input_code").value;

        if (inputCode.length <= 0) {
            alert("请输入验证码！");
        }
        else if (inputCode !== code) {
            alert("验证码输入错误！");
            createCode(); //刷新验证码
        }
        else {
            code_pass = true;
        }

        if (code_pass) {
            code_pass = false;
            //发送 post 请求
            try {

                // 密码的正则表达式
                var pattern_pass = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{4,}$/;

                var password = $("input[name=\"password\"]").val();
                var check_password = $("input[name=\"check_password\"]").val();

                var password_test = ((password === check_password) && pattern_pass.test(password));

                if (password_test) {
                    alert($("#username").val());
                    $.post("../register", // path

                        //在这里加密
                        {
                            'username': $("#username").val(),
                            'password': md5($("#password").val())
                        },
                        function (data) {
                            data = JSON.parse(data); // get js object
                            if (data.result === "OK") {
                                window.location.href = ".."; //回到首页
                            }
                            else {
                                alert(data.error);
                            }
                        }
                    ).success(function (data) { // callback function
                        //for test
                    })
                        .fail(function (jqXHR, textStatus, error) {
                            alert(textStatus + ": " + error);
                        });
                }
                else {

                    if (pattern_pass.test(password)) {
                        alert("两次密码不相同！！！");
                    }
                    else {
                        alert("密码格式不正确，必须为包含数字和字母的4位或以上的字符串！！！")
                    }
                }

            } catch (e) {
                alert(e.message);
            }
        }

        // alert("here");
        // $.get, $.ajax
    });
});
