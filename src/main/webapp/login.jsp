<%--
  Created by IntelliJ IDEA.
  User: choewonjun
  Date: 20/10/2018
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<center>
    <h1>로그인</h1>
    <hr>
    <form action="login.do" method="post">
        <table border="1" cellpadding="0">
            <tr>
                <td bgcolor="orange">아이디</td>
                <td><input type="text" name="id"/></td>
            </tr>
            <tr>
                <td bgcolor="orange">비밀번호</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="로그인"/>
                </td>
            </tr>
        </table>
    </form>
    <hr>
</center>
</body>
</html>
