<%--
  Created by IntelliJ IDEA.
  User: choewonjun
  Date: 20/10/2018
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="biz.board.impl.BoardDAO" %>
<%@page import="biz.board.BoardVO" %>
<%@ page contentType="text/html;charset=EUC-KR" language="java" %>

<%
    // �˻��� �Խñ� ��ȣ ����
    String seq = request.getParameter("seq");

    // DB ���� ó��
    BoardVO vo = new BoardVO();
    vo.setSeq(Integer.parseInt(seq));

    BoardDAO boardDAO = new BoardDAO();
    BoardVO boardVO = boardDAO.getBoard(vo);

    // ���� ȭ�� ����
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>�� ��</title>
</head>
<body>
    <center>
        <h1>�� ��</h1>
        <a href="logout_proc.jsp">Log-out</a>
        <hr>
        <form action="updateBoard_proc.jsp" method="post">
            <input name="seq" type="hidden" value="<% boardVO.getSeq() %>"/>
            <table border="1" cellpadding="0" cellspacing="0">
                <tr>
                    <td bgcolor="orange" width="70">����</td>
                    <td align="left">
                        <input name="title" type="text" value="<%= boardVO.getTitle() %>"/>
                    </td>
                </tr>
                <tr>
                    <td bgcolor="orange">�ۼ���</td>
                    <td align="left">
                        <%= boardVO.getWriter() %>
                    </td>
                </tr>
                <tr>
                    <td bgcolor="orange">����</td>
                    <td align="left">
                        <textarea name="content" cols="40" rows="10"><%= boardVO.getContent() %></textarea>
                    </td>
                </tr>
                <tr>
                    <td bgcolor="orange">�����</td>
                    <td align="left">
                        <%= boardVO.getRegDate() %>
                    </td>
                </tr>
                <tr>
                    <td bgcolor="orange">��ȸ��</td>
                    <td align="left">
                        <%= boardVO.getCnt() %>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="�� ����"/>
                    </td>
                </tr>
            </table>
        </form>
        <hr>
        <a href="insertBoard.jsp">�� ���</a>&nbsp;&nbsp;&nbsp;
        <a href="deleteBoard_proc.jsp?seq=<%= boardVO.getSeq() %>">�� ����</a>&nbsp;&nbsp;&nbsp;
        <a href="getBoardList.jsp">�� ���</a>
    </center>
</body>
</html>
