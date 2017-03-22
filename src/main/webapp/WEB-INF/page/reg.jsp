<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/19
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <link type="text/css" rel="stylesheet" href="../../resources/css/style.css" >
    <script type="text/javascript" src="../../resources/jquery-3.1.0.min.js"></script>
    <script type="text/javascript" src="../../resources/function.js"></script>
</head>
<body>
<h1>注册</h1>
<form action="/user/doReg" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="name" /><span id="name"></span></td>
        </tr>
        <tr>
            <td>密&nbsp;码：</td>
            <td> <input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input type="text" name="validate" width="40"/>
                <img src="/user/validate" alt="验证码" id="validate">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"> <input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
