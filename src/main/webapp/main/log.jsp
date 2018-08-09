<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: 'icon-edit',
            text: "导出日志",
            handler: function () {
                location.href = "${pageContext.request.contextPath}/log/export";
            }
        }]
        $("#logTabs").edatagrid({
            url: "${pageContext.request.contextPath}/log/showAll",
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 20],
            columns: [[
                {field: 'id', title: '日志编号', hidden: 'true'},
                {field: 'username', title: '操作人', align: 'center'},
                {field: 'createDate', title: '操作时间', align: 'right'},
                {field: 'record', title: '操作记录', align: 'right'},
                {field: 'arg', title: '操作状态', align: 'right'},
            ]],
            fitColumns: true,
            fit: true,
            toolbar: toolbar
        })
    })
</script>
<table id="logTabs"></table>
