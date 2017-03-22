<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/19
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>登陆页面</title>
    <link type="text/css" rel="stylesheet" href="resources/css/style.css" >
</head>
<body>
    <h1>登陆</h1>
    <form action="/user/login" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>密&nbsp;码：</td>
                <td> <input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>验证码：</td>
                <td><input type="text" name="validate" width="40"/><img src="/validate" alt="验证码" id="validate"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"> <input type="submit" value="登陆"> <a href="/user/reg">注册</a></td>
            </tr>
            <tr>
                <td colspan="2" align="center">${msg}</td>
            </tr>
        </table>
    </form>
</body>
</html>

