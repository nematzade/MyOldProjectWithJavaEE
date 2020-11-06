<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>

    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/themes/color.css">
    <script type="text/javascript" src="/jquery-easyui-1.5.3/jquery.min.js"></script>
    <script type="text/javascript" src="/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>

</head>

<body>

<center>
    <h1>لیست دروس</h1>

        <a href="defineCourse.jsp">اضافه کردن درس</a>
        <br/><br/>
        <a href="/action/auth/logout">خروج</a><br/><br/>

</center>

<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>: حذف رکورد</th>
            <th>: نام</th>
            <th>: تعداد واحد</th>
            <th>: ظرفیت</th>
            <th>: شماره</th>
        </tr>
        <c:forEach items="${sessionScope.courseList}" var="course" >
            <tr>
                <td>
                    <input type="button" onclick="onDelete(${course.courseId});" value="حذف"/>
                </td>
                <td><c:out value="${course.name}" /></td>
                <td><c:out value="${course.unit}" /></td>
                <td><c:out value="${course.capacity}" /></td>
                <td><c:out value="${course.courseId}" /></td>
            </tr>
        </c:forEach>
    </table>

    <table  id="dg" class="easyui-datagrid" style="width:0px;height:0px;visibility: hidden !important;"
            url="/action/courseController/read"
            toolbar="#toolbar"
            rownumbers="true" fitColumns="true" singleSelect="true">

    </table>

    <script type="text/javascript">

        function ldPersist() {
            $.post("/action/courseController/read", function(){});
        }

        function onDelete(id){
            $.post("/action/courseController/delete?courseId="+id, function(){window.location.reload();});

            $.ajax({
                url: 'http://localhost/view/course/viewCourse.jsp',
                success: function() {
                    ldPersist();
                    alert("حذف شد!!!");

                }
            });

        }

    </script>

</div>
</body>
</html>