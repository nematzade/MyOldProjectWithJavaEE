<%--
  Created by IntelliJ IDEA.
  User: Mohammad
  Date: 22/12/2017
  Time: 01:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/themes/icon.css">
    <script type="text/javascript" src="/jquery-easyui-1.5.3/jquery.min.js"></script>
    <script type="text/javascript" src="/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
</head>
<body>
<center>
    <h1>لیست اساتید</h1>

        <button onclick="updatePage()">صفحه بروزرسانی شود</button><br/><br/>
        <a href="defineTeacher.jsp">اضافه کردن استاد</a><br/><br/>
        <a href="/action/auth/logout">خروج</a><br/><br/>

</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>لیست اساتید</h2></caption>
        <tr>
            <th>: حذف رکورد</th>
            <th>: نام</th>
            <th>: نام خانوادگی</th>
            <%--<th>: رمز عبور</th>--%>
            <th>: شماره</th>
        </tr>
        <c:forEach items="${sessionScope.teacherList}" var="teacher" >
            <tr>
                <td>
                    <a href="/action/teacherController/delete?teacherId=${teacher.teacherId}">حذف</a>
                </td>
                <td><c:out value="${teacher.name}" /></td>
                <td><c:out value="${teacher.family}" /></td>
                <%--<td><c:out value="${teacher.pass}" /></td>--%>
                <td><c:out value="${teacher.teacherId}" /></td>
            </tr>
        </c:forEach>
    </table>

    <table  id="dg" class="easyui-datagrid" style="width:0px;height:0px;visibility: hidden !important;"
            url="/action/teacherController/read"
            toolbar="#toolbar"
            rownumbers="true" fitColumns="true" singleSelect="true">

    </table>

    <script type="text/javascript">
        $(document).ready(function () {

//                window.location.reload();
//                window.location.reload();


        });


        function updatePage() {
            window.location.reload();
            window.location.reload();
            window.location.reload();

        }



    </script>

</div>
</body>
</html>