<%--
  Created by IntelliJ IDEA.
  User: choewonjun
  Date: 20/10/2018
  Time: 6:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="biz.board.impl.BoardDAO" %>
<%@page import="biz.board.BoardVO" %>
<%@ page contentType="text/html;charset=EUC-KR" language="java" %>
<%
    // 사용자 입력 정보 추출
    request.setCharacterEncoding("EUC-KR");
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    String seq = request.getParameter("seq");

    // DB 연동 처리
    BoardVO vo = new BoardVO();
    vo.setTitle(title);
    vo.setContent(content);
    vo.setSeq(Integer.parseInt(seq));

    BoardDAO boardDAO = new BoardDAO();
    boardDAO.updateBoard(vo);

    // 화면 네비게이션
    response.sendRedirect("getBoardList.jsp");
%>