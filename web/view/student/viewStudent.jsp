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
    <h1>لیست دانشجوها</h1>

        <button onclick="updatePage()">صفحه بروزرسانی شود</button><br/><br/>
        <a href="defineStudent.jsp">اضافه کردن دانشجو</a><br/><br/>
        <a href="/action/auth/logout">خروج</a><br/>

</center>
<div align="center">
    <table border="1" cellpadding="5">
        <%--<caption><h2>لیست دانشجو ها</h2></caption>--%>
        <tr>
            <th>: حذف رکورد</th>
            <th>: نام</th>
            <th>: نام خانوادگی</th>
            <%--<th>: رمز عبور</th>--%>
            <th>: شماره</th>
        </tr>
        <c:forEach items="${sessionScope.studentList}" var="student" >
            <tr>
                <td>
                        <%--<a href="/action/universityController/update?universityId=${university.universityId}'/>">ویرایش</a>--%>
                        <%--&nbsp;&nbsp;&nbsp;&nbsp;--%>
                    <a href="/action/studentController/delete?studentId=${student.studentId}">حذف</a>
                        <%--<button onclick="remove(${university.universityId})"></button>--%>
                </td>
                <td><c:out value="${student.name}" /></td>
                <td><c:out value="${student.family}" /></td>
                <%--<td><c:out value="${student.pass}" /></td>--%>
                <td><c:out value="${student.studentId}" /></td>
            </tr>
        </c:forEach>
    </table>

    <table  id="dg" class="easyui-datagrid" style="width:0px;height:0px;visibility: hidden !important;"
            url="/action/studentController/read"
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