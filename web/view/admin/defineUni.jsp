<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>

<head>
    <meta charset="utf-8"/>
    <title>تعریف دانشکده</title>
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

<div align="center" data-ng-app="">
    <a href="viewListUni.jsp">نمایش لیست دانشکده ها</a><br/>
    <a href="defineManager.jsp">تعریف مدیر</a><br/>
    <a href="../manager/defineTeller.jsp">تعریف کارمند</a><br/>
    <a href="/action/auth/logout">خروج</a>
<br/>
    <form id="frm" >

        <table border="1" cellpadding="5">
            <tr>
                <td><input id="uniName" class="easyui-validatebox" placeholder="حد اکثر اندازه 20 حرف می باشد"
                           data-options="required:true,validType:'text'" type="text" name="uniName"/></td>
                <th>نام</th>
            </tr>

            <%--<tr>--%>
                <%--<td>--%>
                <%--<select id="cc" class="easyui-combobox" name="universityId" style="width:200px;">--%>
                    <%--<c:forEach items="${sessionScope.list}" var="university" >--%>
                    <%--<option value=${university.universityId}>${university.universityName}</option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>
                <%--</td>--%>

            <%--</tr>--%>
            <tr>
                <td>
                    <input class="easyui-combobox" name="universityId" style="width:100%" data-options="
                url: '/action/universityController/read',
                method: 'get',
                valueField: 'universityId',
                textField: 'universityName',
                limitToList: true,
                hasDownArrow: true,
                prompt: 'نام دانشگاه را انتخاب کنید'
                ">
                </td>
                <th>نام دانشگاه را انتخاب کنید</th>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="button" class="easyui-linkbutton" style="width: 100%" value="ثبت"
                           onclick="newPersist('frm','/action/uniController/persist');loading('/action/uniController/read');"/>
                </td>
            </tr>
        </table>

    </form>
</div>


<br/>
<center>
    <h3>فرم بروز رسانی داده ها</h3>
</center>

<div align="center">

    <form id="frmUpdate" >

        <table border="1" cellpadding="5">

            <table border="1" cellpadding="5">

                <%--<tr>--%>
                    <%--<td>--%>
                        <%--<select id="c" class="easyui-combobox" name="uniId" style="width:200px;">--%>
                            <%--<c:forEach items="${sessionScope.uniList}" var="uni" >--%>
                                <%--<option value=${uni.uniId}>${uni.uniName}</option>--%>
                            <%--</c:forEach>--%>
                        <%--</select>--%>
                    <%--</td>--%>
                    <%--<th>نام دانشکده را انتخاب کنید</th>--%>
                <%--</tr>--%>

                <tr>
                    <td>
                        <input class="easyui-combobox" name="uniId" style="width:100%" data-options="
                url: '/action/uniController/read',
                method: 'get',
                valueField: 'uniId',
                textField: 'uniName',
                limitToList: true,
                hasDownArrow: true,
                prompt: 'نام دانشکده را انتخاب کنید'
                ">
                    </td>
                    <th>نام دانشکده را انتخاب کنید</th>
                </tr>


                <tr>
                    <td><input class="easyui-validatebox" placeholder="حد اکثر اندازه 20 حرف می باشد"
                               data-options="required:true,validType:'text'" type="text" name="uniName"/></td>
                    <th>نام</th>
                </tr>

                    <tr>
                        <td>
                            <input class="easyui-combobox" name="universityId" style="width:100%" data-options="
                url: '/action/universityController/read',
                method: 'get',
                valueField: 'universityId',
                textField: 'universityName',
                limitToList: true,
                hasDownArrow: true,
                prompt: 'نام دانشگاه را انتخاب کنید' ">
                        </td>
                        <th>نام دانشگاه را انتخاب کنید</th>
                    </tr>

                <tr>
                    <td colspan="2" align="center">
                        <input type="button" class="easyui-linkbutton" style="width: 100%" value="ثبت"
                               onclick="update('frmUpdate','/action/uniController/update');loading('/action/uniController/read');"/>
                    </td>
                </tr>
            </table>

    </form>
</div>


<style type="text/css">
    #frm{
        margin:0;
        padding:10px 30px;
    }
    .ftitle{
        font-size:14px;
        font-weight:bold;
        padding:5px 0;
        margin-bottom:10px;
        border-bottom:1px solid #ccc;
    }
    .fitem{
        margin-bottom:5px;
    }
    .fitem label{
        display:inline-block;
        width:80px;
    }
    .fitem input{
        width:160px;
    }
</style>

</body>

</html>
