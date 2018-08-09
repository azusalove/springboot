<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-edit',
        text: "专辑详情",
        handler: function () {
            var row = $("#albumTab").treegrid("getSelected");
            if (row.brief != null) {
                /*显示详情*/
                $("#album_desc_dialog").dialog("open");
                $("#album_desc_form").form("load", row);
                $("#album_img").prop("src", "${pageContext.request.contextPath}" + row.coverImg);
            } else {
                alert("请选中专辑");
            }

        }
    }, '-', {
        text: "添加专辑",
        iconCls: 'icon-help',
        handler: function () {
            $("#album_add_dialog").dialog("open");
            $("#album_add_form").form("clear");
        }
    }, '-', {
        text: "添加章节",
        iconCls: 'icon-help',
        handler: function () {
            var row = $("#albumTab").treegrid("getSelected");
            if (row != null) {
                if (row.brief != null) {
                    $("#chapter_add_dialog").dialog("open")
                    $("#album_id").val(row.id)
                } else {
                    alert("请选中专辑")
                }
            }

        }
    }, '-', {
        text: "下载音频",
        iconCls: 'icon-help',
        handler: function () {
            /*选中章节*/
            var row = $("#albumTab").treegrid("getSelected");
            if (row != null) {
                if (row.brief == null) {
                    location.href = "${pageContext.request.contextPath}/album/download?title=" + row.title + "&url=" + row.url
                } else {
                    alert("请选中章节")
                }
            }
        }
    }]

    $(function () {
        $('#albumTab').treegrid({
            onDblClickRow: function (row) {
                $("#audio_test_dialog").dialog("open");
                $("#audio_test").prop("src", "${pageContext.request.contextPath}/audio/" + row.url)
            },
            method: "get",
            url: '${pageContext.request.contextPath}/album/showAll',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'id', title: '编号', hidden: true},
                {field: 'title', title: '章节名字', width: 40},
                {field: 'size', title: '大小', width: 20},
                {field: 'url', title: '链接', width: 100},
                {field: 'coverImg', title: '封面', hidden: true}
            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 20],
            toolbar: toolbar
        });


        $('#album_add_dialog').dialog({
            title: '添加章节',
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
                    albumSubmit();
                    $('#album_add_dialog').dialog('close');
                    $('#albumTab').treegrid('reload')
                }
            }, {
                text: '关闭',
                handler: function () {
                    $('#album_add_dialog').dialog('close');
                }
            }]
        });

        $('#chapter_add_dialog').dialog({
            title: '添加章节',
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
                    $('#chapter_add_dialog').dialog('close');
                    $('#albumTab').treegrid('reload')
                }
            }, {
                text: '关闭',
                handler: function () {
                    $('#chapter_add_dialog').dialog('close');
                }
            }]
        });
    })

    function submit() {
        $('#chapter_add_form').form('submit', {
            url: "${pageContext.request.contextPath}/album/addChapter"
        });
    }
    function albumSubmit() {
        $('#album_add_form').form('submit', {
            url: "${pageContext.request.contextPath}/album/addAlbum"
        });
    }
</script>

<table id="albumTab"></table>

<div id="album_desc_dialog" class="easyui-dialog" title="专辑详细" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <form id="album_desc_form" method="post">
        <div>
            <input class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            <input class="easyui-validatebox" type="text" name="author" data-options="required:true"/>
        </div>
        <div>
            <input class="easyui-validatebox" type="text" name="brief" data-options="required:true"/>
        </div>
        <div>
            <img id="album_img" style="width: 50px;height:50px" src="">
        </div>
    </form>
</div>

<div id="album_add_dialog" class="easyui-dialog" title="添加专辑" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <form id="album_add_form" method="post" enctype="multipart/form-data">
        <div>
            专辑名：<input class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            作者：<input class="easyui-validatebox" type="text" name="author" data-options="required:true"/>
        </div>
        <div>
            简介：<input class="easyui-validatebox" type="text" name="brief" data-options="required:true"/>
        </div>
        <div>
            封面图：<input type="file" name="img" data-options="required:true"/>
        </div>
    </form>
</div>

<div id="chapter_add_dialog" class="easyui-dialog" title="添加章节" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true, ">
    <form id="chapter_add_form" method="post" enctype="multipart/form-data">
        <div>
            <input class="easyui-validatebox" type="hidden" id="album_id" name="albumId" data-options="required:true"/>
        </div>
        <div>
            <input class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>

        <input type="file" class="easyui-filebox" name="audio" style="width:300px">
    </form>
</div>

<div id="audio_test_dialog" class="easyui-dialog" title="音频试听" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <audio src="" id="audio_test" controls="controls"></audio>
</div>




