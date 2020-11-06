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
    <h1>لیست کارمندها</h1>
    <h2>
        <button onclick="updatePage()">صفحه بروزرسانی شود</button>
        <a href="defineTeller.jsp">اضافه کردن کارمند</a>
        <a href="/action/auth/logout">خروج</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>لیست کارمند ها</h2></caption>
        <tr>
            <th>: حذف رکورد</th>
            <th>: نام</th>
            <th>: نام خانوادگی</th>
            <%--<th>: رمز عبور</th>--%>
            <th>: شماره</th>
        </tr>
        <c:forEach items="${sessionScope.tellerList}" var="teller" >
            <tr>
                <td>
                        <%--<a href="/action/universityController/update?universityId=${university.universityId}'/>">ویرایش</a>--%>
                        <%--&nbsp;&nbsp;&nbsp;&nbsp;--%>
                    <a href="/action/tellerController/delete?tellerId=${teller.tellerId}">حذف</a>
                        <%--<button onclick="remove(${university.universityId})"></button>--%>
                </td>
                <td><c:out value="${teller.name}" /></td>
                <td><c:out value="${teller.family}" /></td>
                <%--<td><c:out value="${teller.pass}" /></td>--%>
                <td><c:out value="${teller.tellerId}" /></td>
            </tr>
        </c:forEach>
    </table>

    <table  id="dg" class="easyui-datagrid" style="width:0px;height:0px;visibility: hidden !important;"
            url="/action/tellerController/read"
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