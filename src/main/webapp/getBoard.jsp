<%--
  Created by IntelliJ IDEA.
  User: choewonjun
  Date: 20/10/2018
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="biz.board.impl.BoardDAO" %>
<%@page import="biz.board.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // 검색할 게시글 번호 추출
    String seq = request.getParameter("seq");

    // DB 연동 처리
    BoardVO vo = new BoardVO();
    vo.setSeq(Integer.parseInt(seq));

    BoardDAO boardDAO = new BoardDAO();
    BoardVO boardVO = boardDAO.getBoard(vo);

    // 응답 화면 구성
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>글 상세</title>
</head>
<body>
    <center>
        <h1>글 상세</h1>
        <a href="logout_proc.jsp">Log-out</a>
        <hr>
        <form action="updateBoard_proc.jsp" method="post">
            <input name="seq" type="hidden" value="<% boardVO.getSeq() %>"/>
            <table border="1" cellpadding="0" cellspacing="0">
                <tr>
                    <td bgcolor="orange" width="70">제목</td>
                    <td align="left">
                        <input name="title" type="text" value="<%= boardVO.getTitle() %>"/>
                    </td>
                </tr>
                <tr>
                    <td bgcolor="orange">작성자</td>
                    <td align="left">
                        <%= boardVO.getWriter() %>
                    </td>
                </tr>
                <tr>
                    <td bgcolor="orange">내용</td>
                    <td align="left">
                        <textarea name="content" cols="40" rows="10"><%= boardVO.getContent() %></textarea>
                    </td>
                </tr>
                <tr>
                    <td bgcolor="orange">등록일</td>
                    <td align="left">
                        <%= boardVO.getRegDate() %>
                    </td>
                </tr>
                <tr>
                    <td bgcolor="orange">조회수</td>
                    <td align="left">
                        <%= boardVO.getCnt() %>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="글 수정"/>
                    </td>
                </tr>
            </table>
        </form>
        <hr>
        <a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
        <a href="deleteBoard_proc.jsp?seq=<%= boardVO.getSeq() %>">글 삭제</a>&nbsp;&nbsp;&nbsp;
        <a href="getBoardList.jsp">글 목록</a>
    </center>
</body>
</html>
