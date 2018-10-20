<%--
  Created by IntelliJ IDEA.
  User: choewonjun
  Date: 20/10/2018
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="biz.board.impl.BoardDAO" %>
<%@page import="biz.board.BoardVO" %>
<%@ page contentType="text/html;charset=EUC-KR" language="java" %>
<%
    // 사용자 입력 정보 추출
    request.setCharacterEncoding("EUC-KR");
    String title = request.getParameter("title");
    String writer = request.getParameter("writer");
    String content = request.getParameter("content");

    // DB 연동 처리
    BoardVO vo = new BoardVO();
    vo.setTitle(title);
    vo.setWriter(writer);
    vo.setContent(content);

    BoardDAO boardDAO = new BoardDAO();
    boardDAO.insertBoard(vo);

    // 화면 네비게이션
    response.sendRedirect("getBoardList.jsp");
%>
