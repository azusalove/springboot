<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/themes/IconExtension.css">
    <script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${ctx}/js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.edatagrid.js"></script>
    <script type="text/javascript">
        <!-- 添加新的Tab -->
        function addTabs(title, iconCls, href) {
            var check = $("#mainTab").tabs("exists", title);
            if (check) {
                $("#mainTab").tabs("select", title);
            } else {
                $('#mainTab').tabs('add', {
                    title: title,
                    selected: true,
                    closable: true,
                    iconCls: iconCls,
                    href: "${ctx}" + href
                });
            }
        }
    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        持名法州后台管理系统
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">
        欢迎您:${sessionScope.isLogin.name}
        &nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;
        <a href="${ctx}/admin/logout" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a>
    </div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;百知教育 bz@zparkhr.com.cn</div>
</div>

<div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    <div id="menu" class="easyui-accordion" data-options="fit:true">
        <c:forEach items="${requestScope.menuList}" var="p">
            <div title="${p.title}">
                <c:forEach items="${p.menus}" var="c">
                    <a href="JavaScript:void(0)" onclick="addTabs('${c.title}','${c.iconCls}','${c.href}')"
                       class="easyui-linkbutton" data-options="iconCls:'${c.iconCls}'">${c.title}</a><br/>
                </c:forEach>
            </div>
        </c:forEach>
    </div>
</div>
<div data-options="region:'center'">
    <div id="mainTab" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood'" style="background-image:url(${ctx}/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
</body>
</html>