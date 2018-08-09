<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-edit',
        text: "添加",
        handler: function () {
            /*打开dialog*/
            $("#danner_add_dialog").dialog("open");
        }
    }, '-', {
        text: "修改",
        iconCls: 'icon-help',
        handler: function () {
            /*获取选中行*/
            var row = $("#dannerTab").edatagrid("getSelected");
            if (row != null) {
                /*把当前行变成可编辑模式*/
                var index = $("#dannerTab").edatagrid("getRowIndex", row);
                $("#dannerTab").edatagrid("editRow", index)
            } else {
                alert("请先选中行")
            }
        }
    }, '-', {
        text: "删除",
        iconCls: 'icon-help',
        handler: function () {
            /*删除当前选中行*/
            /*刷新页面*/
            var row = $("#dannerTab").edatagrid("getSelected");
            if (row != null) {
                /*把当前行变成可编辑模式*/
                $.ajax({
                    url: "${pageContext.request.contextPath}/danner/deleteDanner",
                    data: {
                        id: row.id
                    },
                    type: "post",
                    success: function () {
                        $('#dannerTab').edatagrid('reload');
                    }
                })
            } else {
                alert("请先选中行")
            }
        }
    }, '-', {
        text: "保存",
        iconCls: 'icon-help',
        handler: function () {
            $("#dannerTab").edatagrid("saveRow");
            var row = $("#dannerTab").edatagrid("getSelected");
            if (row != null) {
                $.ajax({
                    url: "${pageContext.request.contextPath}/danner/updateDanner",
                    data: {
                        id: row.id,
                        title: row.title,
                        status: row.status
                    },
                    type: "post",
                    success: function () {
                        $('#dannerTab').edatagrid('reload')
                    }
                })

            } else {
                alert("请先选中行")
            }

        }
    }]
    $(function () {
        //主显示
        $("#dannerTab").edatagrid({
            url: '${pageContext.request.contextPath}/danner/showAll',
            method: "post",
            columns: [[
                {field: 'id', title: '编号', width: 100, hidden: true},
                {
                    field: 'title', title: '名字', width: 100, editor: {
                    type: "text",
                }
                },
                {
                    field: 'status', title: '状态', width: 100, editor: {
                    type: "text",
                    options: {
                        required: true
                    }
                }
                },
                {field: 'createDate', title: '时间', width: 100, align: 'right'}
            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 20],
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.url + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.createDate + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },


        });
        //添加窗口
        $('#danner_add_dialog').dialog({
            title: '添加轮播图',
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
                    submit();
                    $('#danner_add_dialog').dialog('close');
                    $('#dannerTab').edatagrid('reload');

                }
            }, {
                text: '关闭',
                handler: function () {
                    $('#danner_add_dialog').dialog('close');
                }
            }]
        });
        //添加窗口的表单提交
        function submit() {
            $('#danner_add_form').form('submit', {
                url: "${pageContext.request.contextPath}/danner/addDanner"
            });

        }

    })
</script>
<table id="dannerTab"></table>
<div id="danner_add_dialog">
    <form id="danner_add_form" method="post" enctype="multipart/form-data">
        <div>
            <label for="title">title:</label>
            <input id="title" class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            <label for="desc">desc:</label>
            <input id="desc" class="easyui-validatebox" type="text" name="desc" data-options="required:true"/>
        </div>

        <select id="status" class="easyui-combobox" name="status" style="width:200px;">
            <option value="1">展示</option>
            <option value="0">不展示</option>
        </select>
        <input type="file" class="easyui-filebox" name="img" style="width:300px">
    </form>
</div>
