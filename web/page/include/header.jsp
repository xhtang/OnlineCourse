<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="user" class="entity.User" scope="session"/>

<script src="js/login.js"></script>
<script src="js/register.js"></script>
<script src="js/md5.min.js"></script>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="home">首页</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>


    <form action="search" class="form-inline my-2 my-lg-0" style="margin-right: 20px;">
        <input name="coursename" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
    </form>

    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">

        <c:if test="${user.username==null}">
            <button type="button" class="btn btn-primary" style="margin-right: 5px;" data-toggle="modal" data-target="#registerModal">
                注册
            </button>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#loginModal">
                登录
            </button>
        </c:if>

        <c:if test="${user.username!=null}">
            <span id="my_space" style="margin-right: 10px;">Hello <a href="myspace?state=1">${user.username}</a> </span>
            <span id="logout"><a href="logout">退出</a></span>
        </c:if>

    </div>
</nav>


<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="loginModalLongTitle">登录</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <form>
                    <div class="form-group row">
                        <label for="username" class="col-sm-2 col-form-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="username" placeholder="User Name">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="password" class="col-sm-2 col-form-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password" placeholder="Password">
                        </div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button id="login_in" type="button" class="btn btn-primary">登录</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="registerModalLongTitle">注册</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <form>
                    <div class="form-group row">
                        <label for="username" class="col-sm-3 col-form-label">用户名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="reg-username" placeholder="User Name">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="password" class="col-sm-3 col-form-label">密码</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="reg-password" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="password" class="col-sm-3 col-form-label">确认密码</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="check-password" placeholder="Password">
                        </div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button id="register" type="button" class="btn btn-primary">注册</button>
            </div>
        </div>
    </div>
</div>

<script>

</script>

