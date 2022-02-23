<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rookie
  Date: 2022/1/23
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书记展示</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 columu">
            <div class="page-header">
                <h1>
                    <small>书籍列表————————————————显示所有书籍</small>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 columu" >
                <div style="background: deepskyblue;width: 115px;height: 30px;border-radius: 5px">
                    <a href="${pageContext.request.contextPath}/book/toAddBook" style="color: black;margin: 20px;font-size: 18px;line-height: 30px">新增书籍</a>
                </div>


            </div>
        </div>
        <div style="height: 30px;float: right">
            <form method="post" action="${pageContext.request.contextPath}/book/lookBooks">
                <label for="bookName">书籍名称：</label>
                <input type="text" id="bookName" name="bookName" value="${bookname}">
                <input type="submit" value="查找">
            </form>

        </div>

    </div>

    <div class="row clearfix">
        <div class="col-md-12 columu">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名称</th>
                    <th>书籍数据</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </tr>
                </thead>
<%--                从list中便利--%>
                <tbody>
                <c:forEach var="book" items="${list}">
                    <tr>
                        <td>${book.bookID}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/book/toUpdateBook/${book.bookID}">修改</a>&nbsp;|&nbsp;
                            <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
