<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>

<head>
    <meta charset="utf-8"/>
    <title>تعریف درس</title>

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
    <%--<script type="text/javascript" src="/jquery-easyui-1.5.3/jquery.min.js"></script>--%>
    <%--<script type="text/javascript" src="/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>--%>
</head>

<body>

<div align="center">
    <a href="viewCourse.jsp">نمایش لیست دروس</a>
    <br/>
    <a href="/action/auth/logout">خروج</a>
<br/>

    <form id="frm" >

        <table border="1" cellpadding="5">
            <tr>
                <td><input class="easyui-validatebox" placeholder="حد اکثر اندازه 20 حرف می باشد" data-options="required:true,validType:['text','length[1,20]']" type="text" name="name"/></td>
                <th>نام</th>
            </tr>
            <tr>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'text'" type="number" name="unit"/></td>
                <th>تعداد واحد</th>
            </tr>

            <tr>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'text'" type="number" name="capacity"/></td>
                <th>ظرفیت</th>
            </tr>

            <%--<tr>--%>
                <%--<td>--%>
                    <%--<select class="easyui-combobox" name="teacher" style="width:200px;">--%>
                        <%--<c:forEach items="${sessionScope.teacherList}" var="teacher" >--%>
                            <%--<option value=${teacher.teacherId}>${teacher.name}</option>--%>
                        <%--</c:forEach>--%>
                    <%--</select>--%>
                    <%--<th>نام استاد</th>--%>
                <%--</td>--%>
            <%--</tr>--%>

            <tr>
                <td>
                <input class="easyui-tagbox" name="teacher" style="width:100%" data-options="
                url: '/action/courseController/getTagBox',
                method: 'get',
                valueField: 'teacherId',
                textField: 'name',
                limitToList: true,
                hasDownArrow: true,
                prompt: 'لطفا نام استاد را انتخاب کنید'
                ">
                </td>
                <th>نام اساتید</th>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="button" class="easyui-linkbutton" style="width: 100%" value="ثبت" onclick="newPersist();ldPersist();"/>
                </td>
            </tr>

        </table>

    </form>

</div>

<br/>

<div align="center">
<h3>فرم بروزرسانی</h3>

</div>

<div align="center">

    <form id="frmUpdate" >

        <table border="1" cellpadding="5">

                <tr>
                    <td>
                        <input class="easyui-combobox" name="courseId" style="width:100%" data-options="
                url: '/action/courseController/read',
                method: 'get',
                valueField: 'courseId',
                textField: 'name',
                limitToList: true,
                hasDownArrow: true,
                prompt: 'لطفا نام استاد را انتخاب کنید'
                ">
                    </td>
                    <th>نام دروس قابل انتخاب</th>
                </tr>


                <tr>
                <td><input class="easyui-validatebox" placeholder="حد اکثر اندازه 20 حرف می باشد"
                           data-options="required:true,validType:['text','length[1,20]']" type="text" name="name"/></td>
                <th>نام</th>
            </tr>
            <tr>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'text'" type="number" name="unit"/></td>
                <th>تعداد واحد</th>
            </tr>

            <tr>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'text'" type="number" name="capacity"/></td>
                <th>ظرفیت</th>
            </tr>

            <tr>
                <td>
                <input class="easyui-tagbox" name="teacher" style="width:100%" data-options="
                url: '/action/courseController/getTagBox',
                method: 'get',
                valueField: 'teacherId',
                textField: 'name',
                limitToList: true,
                hasDownArrow: true,
                prompt: 'لطفا نام استاد را انتخاب کنید'
                ">
                </td>
                <th>نام اساتید</th>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="button" class="easyui-linkbutton" style="width: 100%" value="بروزرسانی" onclick="update();ldPersist();"/>
                </td>
            </tr>

        </table>

    </form>


</div>

<script type="text/javascript">

    var url;
    function newPersist(){
        $('#frm').form('submit',{
            url: '/action/courseController/persist',
            onSubmit: function(){
                return $(this).form('validate');
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

    }

    function update(){
        $('#frmUpdate').form('submit',{
            url: '/action/courseController/update',
            onSubmit: function(){
                return $(this).form('validate');
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
    }

    function ldPersist() {
            $.post("/action/courseController/read", function(){});
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
