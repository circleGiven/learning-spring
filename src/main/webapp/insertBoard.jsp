<%--
  Created by IntelliJ IDEA.
  User: choewonjun
  Date: 20/10/2018
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=EUC-KR" language="java" %>
<html>
<head>
    <title>���۵��</title>
</head>
<body>
<center>
    <h1>�� ���</h1>
    <a href="logout.do">Log-out</a>
    <hr>
    <form action="insertBoard.do" method="post">
        <table border="1" cellspacing="0" cellpadding="0">
            <tr>
                <td bgcolor="orange" width="70">����</td>
                <td align="left">
                    <input type="text" name="title"/>
                </td>
            </tr>
            <tr>
                <td bgcolor="orange">�ۼ���</td>
                <td align="left">
                    <input type="text" name="writer" size="10"/>
                </td>
            </tr>
            <tr>
                <td bgcolor="orange">����</td>
                <td align="left">
                    <textarea name="content" cols="40" rows="10"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="left">
                    <input type="submit" name=" ���� ��� "/>
                </td>
            </tr>
        </table>
    </form>
    <hr>
    <a href="getBoardList.jsp">�� ��� ����</a>
</center>

</body>
</html>
