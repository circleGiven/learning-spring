<%--
  Created by IntelliJ IDEA.
  User: choewonjun
  Date: 20/10/2018
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="biz.board.BoardVO" %>
<%@ page import="biz.board.impl.BoardDAO" %>
<%@ page contentType="text/html;charset=EUC-KR" language="java" %>
<%
    // ����� �Է� ���� ����
    String seq = request.getParameter("seq");

    // DB ���� ó��
    BoardVO vo = new BoardVO();
    vo.setSeq(Integer.getInteger(seq));

    BoardDAO boardDAO = new BoardDAO();
    boardDAO.deleteBoard(vo);

    // ȭ�� �׺���̼�
    response.sendRedirect("getBoardList.jsp");
%>