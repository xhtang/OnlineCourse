var code; //在全局 定义验证码
var str = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u'
    ,'v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'];
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

$(document).ready(function () {
    createCode();
    $("#login_in").click(function () {
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
            $.post("../login",
                {'username': $("#username").val(), 'password': md5($("#password").val())},
                function (data) {
                    data = JSON.parse(data); // get js object
                    if (data.existed === "TRUE") {
                        if (data.password === "TRUE") {
                            window.location.href = ".."; //回到首页

                        }
                        else {
                            alert("用户名和密码错误！")
                        }
                    }
                    else {
                        alert("用户名和密码错误！")
                    }
                })
        }
    })
});

