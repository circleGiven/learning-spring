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
    <title>새글등록</title>
</head>
<body>
<center>
    <h1>글 등록</h1>
    <a href="logout.do">Log-out</a>
    <hr>
    <form action="insertBoard.do" method="post">
        <table border="1" cellspacing="0" cellpadding="0">
            <tr>
                <td bgcolor="orange" width="70">제목</td>
                <td align="left">
                    <input type="text" name="title"/>
                </td>
            </tr>
            <tr>
                <td bgcolor="orange">작성자</td>
                <td align="left">
                    <input type="text" name="writer" size="10"/>
                </td>
            </tr>
            <tr>
                <td bgcolor="orange">내용</td>
                <td align="left">
                    <textarea name="content" cols="40" rows="10"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="left">
                    <input type="submit" name=" 새글 등록 "/>
                </td>
            </tr>
        </table>
    </form>
    <hr>
    <a href="getBoardList.jsp">글 목록 가기</a>
</center>

</body>
</html>
