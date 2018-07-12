<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: flower
  Date: 2018/7/11
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>课程详情</title>

    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="jquery/jquery-3.3.1.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
</head>
<body>
<jsp:include page="include/header.jsp"/>

<jsp:useBean id="courseDetail" type="entity.CourseDetails" scope="session"/>
<jsp:useBean id="userState" type="java.lang.String" scope="request"/>


<div class="container" style="padding: 10px;">

    <h3><span class="badge badge-secondary">${courseDetail.course.coursename}</span></h3>
    <div class="row" style="margin-top: 10px;">
        <div class="col-6">
            <div id="accordion">

                <c:if test="${courseDetail.chapterDetailsList.size()==0}">
                    <div>当前课程暂无章节</div>
                </c:if>
                <!--对章节循环-->
                <c:forEach items="${courseDetail.chapterDetailsList}" var="chapterDetail">
                    <div class="card">
                        <div class="card-header" id="heading${chapterDetail.chapter.id}">
                            <h5 class="mb-0">

                                <button class="btn btn-link" data-toggle="collapse" data-target="#collapse${chapterDetail.chapter.id}" aria-expanded="true" aria-controls="collapse${chapterDetail.chapter.id}">
                                    ${chapterDetail.chapter.description}
                                </button>

                                <c:if test="${\"MyTeachCourse\".equals(userState)}">
                                    <button id="addPointButton${chapterDetail.chapter.id}" chapterId="${chapterDetail.chapter.id}" class="btn btn-link addPointButton" style="float: right;" data-toggle="modal" data-target="#addPointModal">
                                        添加知识点
                                    </button>
                                </c:if>

                            </h5>
                        </div>

                        <div id="collapse${chapterDetail.chapter.id}" class="collapse show" aria-labelledby="heading${chapterDetail.chapter.id}" data-parent="#accordion">
                            <div class="card-body">
                                <ul class="list-group list-group-flush">
                                    <!-- 对章节知识点循环 -->
                                    <c:forEach items="${chapterDetail.points}" var="point">
                                        <li class="list-group-item list-group-item-action"><a href="point?pointId=${point.id}">${point.description}</a></li>
                                    </c:forEach>

                                </ul>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>


        <div class="col-2">
        </div>

        <div class="col-4">
            <c:if test="${\"MyTeachCourse\".equals(userState)}">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addChapterModal">
                    添加章节
                </button>
            </c:if>

        </div>
    </div>

</div>

<div class="modal fade" id="addChapterModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addChapterModalLongTitle">添加新章节</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <form action="addChapter" id="addChapterForm">
                    <div class="form-group row">
                        <label for="chapterDescription" class="col-sm-3 col-form-label">章节名称</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="chapterDescription" id="chapterDescription" placeholder="Chapter Description">
                        </div>
                    </div>
                </form>

            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button form="addChapterForm" type="submit" class="btn btn-primary">创建</button>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="addPointModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addPointModalLongTitle">添加新知识点</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <form action="addPoint" id="addPointForm">
                    <div class="form-group row">
                        <label for="PointDescription" class="col-sm-3 col-form-label">知识点名称</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="pointDescription" id="PointDescription" placeholder="Point Description">
                            <input id="chapterId" name="chapterId" hidden>
                        </div>
                    </div>
                </form>

            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button form="addPointForm" type="submit" class="btn btn-primary">创建</button>
            </div>

        </div>
    </div>
</div>

<script>
    $(".addPointButton").click(function () {

        var currentChapterId = $(this).attr("chapterId");
        $("#chapterId").val(currentChapterId);
    })
</script>


</body>
</html>
