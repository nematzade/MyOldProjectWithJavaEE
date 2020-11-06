<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <%--<title>صفحه ورود</title>--%>
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/themes/mobile.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/themes/metro/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/themes/color.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.3/demo/demo.css">
    <script type="text/javascript" src="/jquery-easyui-1.5.3/jquery.min.js"></script>
    <script type="text/javascript" src="/jquery-easyui-1.5.3/jquery.easyui.mobile.js"></script>
    <script type="text/javascript" src="/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
</head>

<body style="margin-left:500px;margin-top: 100px">

<div  align="center" style="margin:20px 0;"></div>
<div  align="center" class="easyui-panel" title="ورود به سیستم" style="width:100%;max-width:400px;padding:30px 60px;" >

    <form action="j_security_check">
    <div style="margin-bottom:10px">
        <input class="easyui-textbox" name="j_username" style="width:100%;height:40px;padding:12px" data-options="prompt:'نام کابری',iconCls:'icon-man',iconWidth:38,required:true">
    </div>
    <div style="margin-bottom:20px">
        <input class="easyui-textbox" name="j_password" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'رمز عبور',iconCls:'icon-lock',iconWidth:38,required:true">
    </div>
    <%--<div style="margin-bottom:20px">--%>
        <%--<input type="checkbox" checked="checked">--%>
        <%--<span>Remember me</span>--%>
    <%--</div>--%>
    <div>
        <input type="submit" class="easyui-linkbutton" value="ورود" style="padding:5px 0px;width:100%;"/>
    </div>
    </form>
</div>

</body>
</html>
