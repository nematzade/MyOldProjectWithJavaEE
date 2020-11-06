<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>

<head>
    <meta charset="utf-8"/>
    <title>تعریف دانشگاه</title>

    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/themes/color.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/demo/demo.css">
    <script type="text/javascript" src="/jquery-easyui-1.5.3/jquery.min.js"></script>
    <script type="text/javascript" src="/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    <%--<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">--%>
    <%--<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>--%>
    <%--<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>--%>
</head>
<body>

<div align="center">

    <a href="viewTeller.jsp">نمایش لیست کارمند ها</a>
    <br/>
    <a href="../student/defineStudent.jsp">تعریف دانش آموز</a><br/>
    <br/>
    <a href="../course/defineCourse.jsp">تعریف درس</a><br/>
    <br/>
    <a href="/action/view/logout">خروج</a>

    <form id="frm" >

        <table border="1" cellpadding="5">
            <tr>
                <td><input class="easyui-validatebox" placeholder="حد اکثر اندازه 20 حرف می باشد" data-options="required:true,validType:'text'" type="text" name="name"/></td>
                <th>نام</th>
            </tr>
            <tr>
                <td><input  class="easyui-validatebox" placeholder="حد اکثر اندازه 20 حرف می باشد" data-options="required:true,validType:'text'" type="text" name="family"/></td>
                <th>نام خانوادگی</th>
            </tr>
            <tr>
                <td><input  class="easyui-validatebox" placeholder="حد اکثر اندازه 32 حرف می باشد" data-options="required:true,validType:'text'" type="password" name="pass"/></td>
                <th>رمز عبور</th>
            </tr>

            <tr>
                <td>
                    <select id="cc" class="easyui-combobox" name="uniId" style="width:200px;">
                        <c:forEach items="${sessionScope.uniList}" var="uni" >
                            <option value=${uni.uniId}>${uni.uniName}</option>
                        </c:forEach>
                    </select>
                </td>
                <th>نام دانشکده را انتخاب کنید</th>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="button" class="easyui-linkbutton" style="width: 100%" value="ثبت" onclick="newPersist()"/>
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
            <tr>
                <td>
                    <select class="easyui-combobox" name="tellerId" style="width:200px;">
                        <c:forEach items="${sessionScope.tellerList}" var="teller" >
                            <option value=${teller.tellerId}>${teller.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <th>نام کارمند را انتخاب کنید</th>
            </tr>


            <tr>
                <td><input class="easyui-validatebox" placeholder="حد اکثر اندازه 20 حرف می باشد" data-options="required:true,validType:'text'" type="text" name="name"/></td>
                <th>نام</th>
            </tr>
            <tr>
                <td><input  class="easyui-validatebox" placeholder="حد اکثر اندازه 20 حرف می باشد" data-options="required:true,validType:'text'" type="text" name="family"/></td>
                <th>نام خانوادگی</th>
            </tr>
            <tr>
                <td><input  class="easyui-validatebox" placeholder="حد اکثر اندازه 32 حرف می باشد" data-options="required:true,validType:'text'" type="password" name="pass"/></td>
                <th>رمز عبور</th>
            </tr>

            <tr>
                <td>
                    <select class="easyui-combobox" name="uniId" style="width:200px;">
                        <c:forEach items="${sessionScope.uniList}" var="uni" >
                            <option value=${uni.uniId}>${uni.uniName}</option>
                        </c:forEach>
                    </select>
                </td>
                <th>نام دانشکده را انتخاب کنید</th>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="button" class="easyui-linkbutton" style="width: 100%" value="ثبت" onclick="update()"/>
                </td>
            </tr>

        </table>

    </form>


</div>

<script type="text/javascript">

    var url;
    function newPersist(){
        $('#frm').form('submit',{
            url: '/action/tellerController/persist',
            onSubmit: function(){
                return $(this).form('validate');
                //todo:inja baressi shavad.
                alert("با موفقیت ذخیره شد.");
            },
            success: function(result){
                var result = eval('('+result+')');
                if (result.errorMsg){
                    $.messager.show({
                        title: 'دوباره سعی کنید...',
                        msg: result.errorMsg
                    });
                } else {
                    window.location.reload();

                }
            }
        });
        window.location.reload();
        window.location.reload();
    }


    function update(){
        $('#frmUpdate').form('submit',{
            url: '/action/tellerController/update',
            onSubmit: function(){
                return $(this).form('validate');
//                alert("با موفقیت ذخیره شد.");
            },
            success: function(result){
                var result = eval('('+result+')');
                if (result.errorMsg){
                    $.messager.show({
                        title: 'دوباره سعی کنید...',
                        msg: result.errorMsg
                    });
                } else {
                    window.location.reload();

                }
            }
        });
        window.location.reload();
        window.location.reload();
    }


</script>

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
