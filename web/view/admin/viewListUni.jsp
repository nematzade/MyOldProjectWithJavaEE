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
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/themes/color.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/demo/demo.css">
    <script type="text/javascript" src="/jquery-easyui-1.5.3/jquery.min.js"></script>
    <script type="text/javascript" src="/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/common/common.js"></script>
    <script type="text/javascript" src="/common/angularjs.min.js"></script>
    <script type="text/javascript" src="/common/ang.js"></script>
</head>
<body>
<center>
    <h1>لیست دانشکده ها</h1>

        <a href="defineUni.jsp">اضافه کردن دانشکده</a>
        <br/><br/>
        <a href="/action/auth/logout">خروج</a><br/><br/>
        <%--<button onclick="updatePage()">صفحه بروزرسانی شود</button><br/>--%>
    <br/>

</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>لیست دانشکده ها</h2></caption>
        <tr>
            <th>: حذف رکورد</th>
            <th>نام دانشگاه</th>
            <th>: نام دانشکده</th>
            <th>: شماره</th>
        </tr>
        <c:forEach items="${sessionScope.uniList}" var="uni" >
            <tr>
                <td>
                        <input type="button" onclick="onDelete(${uni.uniId},
                                '/action/uniController/delete?uniId=',
                                'http://localhost/view/admin/viewListUni.jsp',
                                '/action/uniController/read');reloadPage();" value="حذف"/>
                </td>
                <td><c:out value="${uni.universityName}" /></td>
                <td><c:out value="${uni.uniName}" /></td>
                <td><c:out value="${uni.uniId}" /></td>
            </tr>
        </c:forEach>
    </table>
<br/>
    <table border="1" cellpadding="5" data-ng-app="uniApp" data-ng-controller="uniController">
        <caption><h2>لیست دانشکده ها</h2></caption>
        <tr>
            <th>: حذف رکورد</th>
            <th>نام دانشگاه</th>
            <th>: نام دانشکده</th>
            <th>: شماره</th>
        </tr>
        <tr data-ng-repeat="x in unis">
            <td>
                <%--<input type="button" onclick="onDelete({{x.uniId}},--%>
                        <%--'/action/uniController/delete?uniId=',--%>
                        <%--'http://localhost/view/admin/viewListUni.jsp',--%>
                        <%--'/action/uniController/read');reloadPage();" value="حذف"/>--%>
                <a type="button" href="/action/uniController/delete?uniId=">حذف</a>
            </td>
            <td>{{x.universityName}}</td>
            <td>{{x.uniName}}</td>
            <td>{{x.uniId}}</td>
        </tr>
    </table>

    <table  id="dg" class="easyui-datagrid" style="width:0px;height:0px;visibility: hidden !important;"
            url="/action/uniController/read"
            toolbar="#toolbar"
            rownumbers="true" fitColumns="true" singleSelect="true">

    </table>

    <script type="text/javascript">

        function reloadPage() {
            window.location.reload();
        }

    </script>

</div>
</body>
</html>