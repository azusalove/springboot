<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@ include file="../common/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>持名法州后台管理中心</title>

    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="icon" href="${ctx}/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${ctx}/css/common.css" type="text/css"/>
    <link rel="stylesheet" href="${ctx}/css/login.css" type="text/css"/>
    <script type="text/javascript" src="${ctx}/script/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/script/common.js"></script>
    <script type="text/javascript">

        $(function () {
            //点击更换验证码：
            $("#captchaImage").click(function () {//点击更换验证码
                var img = document.getElementById("captchaImage");
                img.src = "${ctx}/kaptcha.jpg?time=" + new Date().getTime();
            });

            //  form 表单提交
            $("#logButton").click(function () {
                //验证码Check！
                $.ajax({
                    url: "${ctx}/kaptchaCheck",
                    type: "post",
                    data: "enCode=" + $("#enCode").val(),
                    success: function (data) {
                        if (data == true) {
                            $("#loginForm").submit();
                        } else {
                            alert("验证码错误");
                        }
                    }
                })
            });
        });
    </script>
</head>
<body>

<div class="login">
    <form id="loginForm" action="${ctx}/admin/login" method="post">
        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="${ctx}/img/header_logo.gif"/>
                </td>
                <th>
                    用户名:
                </th>
                <td>
                    <input type="text" name="name" class="text" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input type="password" name="password" class="text" maxlength="20"
                           autocomplete="off"/>
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input type="text" id="enCode" name="enCode" class="text captcha" maxlength="5" autocomplete="off"/>
                    <img id="captchaImage" class="captchaImage" style="width: 120px" src="${ctx}/kaptcha.jpg"
                         title="点击更换验证码"/>
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
                <th>
                    &nbsp;
                </th>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="button" class="homeButton" value="" onclick="location.href='/'">
                    <input id="logButton" type="button" class="loginButton" value="登录">
                </td>
            </tr>
            </tbody>
        </table>
        <div class="powered">COPYRIGHT © 2008-2017.</div>
        <div class="link">
            <a href="http://www.chimingfowang.com/">持名佛网首页</a> |
            <a href="http://www.chimingbbs.com/">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
    </form>
</div>
</body>
</html>