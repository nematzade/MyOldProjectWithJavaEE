<%--
  Created by IntelliJ IDEA.
  User: Mohammad
  Date: 22/12/2017
  Time: 01:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>خطا</title>
</head>
<body>

<h2>ورود شما با خطا مواجه شد.</h2>
<%--<center>--%>
    <%--<h1>ویرایش مقادیر</h1>--%>
    <%--<h2>--%>
        <%--<a href="view/admin/defineUniversity.jsp">تعریف دانشگاه</a>--%>
        <%--&nbsp;&nbsp;&nbsp;--%>
        <%--<a href="view/admin/viewListUniversity.jsp"> لیست دانشگاه ها</a>--%>
    <%--</h2>--%>
<%--</center>--%>
<%--<div align="center">--%>
    <%--<form id="frmU">--%>
            <%--<table border="1" cellpadding="5">--%>
                <%--<tr>--%>
                    <%--<td>--%>
                        <%--<input type="text" name="universityId"/>--%>
                    <%--</td>--%>
                    <%--<th>: شماره</th>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>--%>
                        <%--<input type="text" name="universityName"/>--%>
                    <%--</td>--%>
                    <%--<th>: نام</th>--%>
                <%--</tr>--%>

                <%--<tr>--%>
                    <%--<td colspan="2" align="center">--%>
                        <%--<input type="button" onclick="mergeUni()" value="ویرایش" />--%>
                    <%--</td>--%>
                <%--</tr>--%>
            <%--</table>--%>
        <%--</form>--%>

    <%--<table  id="dg" class="easyui-datagrid" style="width:0px;height:0px;visibility: hidden !important;"--%>
            <%--url="/action/universityController/read"--%>
            <%--toolbar="#toolbar"--%>
            <%--rownumbers="true" fitColumns="true" singleSelect="true">--%>

    <%--</table>--%>

<%--</div>--%>


<%--<script type="text/javascript">--%>
    <%--var url;--%>
    <%--function mergeUni(){--%>
        <%--$('#frmU').form('submit',{--%>
            <%--url: '/action/universityController/update',--%>
            <%--onSubmit: function(){--%>
                <%--return $(this).form('validate');--%>
            <%--},--%>
            <%--success: function(result){--%>
                <%--var result = eval('('+result+')');--%>
                <%--if (result.errorMsg){--%>
                    <%--$.messager.show({--%>
                        <%--title: 'دوباره سعی کنید...',--%>
                        <%--msg: result.errorMsg--%>
                    <%--});--%>
                <%--} else {--%>
                    <%--window.location.reload();--%>

                <%--}--%>
            <%--}--%>
        <%--});--%>
        <%--window.location.reload();--%>
        <%--window.location.reload();--%>
    <%--}--%>
<%--</script>--%>

</body>
</html>
