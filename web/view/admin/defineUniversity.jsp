<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <%--<script src="/common/jQuery-Message-Box/Simple-Pretty-jQuery-Message-Box-Plugin-messageBox/js/jquery.messagebox.js"></script>--%>
</head>
<body>
<div align="center" style="margin-top: 70px">
    <table id="dg" title="نام دانشگاه" class="easyui-datagrid" style="width:700px;height:250px;"
           url="/action/universityController/read"
           toolbar="#toolbar" pagination="true"
           rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
        <tr>
            <th field="universityId" width="50">شماره</th>
            <th field="universityName"  width="50">نام</th>
        </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">جدبد</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">ویرایش</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">حذف</a>
    </div>

    <div id="dlg" class="easyui-dialog" style="width:400px"
         closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">اطلاعات دانشگاه</div>
            <%--<div style="margin-bottom:10px">--%>
            <%--<input name="universityId" class="easyui-textbox" required="true" label="First Name:" style="width:100%">--%>
            <%--</div>--%>
            <div style="margin-bottom:10px">
                <input name="universityName" class="easyui-textbox" required="true" label="نام" style="width:100%">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">ذخیره</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">لغو</a>
    </div>

    <script type="text/javascript">
        var url;
        function newUser(){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','جدید');
            $('#fm').form('clear');
            url = '/action/universityController/persist';
        }

        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','ویرایش');
                $('#fm').form('load',row);
                url = '/action/universityController/update?universityId='+row.universityId;
            }
        }

        function saveUser(){
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');

                    if (result.errorMsg){
                        $.messager.show({
                            title: 'Error',
                            msg: result.errorMsg
                        });

                    } else {
                        $('#dlg').dialog('close');        // close the dialog
                        $('#dg').datagrid('reload');    // reload the user data
                    }
                }

            });
            $('#dlg').dialog('close');
            $('#dg').datagrid('reload');
            window.location.reload();
        }

        function destroyUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('اخطار','آیا اطمینان دارید؟',function(r){
                    if (r){
                        $.post('/action/universityController/delete',{universityId:row.universityId},function(result){
                            if (result.success){
                                $('#dg').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: result.errorMsg
                                });
                            }
                        },'json');
                        $('#dg').datagrid('reload');
                    }
                });
            }
        }
    </script>
</div>
</body>
</html>