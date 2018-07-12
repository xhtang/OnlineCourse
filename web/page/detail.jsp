<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: flower
  Date: 2018/7/11
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程详情</title>

    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="jquery/jquery-3.3.1.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
</head>
<body>
<jsp:include page="include/header.jsp"/>

<jsp:useBean id="courseDetail" type="entity.CourseDetails" scope="request"/>
<jsp:useBean id="userState" type="java.lang.String" scope="request"/>


<div class="container" style="padding: 10px;">

    <div class="row" style="margin-top: 10px;">
        <div class="col-8">
            <div id="accordion">

                <c:if test="${courseDetail.chapterDetailsList.size()==0}">
                    <div>当前课程暂无章节</div>
                </c:if>
                <!--对章节循环-->
                <c:forEach items="${courseDetail.chapterDetailsList}" var="chapterDetail">
                    <div class="card">
                        <div class="card-header" id="heading${chapterDetail.chapter.description}">
                            <h5 class="mb-0">
                                <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    ${chapterDetail.chapter.description}
                                </button>
                            </h5>
                        </div>

                        <div id="collapse${chapterDetail.chapter.description}" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                            <div class="card-body">
                                <ul>
                                    <!-- 对章节知识点循环 -->
                                    <c:forEach items="${chapterDetail.points}" var="point">
                                        <li>${point.description}</li>
                                    </c:forEach>

                                </ul>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>




        <div class="col-4">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addChapterModal">
                添加章节
            </button>
        </div>
    </div>

</div>

<div class="modal fade" id="addChapterModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">添加新章节</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <form action="">
                    <div class="form-group row">
                        <label for="chapterDescription" class="col-sm-3 col-form-label">章节名称</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="chapterDescription" placeholder="Chapter Description">
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                        <button id="create_new_chapter" type="submit" class="btn btn-primary">创建</button>
                    </div>
                </form>

            </div>

        </div>
    </div>
</div>


</body>
</html>
