<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%@include file="/pages/common/common_head.jsp" %>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
    <script>
        //页面加载完成之后
        $(function () {
            //给注册绑定单机事件
            $("#sub_btn").click(function () {
                //验证用户名，必须由字母、数字、下划线组成，长度为5-12位
                //获取用户名输入框里的内容
                var usernameText = $("#username").val();
                //创建正则表达式对象
                // var usernamePatt = /^\w{5,12}$/;
                var usernamePatt = /^[a-zA-Z0-9\u4e00-\u9fa5]{2,10}$/;
                //验证
                if (!usernamePatt.test(usernameText)) {
                    //提示用户结果
                    $(".errorMsg").text("用户名不合法！");

                    return false;
                }

                //验证密码，必须由字母、数字、下划线组成，长度为5-12位
                //获取密码输入框里的内容
                var passwordText = $("#password").val();
                //创建正则表达式对象
                var passwordPatt = /^\w{5,12}$/;
                //验证
                if (!passwordPatt.test(passwordText)) {
                    //提示用户结果
                    $(".errorMsg").text("密码不合法！");

                    return false;
                }

                //验证确认密码：和密码相同
                //获取确认密码内容
                var repwdText = $("#repwd").val();
                //比较密码
                if (repwdText != passwordText) {
                    //提示用户结果
                    $(".errorMsg").text("密码不一致！");

                    return false;
                }

                //验证邮箱：xxx@xxx.com
                //获取邮箱里的内容
                var emailText = $("#email").val();
                //创建正则表达式
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                //验证邮箱
                if (!emailPatt.test(emailText)) {
                    $(".errorMsg").text("邮箱格式不合法！");

                    return false;
                }

                //验证码：目前只需要验证用户已输入
                var codeText = $("#code").val();
                //去电验证码前后空格
                codeText = $.trim(codeText);
                if (codeText == null || codeText == "") {
                    $(".errorMsg").text("验证码输入错误！");

                    return false;
                }

                $(".errorMsg").text("");
            });
        })

    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg"><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%></span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="register">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username"
                               value="<%=request.getAttribute("msg") == null ? "" : request.getAttribute("username")%>"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"
                               value="<%=request.getAttribute("msg") == null ? "" : request.getAttribute("password")%>"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"
                               value="<%=request.getAttribute("msg") == null ? "" : request.getAttribute("password")%>"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email"
                               value="<%=request.getAttribute("msg") == null ? "" : request.getAttribute("email")%>"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" name="code" style="width: 150px;" id="code"/>
                        <img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/common_footer.jsp" %>
</body>
</html>