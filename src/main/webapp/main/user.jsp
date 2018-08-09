<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<script type="text/javascript">
    var toolbar = [{
        text: "批量添加",
        iconCls: 'icon-help',
        handler: function () {
            $("#user_multi_add_dialog").dialog("open");
        }

    }, '-', {
        text: "冻结",
        iconCls: 'icon-help',
        handler: function () {
            /*获取选中行*/
            var row = $("#userTab").datagrid("getSelected");
            if (row != null) {
                /*把当前行变成可编辑模式*/
                $.ajax({
                    url: "${pageContext.request.contextPath}/user/freeze",
                    data: {
                        id: row.id
                    },
                    type: "post",
                    success: function () {
                        $('#userTab').datagrid('reload');
                    }
                })
            } else {
                alert("请先选中行")
            }

        }
    }, '-', {
        text: "激活",
        iconCls: 'icon-help',
        handler: function () {
            /*获取选中行*/
            var row = $("#userTab").datagrid("getSelected");
            if (row != null) {
                /*把当前行变成可编辑模式*/
                $.ajax({
                    url: "${pageContext.request.contextPath}/user/active",
                    data: {
                        id: row.id
                    },
                    type: "post",
                    success: function () {
                        $('#userTab').datagrid('reload');
                    }
                })
            } else {
                alert("请先选中行")
            }
        }
    }, '-', {
        text: "批量下载",
        iconCls: 'icon-help',
        handler: function () {
            location.href = "${pageContext.request.contextPath}/user/download";
        }
    }]
    $(function () {
        //主显示
        $("#userTab").datagrid({
            url: '${pageContext.request.contextPath}/user/showAll',
            method: "post",
            columns: [[
                {field: 'name', title: '名字', width: 40},
                {field: 'dharma', title: '法号', width: 40},
                {field: 'sex', title: '性别', width: 20},
                {field: 'location', title: '地区', width: 50},
                {field: 'status', title: '状态', width: 20},
                {field: 'registDate', title: '注册时间', width: 50, align: 'right'}
            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 20],
            toolbar: toolbar
        });
        //添加批量窗口
        $('#user_multi_add_dialog').dialog({
            title: '添加用户',
            width: 400,
            height: 200,
            cache: false,
            modal: true,
            iconCls: 'icon-save',
            resizable: true,
            closed: true,
            buttons: [{
                text: '保存',
                handler: function () {
                    multiSubmit();
                    $('#user_multi_add_dialog').dialog('close');
                    $('#userTab').datagrid('reload')
                }
            }, {
                text: '关闭',
                handler: function () {
                    $('#user_multi_add_dialog').dialog('close');
                }
            }]
        });
        function multiSubmit() {
            $('#user_multi_add_form').form('submit', {
                url: "${pageContext.request.contextPath}/user/multiAdd"
            });

        }

    })
</script>
<table id="userTab"></table>
<div id="user_multi_add_dialog">
    <form id="user_multi_add_form" method="post" enctype="multipart/form-data">
        <input type="file" class="easyui-filebox" name="file" style="width:300px">
    </form>
</div>
