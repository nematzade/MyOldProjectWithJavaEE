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
</head>
<body>
<center>
    <h1>لیست مدیرها</h1>
        <a href="defineManager.jsp">اضافه کردن مدیر</a><br/><br/>
        <a href="/action/auth/logout">خروج</a><br/><br/>

</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>لیست دانشکده ها</h2></caption>
        <tr>
            <th>: حذف رکورد</th>
            <th>: نام</th>
            <th>: نام خانوادگی</th>
            <th>: شماره</th>
        </tr>
        <c:forEach items="${sessionScope.managerList}" var="manager" >
            <tr>
                <td>
                    <%--<a href="/action/managerController/delete?managerId=${manager.managerId}">حذف</a>--%>
                    <input type="button"
                           onclick="onDelete(${manager.managerId},'/action/managerController/delete?managerId=',
                                   'http://localhost/view/admin/viewListManager.jsp',
                                   '/action/managerController/read');loading('/action/managerController/read')" value="حذف"/>
                </td>

                <td><c:out value="${manager.name}" /></td>
                <td><c:out value="${manager.family}" /></td>
                <td><c:out value="${manager.managerId}" /></td>
            </tr>
        </c:forEach>
    </table>

    <table  id="dg" class="easyui-datagrid" style="width:0px;height:0px;visibility: hidden !important;"
            url="/action/managerController/read"
            toolbar="#toolbar"
            rownumbers="true" fitColumns="true" singleSelect="true">

    </table>

</div>
</body>
</html>